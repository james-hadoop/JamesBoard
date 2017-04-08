package org.cboard.services;

import java.util.Map;

import org.cboard.dao.DatasetDao;
import org.cboard.dao.DatasourceDao;
import org.cboard.dataprovider.DataProvider;
import org.cboard.dataprovider.DataProviderManager;
import org.cboard.dto.DataProviderResult;
import org.cboard.pojo.DashboardDataset;
import org.cboard.pojo.DashboardDatasource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.alibaba.fastjson.JSONObject;
import com.google.common.base.Functions;
import com.google.common.collect.Maps;

/**
 * Created by yfyuan on 2016/8/15.
 */
@Repository
public class DataProviderService {

    @Value("${dataprovider.resultLimit:200000}")
    private int resultLimit;

    @Autowired
    private DatasourceDao datasourceDao;

    @Autowired
    private DatasetDao datasetDao;

    public ServiceStatus test(JSONObject dataSource, Map<String, String> query) {
        try {
            DataProvider dataProvider = DataProviderManager.getDataProvider(dataSource.getString("type"));
            dataProvider.getData(Maps.transformValues(dataSource.getJSONObject("config"), Functions.toStringFunction()), query);
            return new ServiceStatus(ServiceStatus.Status.Success, null);
        } catch (Exception e) {
            return new ServiceStatus(ServiceStatus.Status.Fail, e.getMessage());
        }
    }

    public DataProviderResult getData(Long datasourceId, Map<String, String> query, Long datasetId) {
        String[][] dataArray = null;
        int resultCount = 0;
        String msg = "1";
        // String cityName = null;
        // String cityId = null;
        // String user_id = authenticationService.getCurrentUser().getUserId();
        // List<DashboardUserCity> user_city = userDao.getUserCityList(user_id);

        if (datasetId != null) {
            Dataset dataset = getDataset(datasetId);
            datasourceId = dataset.getDatasourceId();
            query = dataset.getQuery();
        }
        DashboardDatasource datasource = datasourceDao.getDatasource(datasourceId);
        try {
            JSONObject config = JSONObject.parseObject(datasource.getConfig());
            DataProvider dataProvider = DataProviderManager.getDataProvider(datasource.getType());

            Map<String, String> parameterMap = null;
            if (null != config) {
                parameterMap = Maps.transformValues(config, Functions.toStringFunction());

                // String newQuery0 =
                // query.get("sql").replaceAll("\\$user\\.city_name", cityName);
                // newQuery0.replaceAll("\\$user\\.city_id", cityId);
                // Map<String, String> newQuery = new HashMap<String, String>();
                // newQuery.put("sql", newQuery0);
                resultCount = dataProvider.resultCount(parameterMap, query);
            } else {
                resultCount = dataProvider.resultCount(null, null);
            }
            if (resultCount > resultLimit) {
                msg = "Cube result count is " + resultCount + ", greater than limit " + resultLimit;
            } else {
                if (null != parameterMap) {
                    dataArray = dataProvider.getData(parameterMap, query);
                } else {
                    dataArray = dataProvider.getData(null, null);
                }
            }
        } catch (Exception e) {
            msg = e.getMessage();
            e.printStackTrace();
        }
        return new DataProviderResult(dataArray, msg, resultCount);
    }

    protected Dataset getDataset(Long datasetId) {
        return new Dataset(datasetDao.getDataset(datasetId));
    }

    protected class Dataset {
        private Long datasourceId;
        private Map<String, String> query;
        private Long interval;

        public Dataset(DashboardDataset dataset) {
            JSONObject data = JSONObject.parseObject(dataset.getData());
            this.query = Maps.transformValues(data.getJSONObject("query"), Functions.toStringFunction());
            this.datasourceId = data.getLong("datasource");
            this.interval = data.getLong("interval");
        }

        public Long getDatasourceId() {
            return datasourceId;
        }

        public void setDatasourceId(Long datasourceId) {
            this.datasourceId = datasourceId;
        }

        public Map<String, String> getQuery() {
            return query;
        }

        public void setQuery(Map<String, String> query) {
            this.query = query;
        }

        public Long getInterval() {
            return interval;
        }

        public void setInterval(Long interval) {
            this.interval = interval;
        }
    }
}

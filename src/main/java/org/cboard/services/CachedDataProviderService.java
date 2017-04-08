package org.cboard.services;

import com.alibaba.druid.sql.visitor.functions.Isnull;
import org.cboard.cache.CacheManager;
import org.cboard.dao.UserDao;
import org.cboard.dto.DataProviderResult;
import org.cboard.pojo.DashboardUserCity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * Created by yfyuan on 2016/8/24.
 */
@Repository
public class CachedDataProviderService extends DataProviderService {

    @Autowired
    private CacheManager<DataProviderResult> cacheManager;

    @Autowired
    private AuthenticationService authenticationService;

    @Autowired
    private UserDao userDao;

    public DataProviderResult getData(Long datasourceId, Map<String, String> query, Long datasetId, boolean reload) {
        String keys = null;
        if (datasetId != null) {
            keys = "dataset_" + datasetId.toString();
        } else {
            keys = "" + datasourceId + "_" + query.toString();
        }

        DataProviderResult o = null;
        if (reload || ((o = cacheManager.get(keys)) == null)) {
            synchronized (keys) {
                if (reload || ((o = cacheManager.get(keys)) == null)) {
                    DataProviderResult d = super.getData(datasourceId, query, datasetId);
                    long expire = 12 * 60 * 60 * 1000;
                    if (datasetId != null) {
                        Dataset dataset = super.getDataset(datasetId);
                        if (dataset.getInterval() != null && dataset.getInterval() > 0) {
                            expire = dataset.getInterval() * 1000;
                        }
                    }
                    cacheManager.put(keys, d, expire);
                    return filterData(d);
                } else {
                    return filterData(o);
                }
            }
        } else {
            return filterData(o);
        }
    }

    private DataProviderResult filterData(DataProviderResult t) {

        String user_id = authenticationService.getCurrentUser().getUserId();
        List<DashboardUserCity> user_city = userDao.getUserCityList(user_id);
        ArrayList<String> userCityList = new ArrayList<>();
        ArrayList<String[]> filterdata = new ArrayList<>();


        int k = Arrays.asList(t.getData()[0]).indexOf("城市");

        for (int i = 0; i < user_city.size(); i++) {
            userCityList.add(user_city.get(i).getCityName());
        }

        if (k >= 0) {

            filterdata.add(t.getData()[0]);

            for (int j = 1; j < t.getData().length; j++) {
                if (userCityList.indexOf(t.getData()[j][k]) >= 0) {
                    filterdata.add(t.getData()[j]);
                    userCityList.remove(userCityList.indexOf(t.getData()[j][k]));
                }
            }

        }


        if (!filterdata.isEmpty()) {
            String[][] data = new String[filterdata.size()][];
            for (int i = 0; i<filterdata.size();i++)
            {
                data[i] = filterdata.get(i);
            }
            return new DataProviderResult(data,t.getMsg(),t.getResultCount());
        }else
        {
            return t;
        }

    }
}

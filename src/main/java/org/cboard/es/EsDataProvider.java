package org.cboard.es;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpHost;
import org.apache.http.client.config.RequestConfig;
import org.cboard.dataprovider.DataProvider;
import org.cboard.dataprovider.annotation.ProviderName;
import org.elasticsearch.action.search.MultiSearchResponse;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.Response;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.transport.client.PreBuiltTransportClient;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Created by james on 2017/3/21.
 */
@ProviderName(name = "es")
public class EsDataProvider extends DataProvider {

    @Override
    public String[][] getData(Map<String, String> dataSource, Map<String, String> query) throws Exception {
        return getEsData2();
    }

    @Override
    public int resultCount(Map<String, String> dataSource, Map<String, String> query) throws Exception {
        return 10;
    }

    private String[][] getEsData() throws Exception {
        System.out.println("Hello Elasticsearch...");

        Settings settings = Settings.builder().put("cluster.name", "data-es").put("client.transport.sniff", true).build();
        TransportClient client;

        client = new PreBuiltTransportClient(settings).addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("JamesUbuntu"), 9300));

        // Class<?> clazz = Class.forName(TransportClient.class.getName());
        // Constructor<?> constructor =
        // clazz.getDeclaredConstructor(Settings.class);
        // constructor.setAccessible(true);
        // client = (TransportClient) constructor.newInstance(Settings.EMPTY);
        // client.addTransportAddress(new
        // InetSocketTransportAddress(InetAddress.getByName("s2-hadoop-test.esf.fdd"),
        // 9300));

        SearchRequestBuilder srb1 = client.prepareSearch().setQuery(QueryBuilders.queryStringQuery("")).setSize(10);
        SearchRequestBuilder srb2 = client.prepareSearch().setQuery(QueryBuilders.matchQuery("name", "Doe")).setSize(10);
        SearchRequestBuilder srb3 = client.prepareSearch().setQuery(QueryBuilders.matchQuery("address", "mill")).setSize(10);
        SearchRequestBuilder srb4 = client.prepareSearch().setQuery(QueryBuilders.matchAllQuery()).setSize(10);

        MultiSearchResponse sr = client.prepareMultiSearch().add(srb4)
        // .add(srb2)
                .get();

        // You will get all individual responses from
        // MultiSearchResponse#getResponses()
        long nbHits = 0;

        MultiSearchResponse.Item[] items = sr.getResponses();
        System.out.println("items.length=" + items.length);

        List<String[]> rows = new ArrayList<String[]>();
        for (MultiSearchResponse.Item item : items) {
            SearchResponse response = item.getResponse();
            nbHits = response.getHits().getTotalHits();
            System.out.println("nbHits=" + nbHits);

            SearchHits hits = response.getHits();
            Iterator<SearchHit> iterator = hits.iterator();
            while (iterator.hasNext()) {
                String record = iterator.next().getSourceAsString();
                // System.out.println("record: "+record);

                ObjectMapper mapper = new ObjectMapper();
                // mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,
                // false);

                try {
                    BankEntity entity = mapper.readValue(record, BankEntity.class);
                    // System.out.println(entity);
                    // System.out.println();

                    rows.add(entity.toStringArray());
                } catch (Exception e) {
                    System.out.println("mapper.readValue() exception caught...");
                    throw e;
                }
            }

            System.out.println();
        }

        for (String[] row : rows) {
            for (String field : row) {
                System.out.println(field);
            }
            System.out.println();
        }
        System.out.println();

        if (null != client) {
            client.close();
        }

        // List<String[]> rows = new ArrayList<String[]>();
        // String[] title =new String[]{"name","age","title"};
        // String[] row=new String[]{"james","18","software engineer"};
        //
        // rows.add(title);
        // rows.add(row);

        System.out.println("Bye Elasticsearch...");

        return rows.toArray(new String[][] {});
    }

    private String[][] getEsData2() throws UnsupportedOperationException, IOException {
        System.out.println("Hello Elasticsearch...");

        RestClient restClient = RestClient.builder(new HttpHost("10.12.21.132", 9200)).setRequestConfigCallback(new RestClientBuilder.RequestConfigCallback() {
            @Override
            public RequestConfig.Builder customizeRequestConfig(RequestConfig.Builder requestConfigBuilder) {
                return requestConfigBuilder.setConnectTimeout(5000).setSocketTimeout(60000);
            }
        }).setMaxRetryTimeoutMillis(60000).build();

        Response response = restClient.performRequest("GET", "/bank/_search", Collections.singletonMap("pretty", "true"));
        // System.out.println(EntityUtils.toString(response.getEntity()));

        // parse response
        InputStream in = response.getEntity().getContent();
        String result = IOUtils.toString(in, "UTF-8");
        System.out.println("result: " + result);

        JSONObject jSONObject = JSONObject.fromObject(result);
        System.out.println("jSONObject: " + jSONObject);

        Object hits = jSONObject.getString("hits");
        System.out.println("hits: " + hits);

        Object hitsChildren = JSONObject.fromObject(hits).get("hits");
        System.out.println("hitsChildren: " + hitsChildren);

        JSONArray jsonArray = JSONArray.fromObject(hitsChildren);
        System.out.println("jsonArray: " + jsonArray);
        System.out.println("\n\n--------for--------\n\n");

        List<BankEntity> entities = new ArrayList<BankEntity>();
        List<String[]> rows = new ArrayList<String[]>();
        BankEntity bankEntityTitle = new BankEntity();
        bankEntityTitle.setAccount_number("account_number");
        bankEntityTitle.setBalance("balance");
        bankEntityTitle.setFirstname("firstname");
        bankEntityTitle.setLastname("lastname");
        bankEntityTitle.setAge("age");
        bankEntityTitle.setGender("gender");
        bankEntityTitle.setAddress("address");
        bankEntityTitle.setEmployer("employer");
        bankEntityTitle.setCity("city");
        bankEntityTitle.setState("state");
        rows.add(bankEntityTitle.toStringArray());

        for (int i = 0; i < jsonArray.size(); i++) {
            System.out.println(jsonArray.getString(i));

            JSONObject source = JSONObject.fromObject(JSONObject.fromObject(jsonArray.getString(i)).getString("_source"));
            System.out.println("source: " + source);

            BankEntity bankEntity = new BankEntity();
            bankEntity.setAccount_number(source.getString("account_number"));
            bankEntity.setBalance(source.getString("balance"));
            bankEntity.setFirstname(source.getString("firstname"));
            bankEntity.setLastname(source.getString("lastname"));
            bankEntity.setAge(source.getString("age"));
            bankEntity.setGender(source.getString("gender"));
            bankEntity.setAddress(source.getString("address"));
            bankEntity.setEmployer(source.getString("employer"));
            bankEntity.setCity(source.getString("city"));
            bankEntity.setState(source.getString("state"));
            entities.add(bankEntity);
            rows.add(bankEntity.toStringArray());
        }

        restClient.close();

        // System.out.println("\n\n--------entities--------\n\n");
        // for (BankEntity entity : entities) {
        // System.out.println("entity: " + entity);
        // }

        System.out.println("rows.size()=" + rows.size());
        System.out.println("Bye Elasticsearch...");

        return rows.toArray(new String[][] {});
    }
}

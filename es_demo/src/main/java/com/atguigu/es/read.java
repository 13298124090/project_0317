package com.atguigu.es;

import io.searchbox.client.JestClient;
import io.searchbox.client.JestClientFactory;
import io.searchbox.client.config.HttpClientConfig;
import io.searchbox.core.Search;
import io.searchbox.core.SearchResult;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class read {
    public static void main(String[] args) throws IOException {
        //1.����ES�ͻ������ӳ�
        JestClientFactory factory = new JestClientFactory();

        //2.����ES�ͻ������ӵ�ַ
        HttpClientConfig httpClientConfig = new HttpClientConfig.Builder("http://hadoop202:9200").build();

        //3.����ES���ӵ�ַ
        factory.setHttpClientConfig(httpClientConfig);

        //4.��ȡES�ͻ�������
        JestClient jestClient = factory.getObject();

        //5.������ѯ���ݶ���
        Search search = new Search.Builder("{\n" +
                "  \"query\": {\n" +
                "    \"bool\": {\n" +
                "      \"filter\": {\n" +
                "        \"term\": {\n" +
                "          \"sex\": \"male\"\n" +
                "        }\n" +
                "      },\n" +
                "      \"must\": [\n" +
                "        {\n" +
                "          \"match\": {\n" +
                "            \"favo\": \"�٤��\"\n" +
                "          }\n" +
                "        }\n" +
                "      ]\n" +
                "    }\n" +
                "  }\n" +
                "}").addIndex("student1").addType("_doc").build();

        //6.ִ�в�ѯ����
        SearchResult searchResult = jestClient.execute(search);

        //7.������ѯ���
        System.out.println(searchResult.getTotal());
        List<SearchResult.Hit<Map, Void>> hits = searchResult.getHits(Map.class);
        for (SearchResult.Hit<Map, Void> hit : hits) {
            System.out.println(hit.index + "--" + hit.id);
            System.out.println(hit.id + "--" + hit.source);
        }

        //8.�ر�����
        jestClient.shutdownClient();
    }
}

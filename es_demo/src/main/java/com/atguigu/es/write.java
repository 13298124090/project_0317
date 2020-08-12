package com.atguigu.es;

import io.searchbox.client.JestClient;
import io.searchbox.client.JestClientFactory;
import io.searchbox.client.config.HttpClientConfig;
import io.searchbox.core.Index;

import java.io.IOException;


public class write {
    public static void main(String[] args) throws IOException {
        //1����ES�ͻ���
        JestClientFactory factory = new JestClientFactory();

        //2����ES�ͻ������ӵ�ַ
        HttpClientConfig httpClientConfig = new HttpClientConfig.Builder("http://hadoop202:9200").build();

        //3����ES���ӵ�ַ
        factory.setHttpClientConfig(httpClientConfig);
        //4��ȡE�ͻ�������
        JestClient jectClient = factory.getObject();
        //5.����ES�������ݶ���
        Index index = new Index.Builder(
                "{" +
                "\n" + "  \"id\":\"003\"," +
                "\n" + "  \"name\":\"zhangsan\"," +
                "\n" + "  \"sex\":\"male\"," +
                "\n" + "  \"birth\":\"2020-08-10\"      " +
                "}").index("stu1").type("_doc").id("3").build();
        //6.ִ�в������ݲ���
        jectClient.execute(index);

        //7.�ر�����
        jectClient.shutdownClient();
    }
}

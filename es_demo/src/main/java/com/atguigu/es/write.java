package com.atguigu.es;

import io.searchbox.client.JestClient;
import io.searchbox.client.JestClientFactory;
import io.searchbox.client.config.HttpClientConfig;
import io.searchbox.core.Index;

import java.io.IOException;


public class write {
    public static void main(String[] args) throws IOException {
        //1创建ES客户端
        JestClientFactory factory = new JestClientFactory();

        //2创建ES客户端连接地址
        HttpClientConfig httpClientConfig = new HttpClientConfig.Builder("http://hadoop202:9200").build();

        //3设置ES连接地址
        factory.setHttpClientConfig(httpClientConfig);
        //4获取E客户端连接
        JestClient jectClient = factory.getObject();
        //5.构建ES插入数据对象
        Index index = new Index.Builder(
                "{" +
                "\n" + "  \"id\":\"003\"," +
                "\n" + "  \"name\":\"zhangsan\"," +
                "\n" + "  \"sex\":\"male\"," +
                "\n" + "  \"birth\":\"2020-08-10\"      " +
                "}").index("stu1").type("_doc").id("3").build();
        //6.执行插入数据操作
        jectClient.execute(index);

        //7.关闭连接
        jectClient.shutdownClient();
    }
}

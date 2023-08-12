package com.lhp47.chatbot.api.test;


import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import java.io.IOException;

public class ApiTest {

    @Test
    public void queryUnansweredQuestions() throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        HttpGet get = new HttpGet("https://api.zsxq.com/v2/groups/28885518425541/topics?scope=all&count=20");

        get.addHeader("cookie", "zsxq_access_token=2025050D-907E-FE6F-14C4-A71525CAF1AC_DC1BF2040B4CF0E1; zsxqsessionid=d61a97f34c55191b03fd7cfd52b758e8; abtest_env=product; sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%22189affe7a8c8e9-04e53dbc279c8cc-7c546c76-1327104-189affe7a8d3f9%22%2C%22first_id%22%3A%22%22%2C%22props%22%3A%7B%7D%2C%22identities%22%3A%22eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMTg5YWZmZTdhOGM4ZTktMDRlNTNkYmMyNzljOGNjLTdjNTQ2Yzc2LTEzMjcxMDQtMTg5YWZmZTdhOGQzZjkifQ%3D%3D%22%2C%22history_login_id%22%3A%7B%22name%22%3A%22%22%2C%22value%22%3A%22%22%7D%2C%22%24device_id%22%3A%22189affe7a8c8e9-04e53dbc279c8cc-7c546c76-1327104-189affe7a8d3f9%22%7D; sajssdk_2015_cross_new_user=1");
        get.addHeader("Content-type", "application/json; charset=UTF-8");

        CloseableHttpResponse response = httpClient.execute(get);
        if(response.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
            String res = EntityUtils.toString(response.getEntity());
            System.out.println(res);
        }else{
            System.out.println(response.getStatusLine().getStatusCode());
        }

    }
    @Test
    public void comment() throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        HttpPost post = new HttpPost("https://api.zsxq.com/v2/topics/411885524182488/comments");

        post.addHeader("cookie", "zsxq_access_token=2025050D-907E-FE6F-14C4-A71525CAF1AC_DC1BF2040B4CF0E1; zsxqsessionid=d61a97f34c55191b03fd7cfd52b758e8; abtest_env=product; sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%22189affe7a8c8e9-04e53dbc279c8cc-7c546c76-1327104-189affe7a8d3f9%22%2C%22first_id%22%3A%22%22%2C%22props%22%3A%7B%7D%2C%22identities%22%3A%22eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMTg5YWZmZTdhOGM4ZTktMDRlNTNkYmMyNzljOGNjLTdjNTQ2Yzc2LTEzMjcxMDQtMTg5YWZmZTdhOGQzZjkifQ%3D%3D%22%2C%22history_login_id%22%3A%7B%22name%22%3A%22%22%2C%22value%22%3A%22%22%7D%2C%22%24device_id%22%3A%22189affe7a8c8e9-04e53dbc279c8cc-7c546c76-1327104-189affe7a8d3f9%22%7D; sajssdk_2015_cross_new_user=1");
        post.addHeader("Content-Type", "application/json; charset=UTF-8");

        String paramJson = "{\n" +
                "  \"text\": \"NO\\n\",\n" +
                "  \"image_ids\": [],\n" +
                "  \"mentioned_user_ids\": []\n" +
                "}";

        StringEntity stringEntity = new StringEntity(paramJson, ContentType.create("text/json", "UTF-8"));
        post.setEntity(stringEntity);

        CloseableHttpResponse response = httpClient.execute(post);
        if(response.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
            String res = EntityUtils.toString(response.getEntity());
            System.out.println(res);
        }else{
            System.out.println(response.getStatusLine().getStatusCode());
        }
    }

    @Test
    public void testChatGPT() throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        HttpPost post = new HttpPost("");

        post.addHeader("Content-Type", "Content-Type: application/json");
        post.addHeader("Authorization","Bearer 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");
        //请求信息
        String param = "{\n" +
                "     \"model\": \"gpt-3.5-turbo\",\n" +
                "     \"messages\": [{\"role\": \"user\", \"content\": \"Say this is a test!\"}],\n" +
                "     \"temperature\": 1024";

        CloseableHttpResponse response = httpClient.execute(post);
        if(response.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
            String res = EntityUtils.toString(response.getEntity());
            System.out.println(res);
        }else{
            System.out.println(response.getStatusLine().getStatusCode());
        }


    }
}

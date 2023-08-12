package com.lhp47.chatbot.api.domain.openai.service;

import com.alibaba.fastjson.JSON;
import com.lhp47.chatbot.api.domain.openai.IOpenAI;
import com.lhp47.chatbot.api.domain.openai.model.aggregates.AIAnswer;
import com.lhp47.chatbot.api.domain.openai.model.vo.Choices;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

import java.io.IOException;
import java.util.List;

public class OpenAI implements IOpenAI {

    private Logger logger = LoggerFactory.getLogger(OpenAI.class);

    @Value("${chatbot-api.openAIKey}")
    private String openAIKey;

    @Override
    public String doChatGPT(String question) throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        HttpPost post = new HttpPost("");

        post.addHeader("Content-Type", "Content-Type: application/json");
        post.addHeader("Authorization", "Bearer" + openAIKey);
        //请求信息
        String param = "{\n" +
                "     \"model\": \"gpt-3.5-turbo\",\n" +
                "     \"messages\": [{\"role\": \"user\", \"content\": \"" + question + "\"}],\n" +
                "     \"temperature\": 1024";

        CloseableHttpResponse response = httpClient.execute(post);
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            String jsonStr = EntityUtils.toString(response.getEntity());
            AIAnswer aiAnswer = JSON.parseObject(jsonStr, AIAnswer.class);
            StringBuilder answer = new StringBuilder();
            List<Choices> choices = aiAnswer.getChoices();
            for(Choices choice : choices) {
                answer.append(choice.getText());
            }
            return answer.toString();
        } else {
            throw new RuntimeException("api.openai.com Err code is " + response.getStatusLine().getStatusCode());
        }
    }
}

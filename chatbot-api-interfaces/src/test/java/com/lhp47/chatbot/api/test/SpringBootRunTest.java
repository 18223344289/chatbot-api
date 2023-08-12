package com.lhp47.chatbot.api.test;

import com.alibaba.fastjson.JSON;
import com.lhp47.chatbot.api.domain.openai.service.OpenAI;
import com.lhp47.chatbot.api.domain.zsxq.IZsxqApi;
import com.lhp47.chatbot.api.domain.zsxq.model.aggregates.UnansweredQuestionsAggregates;
import com.lhp47.chatbot.api.domain.zsxq.model.vo.Topics;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;

@SpringBootTest
public class SpringBootRunTest {

    private Logger logger = LoggerFactory.getLogger(SpringBootRunTest.class);

    @Value("${chatbot-api.groupId}")
    private String groupId;
    @Value("${chatbot-api.cookie}")
    private String cookie;

    @Resource
    private IZsxqApi zsxqApi;

    @Resource
    private OpenAI openAI;

    @Test
    public void testZsxqApi() throws IOException {
        UnansweredQuestionsAggregates unansweredQuestionsAggregates = zsxqApi.queryUnansweredQuestionsTopicId(groupId, cookie);
        logger.info("测试结果: {}", JSON.toJSONString(unansweredQuestionsAggregates));

        List<Topics> topics = unansweredQuestionsAggregates.getResp_data().getTopics();
        for(Topics topic : topics){
            String topicId = topic.getTopic_id();
            String text = topic.getQuestion().getText();
            logger.info("topicId: {} text: {}", topicId, text);

            //回答问题
            zsxqApi.answer(groupId, cookie, topicId, text, false);
        }
    }

    @Test
    public void testOpenAI() throws IOException {
        String response = openAI.doChatGPT("帮我写个冒泡排序");
        logger.info("测试结果 :{}", response);
    }
}

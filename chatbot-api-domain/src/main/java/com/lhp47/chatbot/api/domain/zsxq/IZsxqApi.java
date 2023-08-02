package com.lhp47.chatbot.api.domain.zsxq;

import com.lhp47.chatbot.api.domain.zsxq.model.aggregates.UnansweredQuestionsAggregates;

import java.io.IOException;

/*知识星球API*/
public interface IZsxqApi {
    UnansweredQuestionsAggregates queryUnansweredQuestionsTopicId(String groupId, String cookie) throws IOException;

    boolean answer(String groupId, String cookie, String topicId, String text, boolean silenced) throws IOException;

}

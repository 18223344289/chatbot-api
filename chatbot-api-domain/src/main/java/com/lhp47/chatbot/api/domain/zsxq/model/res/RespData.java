package com.lhp47.chatbot.api.domain.zsxq.model.res;

//结果数据

import com.lhp47.chatbot.api.domain.zsxq.model.vo.Topics;

import java.util.List;

public class RespData {
    private List<Topics> topics;

    public List<Topics> getTopics() {
        return topics;
    }

    public void setTopics(List<Topics> topics) {
        this.topics = topics;
    }

}

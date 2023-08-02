package com.lhp47.chatbot.api.domain.zsxq.model.req;

import com.lhp47.chatbot.api.domain.zsxq.model.vo.Topics;

import java.util.List;

//请求结果数据
public class ReqData {

    private List<Topics> topics;

    public List<Topics> getTopics(){
        return topics;
    }

    public void setTopics(List<Topics> topics){
        this.topics = topics;
    }
}

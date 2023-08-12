package com.lhp47.chatbot.api.domain.openai.model.aggregates;

import com.lhp47.chatbot.api.domain.openai.model.vo.Choices;

import java.util.List;

public class AIAnswer {

    private String id;

    private String object;

    private int create;

    private String model;

    private List<Choices> choices;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public int getCreate() {
        return create;
    }

    public void setCreate(int create) {
        this.create = create;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public List<Choices> getChoices() {
        return choices;
    }

    public void setChoices(List<Choices> choices) {
        this.choices = choices;
    }
}

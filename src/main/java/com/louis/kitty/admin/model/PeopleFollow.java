package com.louis.kitty.admin.model;

import java.util.LinkedList;

public class PeopleFollow {
    int id;
    LinkedList<FlowContent> flowContent;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LinkedList<FlowContent> getFlowContent() {
        return flowContent;
    }

    public void setFlowContent(LinkedList<FlowContent> flowContent) {
        this.flowContent = flowContent;
    }
}

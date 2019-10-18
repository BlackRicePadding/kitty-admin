package com.louis.kitty.admin.model;

import java.util.LinkedList;

public class FollowTwo {
    int id;
    String name;
    String sort;
    String pid;
    String content;
    LinkedList<FollowThree> child;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LinkedList<FollowThree> getChild() {
        return child;
    }

    public void setChild(LinkedList<FollowThree> child) {
        this.child = child;
    }
}

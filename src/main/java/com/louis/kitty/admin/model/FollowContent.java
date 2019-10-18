package com.louis.kitty.admin.model;

import java.util.List;

public class FollowContent {

    String objId;
    List<FollowContentItem> content;

    public String getObjId() {
        return objId;
    }

    public void setObjId(String objId) {
        this.objId = objId;
    }

    public List<FollowContentItem> getContent() {
        return content;
    }

    public void setContent(List<FollowContentItem> content) {
        this.content = content;
    }
}

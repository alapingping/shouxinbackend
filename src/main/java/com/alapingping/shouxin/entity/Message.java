package com.alapingping.shouxin.entity;

import com.alibaba.fastjson.annotation.JSONField;

import java.sql.Timestamp;

public class Message {

    private String username;
    private String content;
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Timestamp time;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

}

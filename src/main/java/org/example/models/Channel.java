package org.example.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
public class Channel {
    @Id
    private String id;
    private String name;
    private List<String> messageIds;

    public Channel() {}
    public Channel(String name){
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getMessageIds() {
        return messageIds;
    }

    public void setMessageIds(List<String> messageIds) {
        this.messageIds = messageIds;
    }
}
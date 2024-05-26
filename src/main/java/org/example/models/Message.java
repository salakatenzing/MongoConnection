package org.example.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Message {
    @Id
    private String id;
    private String content;
    private String senderId;
    private String channelId;


    public Message() {
    }

    public Message(String content, String senderId, String channelId) {
        this.content = content;
        this.senderId = senderId;
        this.channelId = channelId;

    }

    public Message(String content, String channelId) {
        this.content = content;
        this.channelId = channelId;
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSenderId() {
        return senderId;
    }

    public void setSenderId(String senderId) {
        this.senderId = senderId;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    // toString method for debugging
    @Override
    public String toString() {
        return "Message{" +
                "id='" + id + '\'' +
                ", content='" + content + '\'' +
                ", senderId='" + senderId + '\'' +
                ", chatRoomId='" + channelId + '\'' +
                '}';
    }
}

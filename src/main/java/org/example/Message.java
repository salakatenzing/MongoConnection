package org.example;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Message {
    @Id
    private String id;
    private String content;
    private String senderId;
    private String chatRoomId;

    // Getters and setters


    public Message() {
    }

    public Message(String content, String senderId, String chatRoomId) {
        this.content = content;
        this.senderId = senderId;
        this.chatRoomId = chatRoomId;

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

    public String getChatRoomId() {
        return chatRoomId;
    }

    public void setChatRoomId(String chatRoomId) {
        this.chatRoomId = chatRoomId;
    }



    // toString method for debugging
    @Override
    public String toString() {
        return "Message{" +
                "id='" + id + '\'' +
                ", content='" + content + '\'' +
                ", senderId='" + senderId + '\'' +
                ", chatRoomId='" + chatRoomId + '\'' +
                '}';
    }
}

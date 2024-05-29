package org.example.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.models.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class WebSocketService {

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

//    public void broadcastMessage(String destination, Message message) {
//        try {
//            messagingTemplate.convertAndSend(destination, message);
//        } catch (Exception e) {
//            // Log the error or implement a retry mechanism
//            System.err.println("Failed to send message: " + e.getMessage());
//        }
//    }
public void broadcastMessage(String channelId, Message message) {
    try {
        String destination = "/topic/messages/" + channelId;
        String jsonMessage = new ObjectMapper().writeValueAsString(message);
        messagingTemplate.convertAndSend(destination, jsonMessage);
        System.out.println("Broadcasted message to " + destination + ": " + jsonMessage);
    } catch (Exception e) {
        System.err.println("Failed to send message: " + e.getMessage());
        e.printStackTrace();
    }
}

}

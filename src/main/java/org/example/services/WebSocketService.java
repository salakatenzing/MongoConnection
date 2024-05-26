package org.example.services;

import org.example.models.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class WebSocketService {
    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    public void broadcastMessage(String destination, Message message) {
        try {
            messagingTemplate.convertAndSend(destination, message);
        } catch (Exception e) {
            // Log the error or implement a retry mechanism
            System.err.println("Failed to send message: " + e.getMessage());
        }
    }

}

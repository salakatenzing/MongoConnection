package org.example.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.models.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

    @Autowired
    private WebSocketService webSocketService;

    private final ObjectMapper objectMapper = new ObjectMapper();

    @KafkaListener(topics = "chat-messages", groupId = "chat-app")
    public void handleMessageFromKafka(String messageJson) {
        try {
            Message message = objectMapper.readValue(messageJson, Message.class);
            webSocketService.broadcastMessage("/topic/messages", message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

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

//    @KafkaListener(topics = "messages", groupId = "chat-app")
//    public void handleMessageFromKafka(String messageJson) {
//        try {
////            System.out.println("Received Kafka message: " + messageJson); // Log the raw JSON
//            Message message = objectMapper.readValue(messageJson, Message.class);
////            System.out.println("Converted Message object: " + message); // Log the deserialized Message object
//            webSocketService.broadcastMessage("/topic/messages", message);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
@KafkaListener(topics = "messages", groupId = "chat-app")
public void handleMessageFromKafka(String messageJson) {
    try {
        Message message = objectMapper.readValue(messageJson, Message.class);
        if (message.getChannelId() != null) {
            webSocketService.broadcastMessage(message.getChannelId(), message);
        } else {
            System.err.println("Channel ID is null for the message: " + messageJson);
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}



}

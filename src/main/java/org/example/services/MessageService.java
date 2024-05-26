package org.example.services;

import org.example.repository.MessageRepository;
import org.example.models.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;
    @Autowired
    private MessageRepository messageRepository;

    public void sendMessage(String channelId, String messageContent) {
        Message message = new Message(messageContent, channelId);
        kafkaTemplate.send("channelMessages", channelId, messageContent);
        messageRepository.save(message); // Saves to MongoDB
    }

    @KafkaListener(topics = "channelMessages", groupId = "chat")
    public void listenGroupChat(String message) {
        System.out.println("Received Message in group 'chat': " + message);
        // Additional processing logic
    }
}

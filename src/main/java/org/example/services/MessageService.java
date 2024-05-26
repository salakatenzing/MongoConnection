package org.example.services;

import org.example.repository.MessageRepository;
import org.example.models.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;
    @Autowired
    private MessageRepository messageRepository;

    public void sendMessage(String content, String senderId, String channelId) {
        Message message = new Message(content, senderId, channelId);

        // Serialize the message object or its content to JSON, if necessary
        String messageJson = convertMessageToJson(message);

        // Send the message to Kafka
        //kafkaTemplate sends messages to Kafka topics
        kafkaTemplate.send("channelMessages", channelId, messageJson);

        // Save the message to MongoDB
        messageRepository.save(message);
    }


 //topic is channelMessages with groupId chat
    @KafkaListener(topics = "channelMessages", groupId = "chat")
    public void listenGroupChat(String message) {
        System.out.println("Received Message in group 'chat': " + message);
        // Additional processing logic
    }

    public List<Message> getMessagesByChannelId(String channelId) {
        return messageRepository.findByChannelId(channelId);
    }

    private String convertMessageToJson(Message message) {
        return "{\"content\": \"" + message.getContent() +
                "\", \"senderId\": \"" + message.getSenderId() +
                "\", \"channelId\": \"" + message.getChannelId() + "\"}";
    }

}

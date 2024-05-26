package org.example.repository;

import org.example.models.Message;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface MessageRepository extends MongoRepository<Message, String> {
    List<Message> findByChannelId(String channelId);
    // Custom database queries can be defined here
}
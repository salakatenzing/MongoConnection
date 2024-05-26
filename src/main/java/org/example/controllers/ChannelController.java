package org.example.controllers;

import org.example.models.Message;
import org.example.services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/channels")
public class ChannelController {

    @Autowired
    private MessageService messageService;

    // Endpoint to post a new message to a specific channel
    @PostMapping("/{channelId}/messages")
    public ResponseEntity<?> postMessage(@PathVariable String channelId, @RequestBody Message message) {
        // Ensure the channelId is correctly set on the message before sending
        message.setChannelId(channelId);
        messageService.sendMessage(message.getContent(), message.getSenderId(), channelId);
        return ResponseEntity.status(HttpStatus.CREATED).body("Message sent successfully");
    }

    // Assuming you might want to implement fetching messages for a channel if needed
    @GetMapping("/{channelId}/messages")
    public ResponseEntity<?> getMessagesByChannel(@PathVariable String channelId) {
        // This method needs to be implemented in MessageService to fetch messages by channelId
        List<Message> messages = messageService.getMessagesByChannelId(channelId);
        return ResponseEntity.ok(messages);
    }
}

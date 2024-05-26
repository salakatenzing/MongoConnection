package org.example.controllers;

import org.example.repository.MessageRepository;
import org.example.services.MessageService;
import org.example.models.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/channels")
public class ChannelController {

    @Autowired
    private MessageService messageService;

    @Autowired
    private MessageRepository messageRepository;

    @PostMapping("/{channelId}/messages")
    public ResponseEntity<?> postMessage(@PathVariable String channelId, @RequestBody Message message) {
        messageService.sendMessage(channelId, message.getContent());
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{channelId}/messages")
    public ResponseEntity<List<Message>> getMessages(@PathVariable String channelId) {
        List<Message> messages = messageRepository.findByChannelId(channelId);
        return ResponseEntity.ok(messages);
    }
}

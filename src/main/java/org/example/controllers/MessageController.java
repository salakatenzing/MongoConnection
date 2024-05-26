package org.example.controllers;

import org.example.repository.MessageRepository;
import org.example.models.Message;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@RestController
@RequestMapping("/chat")
public class MessageController {

    @Autowired
    private MessageRepository repository;

    @PostMapping
    public Message createMessage(@RequestBody Message example) {
        return repository.save(example);
    }

    @GetMapping
    public List<Message> getAllMessages() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Message getExample(@PathVariable String id) {
        return repository.findById(id).orElse(null);
    }

    // Add more endpoints as needed for update and delete
}

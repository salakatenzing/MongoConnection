package org.example;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@RestController
@RequestMapping("/chat")
public class MessageController {

    @Autowired
    private MessageRepository repository;

    @PostMapping
    public Message addExample(@RequestBody Message example) {
        return repository.save(example);
    }

    @GetMapping
    public List<Message> getAllExamples() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Message getExample(@PathVariable String id) {
        return repository.findById(id).orElse(null);
    }

    // Add more endpoints as needed for update and delete
}

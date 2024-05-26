package org.example.services;

import org.example.repository.MessageRepository;
import org.example.models.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExampleService {

    @Autowired
    private MessageRepository exampleRepository;

    public List<Message> getAllExamples() {
        return exampleRepository.findAll();
    }

    public Message saveExample(Message example) {
        return exampleRepository.save(example);
    }
}
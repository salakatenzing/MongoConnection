package org.example.controllers;

import org.example.models.Message;
import org.example.services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {

    @Autowired
    private MessageService messageService;

    @MessageMapping("/sendMessage")
    public void sendMessage(Message message) {
        messageService.sendMessage(message.getContent(), message.getSenderId(), message.getChannelId());
    }
}



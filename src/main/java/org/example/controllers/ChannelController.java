package org.example.controllers;

import org.example.models.Channel;
import org.example.services.ChannelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/channels")
public class ChannelController {

    @Autowired
    private ChannelService channelService;

    @GetMapping
    public List<Channel> getAllChannels() {
        return channelService.findAll();
    }

    @GetMapping("/{id}")
    public Channel getChannelById(@PathVariable String id) {
        return channelService.findById(id);
    }

    @PostMapping
    public Channel createChannel(@RequestBody Channel channel) {
        return channelService.create(channel);
    }

    @PutMapping("/{id}")
    public Channel updateChannel(@PathVariable String id, @RequestBody Channel channel) {
        return channelService.update(id, channel);
    }

    @DeleteMapping("/{id}")
    public void deleteChannel(@PathVariable String id) {
        channelService.delete(id);
    }
}

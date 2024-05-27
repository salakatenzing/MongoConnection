package org.example.controllers;

import org.example.models.Channel;
import org.example.repository.ChannelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/channels")
public class ChannelController {

    @Autowired
    private ChannelRepository channelRepository;

    @GetMapping
    public List<Channel> getAllChannels() {
        return channelRepository.findAll();
    }

    @GetMapping("/{id}")
    public Channel getChannelById(@PathVariable String id) {
        return channelRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Channel createChannel(@RequestBody Channel channel) {
        return channelRepository.save(channel);
    }

    @PutMapping("/{id}")
    public Channel updateChannel(@PathVariable String id, @RequestBody Channel channel) {
        channel.setId(id);
        return channelRepository.save(channel);
    }

    @DeleteMapping("/{id}")
    public void deleteChannel(@PathVariable String id) {
        channelRepository.deleteById(id);
    }
}

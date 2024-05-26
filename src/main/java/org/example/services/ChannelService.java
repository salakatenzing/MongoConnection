package org.example.services;

import org.example.models.Channel;
import org.example.repository.ChannelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChannelService {

    @Autowired
    private ChannelRepository channelRepository;

    //even though ChannelRepo already extends MongoRepo, this class acts as a
    //intermediary layer so you have to create a wrapper method here
    public List<Channel> findAll() {
        return channelRepository.findAll();
    }

    public Channel createChannel(Channel channel) {
        // Add any business logic here if necessary
        return channelRepository.save(channel);
    }
    public boolean existsById(String channelId) {
        return channelRepository.existsById(channelId);
    }

    public Channel findById(String id) {
        return channelRepository.findById(id).orElseThrow(() -> new RuntimeException("Channel not found"));
    }
    public Channel create(Channel channel) {
        return channelRepository.save(channel);
    }

    // Update an existing channel
    public Channel update(String id, Channel channelDetails) {
        Channel channel = findById(id); // Reuse findById to handle the case where the channel does not exist
        channel.setName(channelDetails.getName());
        return channelRepository.save(channel);
    }

    // Delete a channel
    public void delete(String id) {
        channelRepository.deleteById(id);
    }
}

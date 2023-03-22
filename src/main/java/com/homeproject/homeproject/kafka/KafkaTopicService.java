package com.homeproject.homeproject.kafka;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.stereotype.Service;

@Service
public class KafkaTopicService {
    public NewTopic createTopic(String topic){
        return TopicBuilder.name(topic).build();
    }
}

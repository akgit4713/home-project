package com.homeproject.homeproject.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {
    private static final Logger LOG = LoggerFactory.getLogger(KafkaConsumer.class);

//    @KafkaListener(topics = "my-topic", groupId = "my-group")
//    public void consume(String message){
//        LOG.info("Consuming from my-topic with message {}",message);
//    }
}

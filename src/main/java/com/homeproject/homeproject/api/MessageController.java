package com.homeproject.homeproject.api;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.homeproject.homeproject.kafka.KafkaProducer;
import com.homeproject.homeproject.kafka.KafkaTopicService;
import org.apache.kafka.clients.admin.NewTopic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/kafka")
public class MessageController {

    private static final Logger LOG = LoggerFactory.getLogger(MessageController.class);
    private final KafkaTopicService kafkaTopicService;
    private final KafkaProducer kafkaProducer;

    public MessageController(KafkaTopicService kafkaTopicService, KafkaProducer kafkaProducer) {
        this.kafkaTopicService = kafkaTopicService;
        this.kafkaProducer = kafkaProducer;
    }

    @PostMapping("/create-topic")
    @ResponseBody
    private ResponseEntity<?> createNewTopic(@RequestBody ObjectNode objectNode) {
        String topicName = objectNode.get("topic").asText();
        LOG.info("Got request for creating a new Kafka topic {}", topicName);
        try {
            NewTopic newTopic = kafkaTopicService.createTopic(topicName);
            LOG.info("Create new Kafka topic {}", newTopic);
        } catch (Exception e) {
            LOG.error("Exception occurred while creating the new Kafka topic {}", topicName, e);
            return ResponseEntity.badRequest().body("Exception occurred while creating the new Kafka topic");
        }
        return ResponseEntity.ok().build();
    }

    @PostMapping("/publish")
    @ResponseBody
    private ResponseEntity<?> publish(@RequestBody ObjectNode objectNode) {
        String message = objectNode.get("message").asText();
        String topic = objectNode.get("topic").asText();
        LOG.info("Got request for publishing the message {} to Kafka Topic {}", message, topic);
        try {
            kafkaProducer.sendMessage(message, topic);
        } catch (Exception e) {
            LOG.error("Error occurred while publishing message {}, to kafka topic {}", message, topic);
            return ResponseEntity.badRequest().body("Error occurred while publishing message");
        }
        return ResponseEntity.ok().build();
    }
}

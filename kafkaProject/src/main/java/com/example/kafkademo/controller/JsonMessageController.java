package com.example.kafkademo.controller;

import com.example.kafkademo.kafka.JsonKafkaProducer;
import com.example.kafkademo.payload.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1/kafka")
public class JsonMessageController {

    private JsonKafkaProducer kafkaProducer;

   //no need @Autowired here
    public JsonMessageController(JsonKafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }
    @PostMapping("/publish")
    public ResponseEntity<String> publish(@RequestBody User user){
        //@RequestBody annotation use to convert Json object to java object
        kafkaProducer.sendMessage(user);
        return ResponseEntity.ok("Json message sent to kafka topic");

    }
}

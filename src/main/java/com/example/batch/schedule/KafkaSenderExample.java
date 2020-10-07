//package com.example.batch.schedule;
//
//import org.springframework.kafka.core.KafkaTemplate;
//import org.springframework.kafka.support.SendResult;
//import org.springframework.stereotype.Component;
//import org.springframework.util.concurrent.ListenableFuture;
//
//@Component
//public class KafkaSenderExample {
//
//  private KafkaTemplate<String, String> kafkaTemplate;
//
//  KafkaSenderExample(KafkaTemplate<String, String> kafkaTemplate) {
//    this.kafkaTemplate = kafkaTemplate;
//  }
//
//  void sendMessage(String message, String topicName) {
//    kafkaTemplate.send(topicName, message);
//  }
//
//  void sendMessageWithCallback(String message) {
//    ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send("topic1", message);
//  }
//}

//package com.example.batch.service;
//
//import com.example.batch.util.AppConstants;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.kafka.annotation.KafkaListener;
//import org.springframework.stereotype.Service;
//
//@Slf4j
//@Service
//public class KafkaConsumerService {
//  @KafkaListener(topics = AppConstants.TOPIC_NAME, groupId = AppConstants.GROUP_ID)
//  public void consume(String msg) {
//    log.info(String.format("Message received -> %s", msg));
//  }
//}

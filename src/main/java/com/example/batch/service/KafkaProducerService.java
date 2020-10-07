package com.example.batch.service;

import com.example.batch.util.AppConstants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class KafkaProducerService {

  @Autowired
  private KafkaTemplate<String, String> kafkaTemplate;

  public void sendMessage(String msg) {
    log.info(String.format("Message sent -> %s", msg));
    this.kafkaTemplate.send(AppConstants.TOPIC_NAME, msg);
  }
}

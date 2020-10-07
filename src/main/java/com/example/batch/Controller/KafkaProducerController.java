package com.example.batch.Controller;

import com.example.batch.service.KafkaProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/kafka")
public class KafkaProducerController {

  private final KafkaProducerService producerService;

  @Autowired
  public KafkaProducerController(KafkaProducerService producerService)
  {
    this.producerService = producerService;
  }

  @GetMapping(value = "/publish")
  public void sendMessageToKafkaTopic(@RequestParam("message") String message) {
    this.producerService.sendMessage(message);
  }
}

package com.example.batch.schedule;

import com.example.batch.service.ShopService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ShopReport {

  @Autowired
  private ShopService shopService;

  @Scheduled(fixedRate = 5000)
  public void start() {
    try {
      String url = shopService.selectUrl("ssumenam", "1000");
      log.info(url);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}

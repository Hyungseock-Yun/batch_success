package com.example.batch.schedule;

import com.example.batch.dto.ExternalDto;
import com.example.batch.service.ExternalService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Slf4j
@Component
public class AdexinterReport {

  @Autowired
  private ExternalService externalService;

  private final String EXTERNALID = "dable1";
  private final String path = "/home/dreamsearch/logs/cron/" + EXTERNALID + "/check.log";
  private final String datepath = "/home/dreamsearch/logs/cron/" + EXTERNALID + "/batchdate.log";
  private final String zoneidpath = "/home/dreamsearch/logs/cron/" + EXTERNALID + "/batchid.log";

  public void start() {
    try {
      ArrayList<ExternalDto> list;
      list = externalService.externalMatchList(EXTERNALID, "", 0);
      for (ExternalDto dto : list) {
        log.info(dto.getMediaID());
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
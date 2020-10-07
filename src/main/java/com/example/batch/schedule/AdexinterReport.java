package com.example.batch.schedule;

import com.example.batch.dto.ExternalDto;
import com.example.batch.dto.ParamDto;
import com.example.batch.service.ExternalService;
import com.example.batch.util.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

@Slf4j
@Component
public class AdexinterReport {

  @Autowired
  private ExternalService externalService;

  private final String EXTERNALID = "dable1";
  private final String path = "/home/dreamsearch/logs/cron/" + EXTERNALID + "/check.log";
  private final String datepath = "/home/dreamsearch/logs/cron/" + EXTERNALID + "/batchdate.log";
  private final String zoneidpath = "/home/dreamsearch/logs/cron/" + EXTERNALID + "/batchid.log";

  public void start(ParamDto param) {
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
    Date date = new Date();
    Calendar cal = Calendar.getInstance();
    cal.add(Calendar.DATE, -2);	//전날짜 셋팅
    date.setTime(cal.getTimeInMillis());
    String yyyymmdd = dateFormat.format(date);
    String localDate = param.getDate();
    String localZoneid = param.getZoneID();

    if (StringUtils.isNotEmpty(localDate)) {
      yyyymmdd = localDate;
    }

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
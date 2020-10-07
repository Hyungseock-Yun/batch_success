package com.example.batch.Controller;

import com.example.batch.schedule.AdexinterReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class ExternalController {

  @Autowired AdexinterReport adexinterReport;

//  @Scheduled(fixedRate = 5000)
  public void batch() {
//    adexinterReport.start();
  }
}

package com.example.batch.Controller;

import com.example.batch.dto.ParamDto;
import com.example.batch.schedule.AdexinterReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

@Controller
public class TestController {

    private ParamDto param = new ParamDto();
//    @Autowired TestSchedule testSchedule;
    @Autowired AdexinterReport adexinterReport;

//    @Scheduled(fixedRate = 5000)
    public void batch() {
//        testSchedule.reportBatch();
    }

    @Scheduled(fixedRate = 5000)
    public void adexinterBatch() {
        adexinterReport.start(param);
    }
}
package com.example.batch.Controller;

import com.example.batch.schedule.TestSchedule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

@Controller
public class TestController {

    @Autowired
    TestSchedule testSchedule;

    @Scheduled(fixedRate = 5000)
    public void batch() {
        testSchedule.reportBatch();
    }
}

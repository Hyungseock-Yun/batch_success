package com.example.batch.schedule;

import com.example.batch.dto.TestDto;
import com.example.batch.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Slf4j
@Component
public class TestSchedule {
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Autowired
    public TestService testService;
    public TestDto dto;

    public void reportBatch() {
        log.info("The time is now {}", dateFormat.format(new Date()));
        if (dto == null) {
            dto = new TestDto();
        }
        try {
            List<TestDto> list = testService.getBoardList();
            for (TestDto test : list) {
                String title = test.getTitle();
                log.info(title);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

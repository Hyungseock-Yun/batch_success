package com.example.batch.Controller;

import com.example.batch.dto.ParamDto;
import com.example.batch.schedule.AdexinterReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/batch")
public class DirectBatchController {

//  TestSchedule testSchedule;
  @Autowired AdexinterReport adexinter;

//  @GetMapping(value = "/direct")
//  public void getDirectBatch(@RequestParam(value = "externalID") String externalID,
//                          @RequestParam(value = "zoneid", required = false) String zoneID,
//                          @RequestParam(value = "date") String date)  {
//    try {
//      Map<String, String> externalMap = new HashMap<>();
//      externalMap.put("zoneid", zoneID);
//      externalMap.put("date", date);
//      switch (externalID) {
////        case "test" : testSchedule.reportBatch();
//        case "adexinter" : adexinter.start(externalMap);
//      }
//
//    } catch (Exception e) {
//      e.printStackTrace();
//    }
//  }

  @RequestMapping(method = RequestMethod.POST, path = "/direct")
  public void postDirectBatch(@RequestBody ParamDto param) {
    try {
      String externalID = param.getExternalID();
      switch (externalID) {
//        case "test" : testSchedule.reportBatch();
        case "adexinter" : adexinter.start(param);
      }

    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}

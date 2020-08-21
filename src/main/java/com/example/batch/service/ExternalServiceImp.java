package com.example.batch.service;

import com.example.batch.dao.external.ExternalDao;
import com.example.batch.dto.ExternalDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;

@Slf4j
@RequiredArgsConstructor
@Service
public class ExternalServiceImp implements ExternalService {

  private final ExternalDao externalDao;

  @Override
  public ArrayList<ExternalDto> externalMatchList(String externalId, String zoneId, int mediaCode) {
    HashMap<String, String> params = new HashMap<>();
    params.put("externalId", externalId);
    params.put("zoneid", zoneId);
    if(mediaCode != 0) {
      params.put("scriptNo", String.valueOf(mediaCode));
    }
    params.put("type", "batch");

    return externalDao.selectExternalMatch(params);
  }
}

package com.example.batch.service;

import com.example.batch.dto.ExternalDto;

import java.util.ArrayList;

public interface ExternalService {

  public ArrayList<ExternalDto> externalMatchList(String externalId, String zoneId, int mediaCode);

}

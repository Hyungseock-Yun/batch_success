package com.example.batch.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class ParamDto implements Serializable {
  private static final long serialVersionUID = 1L;

  private String externalID;
  private String zoneID;
  private String date;

}

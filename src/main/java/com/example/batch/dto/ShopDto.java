package com.example.batch.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class ShopDto implements Serializable {
  private static final long serialVersionUID = 1L;
  Long no;
  String userID;
  String pcode;
  String url;
}

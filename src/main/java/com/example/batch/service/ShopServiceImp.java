package com.example.batch.service;

import com.example.batch.dao.shop.ShopDao;
import com.example.batch.dto.ShopDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Slf4j
@RequiredArgsConstructor
@Service
public class ShopServiceImp implements ShopService {

  private final ShopDao shopDao;

  @Override
  public String selectUrl(String userID, String pcode) {
    HashMap<String, String> params = new HashMap<>();
    params.put("userID", userID);
    params.put("pcode", pcode);
    ShopDto dto = shopDao.selectTest(params);
    String url = dto.getUrl();
    return url;
  }
}

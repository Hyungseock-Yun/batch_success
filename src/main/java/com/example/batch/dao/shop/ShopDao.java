package com.example.batch.dao.shop;

import com.example.batch.dto.ShopDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
@Mapper
public interface ShopDao {

  public ShopDto selectTest(HashMap<String, String> params);

}

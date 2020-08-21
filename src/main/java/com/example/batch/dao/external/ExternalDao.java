package com.example.batch.dao.external;

import com.example.batch.dto.ExternalDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;

@Repository
@Mapper
public interface ExternalDao {

  public ArrayList<ExternalDto> selectExternalMatch(HashMap<String, String> params);

}

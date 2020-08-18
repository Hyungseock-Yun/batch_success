package com.example.batch.dao;

import com.example.batch.dto.TestDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
@Mapper
public interface TestDao {

    public int insertTest(TestDto params);

    public TestDto selectTest(Long idx);

    public int updateTest(TestDto params);

    public int deleteTest(Long idx);

    public List<TestDto> selectTestList();

    public int selectTestTotalCount();

    public List<TestDto> selectListWithHashMap(HashMap<String, String> filter);

}

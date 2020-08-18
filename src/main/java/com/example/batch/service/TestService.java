package com.example.batch.service;

import com.example.batch.dto.TestDto;

import java.util.List;

public interface TestService {

    public boolean registerBoard(TestDto params);

    public TestDto getBoardDetail(Long idx);

    public boolean deleteBoard(Long idx);

    public List<TestDto> getBoardList();

}
package com.example.batch.service;

import com.example.batch.dao.TestDao;
import com.example.batch.dto.TestDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class TestServiceImp implements TestService {

    private final TestDao testDao;

    @Override
    public boolean registerBoard(TestDto params) {
        int queryResult = 0;

        if (params.getIdx() == null) {
            queryResult = testDao.insertTest(params);
        } else {
            queryResult = testDao.updateTest(params);
        }
        return (queryResult == 1) ? true : false;
    }

    @Override
    public TestDto getBoardDetail(Long idx) {
        return testDao.selectTest(idx);
    }

    @Override
    public boolean deleteBoard(Long idx) {
        int queryResult = 0;

        TestDto board = testDao.selectTest(idx);

        if (board != null && "N".equals(board.getDeleteYn())) {
            queryResult = testDao.deleteTest(idx);
        }

        return (queryResult == 1) ? true : false;
    }

    @Override
    public List<TestDto> getBoardList() {
        List<TestDto> boardList = Collections.emptyList();

        int boardTotalCnt = testDao.selectTestTotalCount();

        if (boardTotalCnt > 0) {
            boardList = testDao.selectTestList();
        }
        return boardList;
    }
}

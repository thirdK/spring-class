package com.example.study02.mapper;

import com.example.study02.domain.vo.BoardVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class BoardMapperTests {
    @Autowired
    private BoardMapper boardMapper;

    @Test
    public void getListTest(){
        log.info("************************");
        log.info("getList 테스트");
        log.info("************************");
        boardMapper.getList().stream().map(BoardVO::toString).forEach(log::info);
    }

    @Test
    public void insertTest(){
        log.info("************************");
        log.info("insert 테스트");
        log.info("************************");
        BoardVO boardVO = new BoardVO();
        boardVO.setBoardTitle("222");
        boardVO.setBoardContent("22222222222222222222222222222222222222");
        boardVO.setBoardWriter("박박박");
        boardMapper.insert(boardVO);
        getListTest();
    }

    @Test
    public void getTest(){
        log.info("************************");
        log.info("get 테스트");
        log.info("************************");

        Long boardBno = 10L;
        log.info(boardMapper.get(boardBno).toString());
    }

    @Test
    public void deleteTest(){
        log.info("************************");
        log.info("delete 테스트");
        log.info("************************");

        Long boardBno = 10L;
        boardMapper.delete(boardBno);
        getListTest();
    }

    @Test
    public void updateTest(){
        log.info("************************");
        log.info("update 테스트");
        log.info("************************");
        BoardVO boardVO = boardMapper.get(12L);
        boardVO.setBoardTitle("수정 제목");
        boardVO.setBoardContent("수정테스트합니다......");
        boardMapper.update(boardVO);
        getListTest();
    }
}

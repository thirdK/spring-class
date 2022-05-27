package com.example.study02.service;

import com.example.study02.domain.vo.BoardVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class BoardServiceTests {
    @Autowired
    private BoardService boardService;

    @Test
    public void getListTest(){
        log.info("************************");
        log.info("getList 테스트");
        log.info("************************");
        boardService.getList().stream().map(BoardVO::toString).forEach(log::info);
    }

    @Test
    public void registerTest(){
        log.info("************************");
        log.info("registerTest");
        log.info("************************");
        BoardVO boardVO = new BoardVO();
        boardVO.setBoardTitle("222");
        boardVO.setBoardContent("22222222222222222222222222222222222222");
        boardVO.setBoardWriter("박박박");
        boardService.register(boardVO);
        getListTest();
    }

    @Test
    public void readTest(){
        log.info("************************");
        log.info("readTest");
        log.info("************************");

        Long boardBno = 11L;
        log.info(boardService.read(boardBno).toString());
    }

    @Test
    public void removeTest(){
        log.info("************************");
        log.info("removeTest");
        log.info("************************");

        Long boardBno = 10L;
        boardService.remove(boardBno);
        getListTest();
    }

    @Test
    public void modifyTest(){
        log.info("************************");
        log.info("modifyTest 테스트");
        log.info("************************");
        BoardVO boardVO = boardService.read(12L);
        boardVO.setBoardTitle("수정 제목");
        boardVO.setBoardContent("수정테스트합니다......");
        boardService.modify(boardVO);
        getListTest();
    }
}

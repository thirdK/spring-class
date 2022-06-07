package com.example.study05.service;

import com.example.study05.domain.vo.BoardVO;
import com.example.study05.domain.vo.Criteria;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.Stream;

@SpringBootTest
@Slf4j
public class BoardServiceTests {
    @Autowired
    private BoardService boardService;

    @Test
    public void readTest() {
        log.info("===============================");
        log.info("getTest...................");
        log.info("===============================");
        log.info(boardService.read(14L).toString());
    }

    @Test
    public void getListTest() {
        log.info("===============================");
        log.info("getListTest......................");
        log.info("===============================");
        boardService.getList(new Criteria()).stream().map(BoardVO::toString).forEach(log::info);
    }

    @Test
    public void registerTest() {
        log.info("===============================");
        log.info("insertTest................");
        log.info("===============================");

        BoardVO boardVO = new BoardVO();
        boardVO.setBoardTitle("study05 test");
        boardVO.setBoardContent("study05......................................");
        boardVO.setBoardWriter("study");
        boardService.register(boardVO);
        boardService.getList(new Criteria()).stream().map(BoardVO::toString).forEach(log::info);
    }

    @Test
    public void modifyTest() {
        log.info("===============================");
        log.info("updateTest.....................");
        log.info("===============================");

        BoardVO boardVO = boardService.read(210L);
        boardVO.setBoardTitle("update test");
        boardVO.setBoardContent("up up up up date date");

        boardService.modify(boardVO);
        boardService.getList(new Criteria()).stream().map(BoardVO::toString).forEach(log::info);

    }

    @Test
    public void removeTest() {
        log.info("===============================");
        log.info("deleteTest....................");
        log.info("===============================");

        boardService.remove(217L);

        boardService.getList(new Criteria()).stream().map(BoardVO::toString).forEach(log::info);
    }
}

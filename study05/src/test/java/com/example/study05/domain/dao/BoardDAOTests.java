package com.example.study05.domain.dao;

import com.example.study05.domain.vo.BoardVO;
import com.example.study05.domain.vo.Criteria;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
class BoardDAOTests {
    @Autowired
    private BoardDAO boardDAO;
    
    @Test
    public void readTest(){
        log.info("===============================");
        log.info("getTest...................");
        log.info("===============================");
        log.info(boardDAO.read(14L).toString());

    }

    @Test
    public void getListTest(){
        log.info("===============================");
        log.info("getListTest......................");
        log.info("===============================");
        boardDAO.getList(new Criteria()).stream().map(BoardVO::toString).forEach(log::info);
    }

    @Test
    public void registerTest(){
        log.info("===============================");
        log.info("insertTest................");
        log.info("===============================");

        BoardVO boardVO = new BoardVO();
        boardVO.setBoardTitle("study05 test");
        boardVO.setBoardContent("study05......................................");
        boardVO.setBoardWriter("study");
        boardDAO.register(boardVO);
        boardDAO.getList(new Criteria()).stream().map(BoardVO::toString).forEach(log::info);
    }

    @Test
    public void modifyTest(){
        log.info("===============================");
        log.info("updateTest.....................");
        log.info("===============================");

        BoardVO boardVO = boardDAO.read(217L);
        boardVO.setBoardTitle("update test");
        boardVO.setBoardContent("up up up up date date");

        boardDAO.modify(boardVO);
        boardDAO.getList(new Criteria()).stream().map(BoardVO::toString).forEach(log::info);

    }

    @Test
    public void removeTest(){
        log.info("===============================");
        log.info("deleteTest....................");
        log.info("===============================");

        boardDAO.remove(217L);

        boardDAO.getList(new Criteria()).stream().map(BoardVO::toString).forEach(log::info);
    }
}
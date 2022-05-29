package com.example.study03.domain.dao;

import com.example.study03.domain.vo.BoardVO;
import com.example.study03.domain.vo.Criteria;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class BoardDaoTests {
    @Autowired
    private BoardDAO boardDAO;

    @Test
    public void getListTest() {
        log.info("-------------------------------");
        log.info("getListTest");
        log.info("-------------------------------");
        boardDAO.getList(new Criteria()).stream().map(BoardVO::toString).forEach(log::info);
    }

    @Test
    public void registerTest() {
        log.info("-------------------------------");
        log.info("registerTest");
        log.info("-------------------------------");
        BoardVO boardVO = new BoardVO();
        boardVO.setBoardTitle("hhhhh");
        boardVO.setBoardContent("qqqqqqqqqqqqqqqqqqqqqq");
        boardVO.setBoardWriter("aaaa");
        boardDAO.register(boardVO);
    }

    @Test
    public void readTest() {
        log.info("-------------------------------");
        log.info("readTest");
        log.info("-------------------------------");
        boardDAO.read(131L).toString();
    }

    @Test
    public void removeTest() {
        log.info("-------------------------------");
        log.info("removeTest");
        log.info("-------------------------------");
        boardDAO.remove(131L);
    }

    @Test
    public void modifyTest() {
        log.info("-------------------------------");
        log.info("modifyTest");
        log.info("-------------------------------");
        BoardVO boardVO = boardDAO.read(131L);
        boardVO.setBoardTitle("수정!!!");
        boardVO.setBoardContent("수정테스트!!!!!!!");
        boardDAO.modify(boardVO);
    }
}

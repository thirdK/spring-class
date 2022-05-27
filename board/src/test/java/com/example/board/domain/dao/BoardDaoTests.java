package com.example.board.domain.dao;

import com.example.board.domain.vo.BoardVO;
import com.example.board.domain.vo.Criteria;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class BoardDaoTests {
    @Autowired
    private BoardDAO boardDAO;

//            @Test
    public void getListTest() {
        boardDAO.getList(new Criteria()).stream().map(BoardVO::toString).forEach(log::info);
    }
//
//        @Test
//    public void registerTest() {
//        BoardVO boardVO = new BoardVO();
//        boardVO.setBoardContent("12423");
//        boardVO.setBoardTitle("1241 타이틀");
//        boardVO.setBoardWriter("3333");
//        boardDAO.register(boardVO);
//        getListTest();
//    }
//
//        @Test
//    public void readTest() {
//        Long boardBno = 5L;
//        log.info(boardDAO.read(boardBno).toString());
//    }
//
//    @Test
//    public void removeTest() {
//        Long boardBno = 3L;
//        if (boardDAO.remove(boardBno)) {
//            log.info("DELETE SUCCESS");
//            return;
//        }
//        log.info("DELETE FAIL");
//    }
//
//        @Test
//    public void modifyTest() {
//        long boardBno = 5;
//        BoardVO boardVO = boardDAO.read(boardBno);
//        if (boardVO == null) {
//            log.info("NO BOARD");
//            return;
//        }
//        boardVO.setBoardTitle("수정13");
//        boardVO.setBoardContent("수정13 내용");
//        if(boardDAO.modify(boardVO)){
//            log.info("UPDATE SUCCESS");
//        } else {
//            log.info("UPDATE FAIL");
//        }
//
//    }

    @Test
    public void getTotalPageTest(){
        log.info("=====================================================");
        log.info(Integer.valueOf(boardDAO.getTotalPage()).toString());
        log.info("=====================================================");
    }
}

package com.example.study03.service;

import com.example.study03.domain.vo.BoardVO;
import com.example.study03.domain.vo.Criteria;
import lombok.RequiredArgsConstructor;
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
    public void getListTest() {
        log.info("-------------------------------");
        log.info("getListTest");
        log.info("-------------------------------");
        boardService.getList(new Criteria()).stream().map(BoardVO::toString).forEach(log::info);
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
        boardService.register(boardVO);
    }

    @Test
    public void readTest() {
        log.info("-------------------------------");
        log.info("readTest");
        log.info("-------------------------------");
        boardService.read(132L).toString();
    }

    @Test
    public void removeTest() {
        log.info("-------------------------------");
        log.info("removeTest");
        log.info("-------------------------------");
        boardService.remove(132L);
    }

    @Test
    public void modifyTest() {
        log.info("-------------------------------");
        log.info("modifyTest");
        log.info("-------------------------------");
        BoardVO boardVO = boardService.read(132L);
        boardVO.setBoardTitle("수정!!!");
        boardVO.setBoardContent("수정테스트!!!!!!!");
        boardService.modify(boardVO);
    }
}

package com.example.study04.service;

import com.example.study04.domain.vo.BoardVO;
import com.example.study04.domain.vo.Criteria;
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
        boardService.getList(new Criteria()).stream().map(BoardVO::toString).forEach(log::info);
    }

    @Test
    public void get(){
        log.info(boardService.read(71L).toString());
    }

    @Test
    public void insert(){
        BoardVO boardVO = new BoardVO();
        boardVO.setBoardTitle("04 테스트");
        boardVO.setBoardContent("마지막 04 테스트");
        boardVO.setBoardWriter("xxxxxxxx");
        boardService.register(boardVO);
    }

    @Test
    public void delete(){
        boardService.remove(71L);
    }

    @Test
    public void update(){
        BoardVO boardVO = boardService.read(6L);
        boardVO.setBoardTitle("xxxxxxxxxxxxxxxx");
        boardVO.setBoardContent("수정한다다다다다다다다xxxxxxxxxxxxxxx");
        boardService.modify(boardVO);
    }
}

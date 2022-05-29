package com.example.study03.mapper;

import com.example.study03.domain.vo.BoardVO;
import com.example.study03.domain.vo.Criteria;
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
        log.info("-------------------------------");
        log.info("getListTest");
        log.info("-------------------------------");
        boardMapper.getList(new Criteria()).stream().map(BoardVO::toString).forEach(log::info);
    }

//    @Test
    public void insertTest(){
        log.info("-------------------------------");
        log.info("insertTest");
        log.info("-------------------------------");
        BoardVO boardVO = new BoardVO();
        boardVO.setBoardTitle("hhhhh");
        boardVO.setBoardContent("qqqqqqqqqqqqqqqqqqqqqq");
        boardVO.setBoardWriter("aaaa");
        boardMapper.insert(boardVO);
    }

//    @Test
    public void getTest(){
        log.info("-------------------------------");
        log.info("getTest");
        log.info("-------------------------------");
        boardMapper.get(130L).toString();
    }

//    @Test
    public void deleteTest(){
        log.info("-------------------------------");
        log.info("deleteTest");
        log.info("-------------------------------");
        boardMapper.delete(130L);
    }

    @Test
    public void updateTest(){
        log.info("-------------------------------");
        log.info("updateTest");
        log.info("-------------------------------");
        BoardVO boardVO = boardMapper.get(129L);
        boardVO.setBoardTitle("수정!!!");
        boardVO.setBoardContent("수정테스트!!!!!!!");
        boardMapper.update(boardVO);
    }
}

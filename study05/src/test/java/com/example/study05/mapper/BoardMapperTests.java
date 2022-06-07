package com.example.study05.mapper;

import com.example.study05.domain.vo.BoardVO;
import com.example.study05.domain.vo.Criteria;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class BoardMapperTests {
    @Autowired  //테스트 클레스에서 필드 주입을하는 이유는 무엇인가?
    private BoardMapper boardMapper;

    @Test
    public void getTest(){
        log.info("===============================");
        log.info("getTest...................");
        log.info("===============================");
        log.info(boardMapper.get(14L).toString());

    }

    @Test
    public void getListTest(){
        log.info("===============================");
        log.info("getListTest......................");
        log.info("===============================");
        boardMapper.getList(new Criteria()).stream().map(BoardVO::toString).forEach(log::info);
    }

    @Test
    public void insertTest(){
        log.info("===============================");
        log.info("insertTest................");
        log.info("===============================");

        BoardVO boardVO = new BoardVO();
        boardVO.setBoardTitle("study05 test");
        boardVO.setBoardContent("study05......................................");
        boardVO.setBoardWriter("study");
        boardMapper.insert(boardVO);
        boardMapper.getList(new Criteria()).stream().map(BoardVO::toString).forEach(log::info);
    }

    @Test
    public void updateTest(){
        log.info("===============================");
        log.info("updateTest.....................");
        log.info("===============================");

        BoardVO boardVO = boardMapper.get(216L);
        boardVO.setBoardTitle("update test");
        boardVO.setBoardContent("up up up up date date");

        boardMapper.update(boardVO);
        boardMapper.getList(new Criteria()).stream().map(BoardVO::toString).forEach(log::info);

    }

    @Test
    public void deleteTest(){
        log.info("===============================");
        log.info("deleteTest....................");
        log.info("===============================");

        boardMapper.delete(216L);

        boardMapper.getList(new Criteria()).stream().map(BoardVO::toString).forEach(log::info);
    }



}

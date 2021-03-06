package com.example.board.mapper;

import com.example.board.domain.vo.BoardVO;
import com.example.board.domain.vo.Criteria;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

@SpringBootTest
@Slf4j
public class BoardMapperTests {
    @Autowired
    private BoardMapper boardMapper;

    @Test
    public void getListTest(){
        boardMapper.getList(new Criteria()).stream().map(BoardVO::toString).forEach(log::info);
    }

//    @Test
//    public void insertTest(){
//        BoardVO boardVO = new BoardVO();
//        boardVO.setBoardContent("아아아아아아아아아아아아아");
//        boardVO.setBoardTitle("아아 타이틀");
//        boardVO.setBoardWriter("최세화");
//        boardMapper.insert(boardVO);
//        getListTest();
//    }
//
//    @Test
//    public void getTest(){
//        Long boardBno = 3L;
//        log.info(boardMapper.get(boardBno).toString());
//    }
//
    //    @Test
    //    public void deleteTest(){
    //        Long boardBno = 3L;
    ////        log.info("DELETE COUNT : " + boardMapper.delete(boardBno));
    //        boardMapper.delete(boardBno);
    //        getListTest();
    //    }
//
//    @Test
//    public void updateTest(){
//        Long boardBno = 2L;
//        BoardVO boardVO = boardMapper.get(boardBno);
//        if(boardVO == null){log.info("NO BOARD"); return;}
//        boardVO.setBoardTitle("ddd");
//        boardVO.setBoardContent("aaaaaaaa");
//        log.info("UPDATE COUNT" + boardMapper.update(boardVO));
//    }

    @Test
    public void totalPage(){
        log.info("=====================================================");
        log.info(Integer.valueOf(boardMapper.getTotalPage()).toString());
        log.info("=====================================================");
    }

    @Test
    public void myTotalTest(){
        log.info(boardMapper.getMyTotal(new Criteria()) + "");
    }

    @Test
    public void recentBoardBnoTest(){
        Arrays.stream(boardMapper.getRecentBoardBno()).map(String::valueOf).forEach(log::info);
    }
}

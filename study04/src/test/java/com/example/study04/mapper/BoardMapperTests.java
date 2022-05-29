package com.example.study04.mapper;

import com.example.study04.domain.vo.BoardVO;
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
        boardMapper.getList().stream().map(BoardVO::toString).forEach(log::info);
    }

    @Test
    public void get(){
        log.info(boardMapper.get(40L).toString());
    }

    @Test
    public void insert(){
        BoardVO boardVO = new BoardVO();
        boardVO.setBoardTitle("04 테스트");
        boardVO.setBoardContent("마지막 04 테스트");
        boardVO.setBoardWriter("xxxxxxxx");
        boardMapper.insert(boardVO);
    }

    @Test
    public void delete(){
        boardMapper.delete(136L);
    }

    @Test
    public void update(){
        BoardVO boardVO = boardMapper.get(135L);
        boardVO.setBoardTitle("xxxxxxxxxxxxxxxx");
        boardVO.setBoardContent("수정한다다다다다다다다xxxxxxxxxxxxxxx");
        boardMapper.update(boardVO);
    }
}

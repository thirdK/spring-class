package com.example.board.mapper;

import com.example.board.domain.vo.ReplyVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class ReplyMapperTests {
    @Autowired
    private ReplyMapper replyMapper;

    @Test
    public void replyMapperTest(){
        log.info(replyMapper + "");
    }

    @Test
    public void insertTest(){
        ReplyVO replyVO = new ReplyVO();
        replyVO.setBoardBno(213L);
        replyVO.setReplyContent("테스트으");
        replyVO.setReplyWriter("홍길동");
        replyMapper.insert(replyVO);
    }

    @Test
    public void getByReplyNumberTest(){
        log.info(replyMapper.getByReplyNumber(1L).toString());
    }

    @Test
    public void getByBoardBno(){
        replyMapper.getByBoardBno(213L).stream().map(ReplyVO::toString).forEach(log::info);
    }

}

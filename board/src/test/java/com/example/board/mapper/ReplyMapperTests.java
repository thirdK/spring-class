package com.example.board.mapper;

import com.example.board.domain.vo.Criteria;
import com.example.board.domain.vo.ReplyVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

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
        Long[] recent = replyMapper.getRecentBoardBno();
        ReplyVO replyVO = new ReplyVO();

        Arrays.stream(recent).map(String::valueOf).forEach(log::info);

        Arrays.stream(recent).forEach(i -> {
            for(int j=0; j<2; j++){
                replyVO.setBoardBno(i);
                replyVO.setReplyContent("최근 글 테스트2222");
                replyVO.setReplyWriter("user03");
                replyMapper.insert(replyVO);
            }
        });

//        replyVO.setBoardBno(213L);
//        replyVO.setReplyContent("댓글글글글");
//        replyVO.setReplyWriter("user02");
    }

    @Test
    public void getReply(){
        log.info(replyMapper.getReply(1L).toString());
    }

    @Test
    public void deleteTest(){
        replyMapper.delete(3L);
    }

    @Test
    public void updateTest(){
        ReplyVO replyVO = new ReplyVO();
        replyVO.setReplyNumber(2L);
        replyVO.setReplyContent("수정테스트");
        log.info(replyMapper.update(replyVO) + "");
    }

    @Test
    public void getListTest(){
        replyMapper.getList(new Criteria(2, 10), 212L)
                .stream().map(ReplyVO::toString).forEach(log::info);
    }

    @Test
    public void getTotalTest(){
        log.info("댓글 개수 : " + replyMapper.getTotal(212L));
    }
}

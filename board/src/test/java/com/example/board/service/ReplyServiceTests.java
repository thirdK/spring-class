package com.example.board.service;

import com.example.board.domain.vo.Criteria;
import com.example.board.domain.vo.ReplyVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

@SpringBootTest
@Slf4j
public class ReplyServiceTests {
    @Autowired
    private ReplyService replyService;



    @Test
    public void replyServiceTest(){
        log.info(replyService + "");
    }

    @Test
    public void registerTest(){
        Long[] recent = replyService.getRecentBoardBno();
        ReplyVO replyVO = new ReplyVO();

        Arrays.stream(recent).map(String::valueOf).forEach(log::info);

        Arrays.stream(recent).forEach(i -> {
            for(int j=0; j<2; j++){
                replyVO.setBoardBno(i);
                replyVO.setReplyContent("최근 글 테스트2222");
                replyVO.setReplyWriter("user03");
                replyService.register(replyVO);
            }
        });

//        replyVO.setBoardBno(213L);
//        replyVO.setReplyContent("댓글글글글");
//        replyVO.setReplyWriter("user02");
    }

    @Test
    public void readTest(){
        log.info(replyService.read(1L).toString());
    }


    @Test
    public void removeTest(){
        replyService.remove(38L);
    }

    @Test
    public void modifyTest(){
        ReplyVO replyVO = new ReplyVO();
        replyVO.setReplyNumber(39L);
        replyVO.setReplyContent("수정테스트");
        log.info(replyService.modify(replyVO) + "");
    }

    @Test
    public void getListTest(){
        replyService.getList(new Criteria(2, 10), 212L)
                .stream().map(ReplyVO::toString).forEach(log::info);
    }

    @Test
    public void getTotal(){
        log.info("getTotal : " + replyService.getTotal(212L));
    }
}

package com.example.board.domain.dao;

import com.example.board.domain.vo.Criteria;
import com.example.board.domain.vo.ReplyVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

@SpringBootTest
@Slf4j
public class ReplyDaoTests {
    @Autowired
    private ReplyDAO replyDAO;



    @Test
    public void replyDAOTest(){
        log.info(replyDAO + "");
    }

    @Test
    public void registerTest(){
        Long[] recent = replyDAO.getRecentBoardBno();
        ReplyVO replyVO = new ReplyVO();

        Arrays.stream(recent).map(String::valueOf).forEach(log::info);

        Arrays.stream(recent).forEach(i -> {
            for(int j=0; j<2; j++){
                replyVO.setBoardBno(i);
                replyVO.setReplyContent("최근 글 테스트2222");
                replyVO.setReplyWriter("user03");
                replyDAO.register(replyVO);
            }
        });

//        replyVO.setBoardBno(213L);
//        replyVO.setReplyContent("댓글글글글");
//        replyVO.setReplyWriter("user02");
    }

    @Test
    public void readTest(){
        log.info(replyDAO.read(1L).toString());
    }


    @Test
    public void removeTest(){
        replyDAO.remove(33L);
    }

    @Test
    public void modifyTest(){
        ReplyVO replyVO = new ReplyVO();
        replyVO.setReplyNumber(32L);
        replyVO.setReplyContent("수정테스트");
        log.info(replyDAO.modify(replyVO) + "");
    }

    @Test
    public void getListTest(){
        replyDAO.getList(new Criteria(2, 10), 212L)
                .stream().map(ReplyVO::toString).forEach(log::info);
    }
}

package com.example.board.mapper;

import com.example.board.domain.vo.ReplyVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ReplyMapper {
    //댓글 추가하기
    public int insert(ReplyVO replyVO);

    //댓글 1개 조회
    public ReplyVO getByReplyNumber(Long replyNumber);

    //게시글에 속한 댓글들을 조회
    public List<ReplyVO> getByBoardBno(Long boardBno);
}

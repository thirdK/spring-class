package com.example.board.mapper;

import com.example.board.domain.vo.Criteria;
import com.example.board.domain.vo.ReplyVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ReplyMapper {
    //댓글 추가하기
    public int insert(ReplyVO replyVO);

    public ReplyVO getReply(Long replyNumber);

    public int delete(Long replyNumber);

    public int update(ReplyVO replyVO);

    public List<ReplyVO> getList(@Param("criteria") Criteria criteria, @Param("boardBno") Long boardBno);
    //2개 이상의 파라미터를 mapping파일에 넘겨줄 때 @Param("키")

    public Long[] getRecentBoardBno();

    public int getTotal(Long boardBno);



    //댓글 1개 조회
    public ReplyVO getByReplyNumber(Long replyNumber);

    //게시글에 속한 댓글들을 조회
    public List<ReplyVO> getByBoardBno(Long boardBno);
}

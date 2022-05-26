package com.example.board.domain.dao;

import com.example.board.domain.vo.BoardVO;
import com.example.board.mapper.BoardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class BoardDAO {
    private final BoardMapper boardMapper;



    //    게시글 목록
    public List<BoardVO> getList() {
        return boardMapper.getList();
    }

    //    게시글 등록
    public void register(BoardVO boardVO){
        boardMapper.insert(boardVO);
    }

    //    게시글 상세보기
    public BoardVO read(Long boardBno){
        return boardMapper.get(boardBno);
    }

    //    게시글 삭제
    public boolean remove(Long boardBno){
        return boardMapper.delete(boardBno) != 0;
    }

    //    게시글 수정
    public boolean modify(BoardVO boardVO){
        return boardMapper.update(boardVO) != 0;
    }
}

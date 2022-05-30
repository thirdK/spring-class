package com.example.study04.domain.dao;

import com.example.study04.domain.vo.BoardVO;
import com.example.study04.domain.vo.Criteria;
import com.example.study04.mapper.BoardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class BoardDAO {
    private final BoardMapper boardMapper;

    public List<BoardVO> getList(Criteria criteria){ return boardMapper.getList(criteria); }
    public BoardVO read(Long boardBno){ return boardMapper.get(boardBno); }
    public int register(BoardVO boardVO){ return boardMapper.insert(boardVO); }
    public int remove(Long boardBno){ return boardMapper.delete(boardBno); }
    public int modify(BoardVO boardVO){ return boardMapper.update(boardVO); }
    public int getTotal(){ return boardMapper.getTotal(); }
}

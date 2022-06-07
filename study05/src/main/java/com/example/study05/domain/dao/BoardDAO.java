package com.example.study05.domain.dao;

import com.example.study05.domain.vo.BoardVO;
import com.example.study05.domain.vo.Criteria;
import com.example.study05.mapper.BoardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class BoardDAO {
    private final BoardMapper boardMapper;

    public BoardVO read(Long boardBno){ return boardMapper.get(boardBno); }
    public List<BoardVO> getList(Criteria criteria){ return boardMapper.getList(criteria); }
    public boolean register(BoardVO boardVO){ return boardMapper.insert(boardVO) != 0; }
    public boolean modify(BoardVO boardVO){ return boardMapper.update(boardVO) != 0; }
    public boolean remove(Long boardBno){ return boardMapper.delete(boardBno) != 0; }

    public int getTotal(){ return boardMapper.getTotal(); }
}

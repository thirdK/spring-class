package com.example.study05.service;

import com.example.study05.domain.vo.BoardVO;
import com.example.study05.domain.vo.Criteria;

import java.util.List;

public interface BoardService {
    public BoardVO read(Long boardBno);
    public List<BoardVO> getList(Criteria criteria);
    public boolean register(BoardVO boardVO);
    public boolean modify(BoardVO boardVO);
    public boolean remove(Long boardBno);
    public int getTotal();
}
package com.example.study03.service;

import com.example.study03.domain.vo.BoardVO;
import com.example.study03.domain.vo.Criteria;

import java.util.List;

public interface BoardService {
    public List<BoardVO> getList(Criteria criteria);
    public boolean register(BoardVO boardVO);
    public BoardVO read(Long boardBno);
    public boolean remove(Long boardBno);
    public boolean modify(BoardVO boardVO);
    public int getTotal();
}

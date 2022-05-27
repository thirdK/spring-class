package com.example.board.service;

import com.example.board.domain.vo.BoardVO;
import com.example.board.domain.vo.Criteria;
import com.example.board.domain.vo.PageDTO;

import java.util.List;

public interface BoardService {

    public void register(BoardVO boardVO);
    public BoardVO read(Long boardBno);
    public boolean modify(BoardVO boardVO);
    public boolean remove(Long boardBno);
    public List<BoardVO> getList(Criteria criteria);
    public int getTotalPage();
}

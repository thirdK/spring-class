package com.example.study04.service;

import com.example.study04.domain.vo.BoardVO;
import com.example.study04.domain.vo.Criteria;

import java.util.List;

public interface BoardService {
    public List<BoardVO> getList(Criteria criteria);
    public BoardVO read(Long boardBno);
    public int register(BoardVO boardVO);
    public int remove(Long boardBno);
    public int modify(BoardVO boardVO);
    public int getTotal();
}

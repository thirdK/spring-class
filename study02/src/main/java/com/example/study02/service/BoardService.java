package com.example.study02.service;

import com.example.study02.domain.vo.BoardVO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BoardService {
    public void register(BoardVO boardVO);
    public BoardVO read(Long boardBno);
    public boolean modify(BoardVO boardVO);
    public List<BoardVO> getList();
    public boolean remove(Long boardBno);
}

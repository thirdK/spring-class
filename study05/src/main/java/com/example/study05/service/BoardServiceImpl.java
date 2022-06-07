package com.example.study05.service;

import com.example.study05.domain.dao.BoardDAO;
import com.example.study05.domain.vo.BoardVO;
import com.example.study05.domain.vo.Criteria;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService{
    public final BoardDAO boardDAO;

    @Override
    public BoardVO read(Long boardBno){ return boardDAO.read(boardBno); }
    @Override
    public List<BoardVO> getList(Criteria criteria){ return boardDAO.getList(criteria); }
    @Override
    public boolean register(BoardVO boardVO){ return boardDAO.register(boardVO); }
    @Override
    public boolean modify(BoardVO boardVO){ return boardDAO.modify(boardVO); }
    @Override
    public boolean remove(Long boardBno){ return boardDAO.remove(boardBno); }

    @Override
    public int getTotal() { return boardDAO.getTotal(); }
}

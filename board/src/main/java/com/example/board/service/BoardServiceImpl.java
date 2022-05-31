package com.example.board.service;

import com.example.board.domain.dao.BoardDAO;
import com.example.board.domain.vo.BoardVO;
import com.example.board.domain.vo.Criteria;
import com.example.board.domain.vo.PageDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService{
    public final BoardDAO boardDAO;

    @Override
    public void register(BoardVO boardVO) {
        boardDAO.register(boardVO);
    }

    @Override
    public BoardVO read(Long boardBno) {
        return boardDAO.read(boardBno);
    }

    @Override
    public boolean modify(BoardVO boardVO) {
        return boardDAO.modify(boardVO);
    }

    @Override
    public boolean remove(Long boardBno) {
        return boardDAO.remove(boardBno);
    }

    @Override
    public List<BoardVO> getList(Criteria criteria) {
        return boardDAO.getList(criteria);
    }

    @Override
    public int getTotalPage() { return boardDAO.getTotalPage();}

    @Override
    public int getMyTotal(Criteria criteria) {
        return boardDAO.getMyTotal(criteria) ;
    }
}
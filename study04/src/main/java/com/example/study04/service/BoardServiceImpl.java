package com.example.study04.service;

import com.example.study04.domain.dao.BoardDAO;
import com.example.study04.domain.vo.BoardVO;
import com.example.study04.domain.vo.Criteria;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService{
    private final BoardDAO boardDAO;

    @Override
    public List<BoardVO> getList(Criteria criteria) {
        return boardDAO.getList(criteria);
    }

    @Override
    public BoardVO read(Long boardBno) {
        return boardDAO.read(boardBno);
    }

    @Override
    public int register(BoardVO boardVO) {
        return boardDAO.register(boardVO);
    }

    @Override
    public int remove(Long boardBno) {
        return boardDAO.remove(boardBno);
    }

    @Override
    public int modify(BoardVO boardVO) {
        return boardDAO.modify(boardVO);
    }

    @Override
    public int getTotal() {
        return boardDAO.getTotal();
    }
}

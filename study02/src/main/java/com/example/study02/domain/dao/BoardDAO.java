package com.example.study02.domain.dao;

import com.example.study02.domain.vo.BoardVO;
import com.example.study02.mapper.BoardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository //Component대신 DAO에서 사용하는 어노테이션
@RequiredArgsConstructor
public class BoardDAO {
    private final BoardMapper boardMapper;

    public List<BoardVO> getList(){return boardMapper.getList();}
    public void register(BoardVO boardVO){boardMapper.insert(boardVO);}
    public BoardVO read(Long boardBno){return boardMapper.get(boardBno);};
    public boolean remove(Long boardBno){return boardMapper.delete(boardBno) != 0;}
    public boolean modify(BoardVO boardVO){return boardMapper.update(boardVO) != 0;}
}

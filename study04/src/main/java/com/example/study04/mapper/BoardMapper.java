package com.example.study04.mapper;

import com.example.study04.domain.vo.BoardVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {
    public List<BoardVO> getList();
    public BoardVO get(Long boardBno);
    public int insert(BoardVO boardVO);
    public int delete(Long boardBno);
    public int update(BoardVO boardVO);
}

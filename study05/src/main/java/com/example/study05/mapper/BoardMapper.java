package com.example.study05.mapper;

import com.example.study05.domain.vo.BoardVO;
import com.example.study05.domain.vo.Criteria;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {
    public BoardVO get(Long boardBno);
    public List<BoardVO> getList(Criteria criteria);
    public int insert(BoardVO boardVO);
    public int update(BoardVO boardVO);
    public int delete(Long boardBno);
    public int getTotal();
}

package com.example.study02.mapper;

import com.example.study02.domain.vo.BoardVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {
//    게시글 목록
    public List<BoardVO> getList();

//    게시글 등록
    public void insert(BoardVO boardVO);

//    게시글 상세보기
    public BoardVO get(Long boarBno);

//    게시글 삭제
    public int delete(Long boarBno);

//    게시글 수정
    public int update(BoardVO boardVO);
}

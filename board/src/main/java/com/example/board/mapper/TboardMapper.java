package com.example.board.mapper;

import com.example.board.domain.vo.TboardVO;
import com.example.board.domain.vo.Tcriteria;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TboardMapper {
    public TboardVO get(Long tboardNumber);
    public List<TboardVO> getList(Tcriteria tcriteria);
    public int insert(TboardVO tboardVO);
    public int delete(Long tboardNumber);
    public int update(TboardVO tboardVO);
}

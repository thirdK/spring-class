package com.example.board.domain.dao;

import com.example.board.domain.vo.TboardVO;
import com.example.board.domain.vo.Tcriteria;
import com.example.board.mapper.TboardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class TboardDAO {
    private final TboardMapper tboardMapper;

    public TboardVO read(Long tboardNumber){ return tboardMapper.get(tboardNumber);}
    public List<TboardVO> getList(Tcriteria tcriteria){ return tboardMapper.getList(tcriteria); }
    public boolean register(TboardVO tboardVO){ return tboardMapper.insert(tboardVO) != 0;}
    public boolean remove(Long tboardNumber){ return tboardMapper.delete(tboardNumber) != 0;}
    public boolean modify(TboardVO tboardVO){ return tboardMapper.update(tboardVO) != 0;}
}

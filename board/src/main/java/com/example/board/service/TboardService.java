package com.example.board.service;

import com.example.board.domain.dao.TboardDAO;
import com.example.board.domain.vo.TboardVO;
import com.example.board.domain.vo.Tcriteria;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TboardService {
    private final TboardDAO tboardDAO;
    
    public TboardVO read(Long tboardNumber){ return tboardDAO.read(tboardNumber);}
    public List<TboardVO> getList(Tcriteria tcriteria){ return tboardDAO.getList(tcriteria); }
    public boolean register(TboardVO tboardVO){ return tboardDAO.register(tboardVO);}
    public boolean remove(Long tboardNumber){ return tboardDAO.remove(tboardNumber);}
    public boolean modify(TboardVO tboardVO){ return tboardDAO.modify(tboardVO);}
}

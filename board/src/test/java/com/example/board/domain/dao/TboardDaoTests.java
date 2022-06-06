package com.example.board.domain.dao;

import com.example.board.domain.vo.TboardVO;
import com.example.board.domain.vo.Tcriteria;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@RequiredArgsConstructor
@Slf4j
public class TboardDaoTests {
    @Autowired
    private TboardDAO tboardDAO;

    @Test
    public void insertTest(){
        TboardVO tboardVO = new TboardVO();
        tboardVO.setTboardTitle("test2");
        tboardVO.setTboardContent("bbbbbbb");
        tboardVO.setTboardWriter("홍길동");
        tboardDAO.register(tboardVO);
    }
    @Test
    public void getTest(){
        tboardDAO.read(1L);
    }

    @Test
    public void getListTest(){
        tboardDAO.getList(new Tcriteria());
    }

    @Test
    public void deleteTest(){
        tboardDAO.remove(1L);
    }

    @Test
    public void updateTest(){
        TboardVO tboardVO = tboardDAO.read(2L);
        log.info(tboardVO.toString());
        tboardVO.setTboardTitle("수정");
        tboardVO.setTboardContent("수정합니다!!!!!!!!!!");
        tboardDAO.modify(tboardVO);
    }
}

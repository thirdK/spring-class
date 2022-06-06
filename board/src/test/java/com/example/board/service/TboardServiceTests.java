package com.example.board.service;

import com.example.board.domain.vo.TboardVO;
import com.example.board.domain.vo.Tcriteria;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class TboardServiceTests {
    @Autowired
    private TboardService tboardService;

    @Test
    public void insertTest(){
        TboardVO tboardVO = new TboardVO();
        tboardVO.setTboardTitle("test3");
        tboardVO.setTboardContent("bbbbbbb");
        tboardVO.setTboardWriter("홍길동");
        tboardService.register(tboardVO);
    }
    @Test
    public void getTest(){
        tboardService.read(128L);
    }

    @Test
    public void getListTest(){
        tboardService.getList(new Tcriteria());
    }

    @Test
    public void deleteTest(){
        tboardService.remove(128L);
    }

    @Test
    public void updateTest(){
        TboardVO tboardVO = tboardService.read(127L);
        log.info(tboardVO.toString());
        tboardVO.setTboardTitle("수정");
        tboardVO.setTboardContent("수정합니다!!!!!!!!!!");
        tboardService.modify(tboardVO);
    }
}

package com.example.board.mapper;

import com.example.board.domain.vo.TboardVO;
import com.example.board.domain.vo.Tcriteria;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class TboardMapperTests {
    @Autowired
    private TboardMapper tboardMapper;

    @Test
    public void insertTest(){
        TboardVO tboardVO = new TboardVO();
        tboardVO.setTboardTitle("test2");
        tboardVO.setTboardContent("bbbbbbb");
        tboardVO.setTboardWriter("홍길동");
        tboardMapper.insert(tboardVO);
    }
    @Test
    public void getTest(){
        tboardMapper.get(1L);
    }

    @Test
    public void getListTest(){
        tboardMapper.getList(new Tcriteria());
    }

    @Test
    public void deleteTest(){
        tboardMapper.delete(1L);
    }

    @Test
    public void updateTest(){
        TboardVO tboardVO = tboardMapper.get(2L);
        log.info(tboardVO.toString());
        tboardVO.setTboardTitle("수정");
        tboardVO.setTboardContent("수정합니다!!!!!!!!!!");
        tboardMapper.update(tboardVO);
    }

}

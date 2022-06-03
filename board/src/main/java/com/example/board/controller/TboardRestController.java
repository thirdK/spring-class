package com.example.board.controller;

import com.example.board.domain.vo.TboardVO;
import com.example.board.service.TboardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/tboard/rest/*")
@Slf4j
public class TboardRestController {
    private final TboardService tboardService;

    @GetMapping("/test1")
    public String test1(){
        return tboardService.read(7L).getTboardContent();
    }

    @GetMapping("/test2")
    public TboardVO test2(){
        TboardVO tboardVO = tboardService.read(4L);
        return tboardVO;
    }

    @GetMapping("/test3/{number}")
    public String test3(@PathVariable("number") String number){
        Long num = Long.parseLong(number);
        return tboardService.read(num).getTboardTitle();
    }

    @PostMapping("/test4")
    public TboardVO test4(@RequestBody TboardVO tboardVO){
        tboardVO.setTboardTitle("수정하여 반환");
        tboardVO.setTboardContent("수정하여 반환");
        return tboardVO;
    }

    @PostMapping("/test5/{writer}/{re}")
    public List<TboardVO> test5(@PathVariable("writer") String writer, @PathVariable("re") String re){
        List<TboardVO> list = tboardService.getList();
        List<TboardVO> list2 = new ArrayList<>();
        list.stream().filter(tboard -> tboard.getTboardWriter().equals("임태종")).forEach(tboard -> {
            tboard.setTboardWriter(re);
            list2.add(tboard);
        });
        return list2;
    }
}

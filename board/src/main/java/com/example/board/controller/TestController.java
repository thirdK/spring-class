package com.example.board.controller;

import com.example.board.domain.vo.TestVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/rest/*")
public class TestController {

    //1번 매개변수 없고 리턴은 문자열
    @GetMapping("/test1")
    public String test1(){
        return "1번 테스트결과";
    }
    //2번 매개변수 1개 있고 리턴은 문자열
    @GetMapping("/test2/{text}")
    public String test2(@PathVariable("text") String text){
        log.info(text);
        return "테스트2의 결과 : " + text;
    }
    //3번 매개변수 없고 리턴은 JSON Object
    @PostMapping("/test3")
    public TestVO test3(){
        TestVO testVO = new TestVO();
        testVO.setName("임태종");
        testVO.setAge("32");
        return testVO;
    }
    //4번 매개변수 여러 개 있고 리턴은 JSON Object
    @PostMapping(value = "/test4")
    public TestVO test4(@RequestBody TestVO testVO){
        return testVO;
    }

    //5번 매개변수 여러 개 있고 리턴은 JSON Array
    @PostMapping("/test5/{a}/{b}/{c}")
    public List<String> test5(@PathVariable("a") String a, @PathVariable("b")String b, @PathVariable("c")String c){
        List<String> testList = new ArrayList<>();
        testList.add(a);
        testList.add(b);
        testList.add(c);
        return testList;
    }
}

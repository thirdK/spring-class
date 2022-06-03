package com.example.board.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@RequestMapping("/test/*")
@Controller
@RequiredArgsConstructor
public class TestController2 {

    @GetMapping("/main")
    public String main(){
        return "/Test/test";
    }
}

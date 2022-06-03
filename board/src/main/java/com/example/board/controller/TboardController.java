package com.example.board.controller;

import com.example.board.service.TboardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/tboard/*")
@Slf4j
@RequiredArgsConstructor
public class TboardController {
    private final TboardService tboardService;

    @GetMapping("/main")
    public String goMain(){
        return "/tboard/main";
    }
}

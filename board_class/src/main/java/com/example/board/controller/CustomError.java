package com.example.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class CustomError {
    @GetMapping("/error")
    public String hanleError(HttpServletRequest request){
        return "error/error";
    }
}

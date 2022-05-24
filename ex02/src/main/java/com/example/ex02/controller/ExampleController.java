package com.example.ex02.controller;

import com.example.ex02.domain.vo.ExampleVO;
import com.example.ex02.domain.vo.TaskVO;
import com.example.ex02.domain.vo.UserVO;
import com.example.ex02.domain.vo.WorkVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.SimpleTimeZone;

@Controller
@RequestMapping("/ex/*")
@Slf4j
public class ExampleController {

    //    value에 경로를 작성하고, method에 호출할 서블릿 메소드를 설정한다.
    @RequestMapping(value = "/example", method = {RequestMethod.GET, RequestMethod.POST})
    public void ex01() {
        log.info("ex01.............................");
    }

    @GetMapping("")
    public void ex02() {
        log.info("ex02............................");
    }

    @GetMapping("/ex03")
    public String ex03(ExampleVO exampleVO) {
        log.info("-------------------------------------");
        log.info(exampleVO.toString());
        log.info("-------------------------------------");
        return "ex03";
    }

    @GetMapping("/ex04")
    public String ex04(TaskVO taskVO) {
        return "ex04";
    }

//    실습
//    아이디와 비밀번호를 입력받은 후 아이디가 admin일 경우 admin.html로 이동
//    아이디가 user일 경우 user.html로 이동
//    메소드는 리턴타입을 void로 선언한다.

//    -admin.html : 관리자 페이지 출력
//    -user.html : 일반 회원 페이지 출력

    @GetMapping("/login")
    public void login() {
    }

    @PostMapping("/login")
    public String login(UserVO userVO) {
        if (userVO.getId().equals("user")) {
            return "user";
        } else if (userVO.getId().equals("admin")) {
            return "admin";
        }
        return "login";
    }

//    실습
//    이름을 입력하고 출근 또는 퇴근 버튼을 클릭한다.
//    출근 시간은 09:00이며, 퇴근 시간 18:00이다.
//    출근 버튼 클릭 시 9시가 넘으면 지각으로 처리하고,
//    퇴근 버튼 클릭 시 18시 전이라면 퇴근이 아닌 업무시간으로 처리한다.

//    - 모든 html은 work 경로 안에 생성하며 아래와 같이 분기 별로 html문서 한 개씩 작성한다.
//    - getToWork.html
//    - leaveWork.html
//    - late.html
//    - work.html
//    *문자열을 Date 타입으로 변경 시키는 방법
//    - SimpleDateFormat 생성자에 전달받은 날짜 형식을 작성한다.
//    - parse() 메소드에 작성한 형식에 맞는 문자열을 전달하면 Date타입으로 변한다.
//    - format() 메소드에 Date 타입을 전달하면 문자열로 변한다.


    @GetMapping("/check")
    public String check() {
        return "check";
    }
    @PostMapping("/check")
    public String checkTime(WorkVO workVO) {
//        int hour = LocalDateTime.now().getHour();
//        int m = LocalDateTime.now().getMinute();
        Date now = new Date();
        String pattern = "HHmm";
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        String t = sdf.format(now);
        workVO.setTime(t.substring(0,2) + "시" + t.substring(2) + "분");
        int time = Integer.parseInt(t);

        log.info(t + "==============================================");

        log.info(workVO.getInTime() + "=====================================");

        if(workVO.getBtn().equals("inTimeBtn")){
            String t2 = workVO.getInTime().replaceFirst(":","");
            workVO.setTime(t2.substring(0,2) + "시" + t2.substring(2) + "분");
            time = Integer.parseInt(t2);
            return time <= 900 ? "getToWork" : "late";
        }


        if(workVO.getBtn().equals("in")){
            return time <= 900 ? "getToWork" : "late";
        }else{
            return time >1800 ? "leaveWork" : "work";
        }
    }



    @GetMapping("/getToWork")
    public String getToWork() {
        return "getToWork";
    }

    @GetMapping("/leaveWork")
    public String leaveWork() {
        return "leaveWork";
    }

    @GetMapping("/late")
    public String late() {
        return "late";
    }

    @GetMapping("/work")
    public String work() {
        return "work";
    }


}

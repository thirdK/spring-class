package com.example.ex02.controller;

import com.example.ex02.domain.vo.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLOutput;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

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
        return "work/check";
    }

    @PostMapping("/check")
    public String check(WorkVO workVO) {
//        int hour = LocalDateTime.now().getHour();
//        int m = LocalDateTime.now().getMinute();
        Date now = new Date();
        String pattern = "HHmm";
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        String t = sdf.format(now);
        workVO.setTime(t.substring(0, 2) + "시" + t.substring(2) + "분");
        int time = Integer.parseInt(t);

        log.info(t + "==============================================");

        log.info(workVO.getInTime() + "=====================================");

        if (workVO.getBtn().equals("inTimeBtn")) {
            String t2 = workVO.getInTime().replaceFirst(":", "");
            workVO.setTime(t2.substring(0, 2) + "시" + t2.substring(2) + "분");
            time = Integer.parseInt(t2);
            return time <= 900 ? "work/getToWork" : "work/late";
        }


        if (workVO.getBtn().equals("in")) {
            return time <= 900 ? "work/getToWork" : "work/late";
        } else {
            return time > 1800 ? "work/leaveWork" : "work/work";
        }
    }

//    실습
//    무기를 강화하기 위해서 아래에 있는 강화 주문서를 사용할 수 있다.
//    10% 공격력 주문서 : 공격력 + 80
//    60% 공격력 주문서 : 공격력 + 40
//    100% 공격력 주문서 : 공격력 + 10

//    한 번만 강화할 수 있으며, 10% 확률로 대성공을 한다.
//    대성공 시 해당 주문서 공격력의 5배가 증가한다.

//    ScrollVO 클래스 선언
//    10%, 60%, 100% 주문서의 공격력 수치를 저장한다.
//    기본 생성자를 호출 했을 때에는 위에 작성된 공격력 수치를 기본 값으로 설정하고,
//    만약 새로운 값을 받게 되면 해당 공격력 수치로 변경되도록 생성자를 오버로딩한다.
//    확률은 int[] 생성 60% / 10 으로 반복으로 1을 넣어줌
//    랜덤 클래스에서 nextInt(10)메소드

//    Random r = new Random();
//    int index = r.nextInt(10);
//    if(ar[index] == 1){
//      index = r.nextInt(10);
//      if(ar10[index] == 1){
//
//      }
//    }

    @GetMapping("/upgrade")
    public String upgrade(){
        return "upgrade/form";
    }

//    @GetMapping("/upgrade")
//    public String upgrade() {
//        return "upgrade/form";
//    }
//
//    @PostMapping("/upgrade")
//    public String upgrade(String choice, Model model) {
//        log.info("****************************: choice :::" + choice);
//        Random random = new Random();
//        int rate = Integer.parseInt(choice);
//        int index = random.nextInt(10);
//        int strength = 0;
//        int[] arr = new int[10];
//        int[] arr2 = new int[10];
//        arr2[3] = 1;
//
//        for (int i = 0; i < rate / 10; i++) {
//            arr[i] = 1;
//        }
//
//        if (arr[index] == 1) { //성공
//            index = random.nextInt(10);
//            if (arr2[index] == 1) {
//                //대성공
//                strength = getStrength(rate);
//                strength *= 5;
//                return "upgrade/bigSuccess";
//            } else {
//                //일반성공
//                strength = getStrength(rate);
//                return "upgrade/success";
//            }
//        } else {
//            return "upgrade/fail";  //실패
//        }
//    }

//    public boolean getChance(int rating){
//        Random random = new Random();
//
//    }

//    public int getStrength(int percent) {
//        int strength = 0;
//        if (percent == 10) strength = 80;
//        else if (percent == 60) strength = 40;
//        else strength = 10;
//
//        return strength;
//    }

//    실습
//    사용자가 입력한 바코드 번호에 알맞는 상품명을 전달한다.

    @GetMapping("/market")
    public String market() {
        return "product/market";
    }

    @PostMapping("/check2")
    public String check(String barcode, Model model) {
        String name = null;
        switch (barcode) {
            case "4383927":
                name = "오징어 땅콩";
                break;
            case "0832147":
                name = "초코 우유";
                break;
            case "9841631":
                name = "벌꿀 피자";
                break;
            case "5587578":
                name = "샌드위치";
                break;
        }
        model.addAttribute("name", name);
        return "product/casher";
    }
    
//   실습
//    아이디 : apple
//    비밀번호 : banana
//    로그인 성공 시 apple님 환영합니다.
//    로그인 실패 시 로그인 실패

    @GetMapping("/login2")
    public String login2(){return "login/login2";}

    @PostMapping("/login2")
    public String login2(LoginVO loginVO){
        if(loginVO.getId().equals("apple")){
            if(loginVO.getPw().equals("banana")){
                return "login/success";
            }
        }
        return "login/fail";
    }

//    노래방 기계 제작
//    사용자의 점수에 따른 알맞는 메세지 출력
    @GetMapping("/sing")
    public String sing(){
        return "sing/sing";
    }

    @GetMapping("/singOk")
    public String singCheck(String in, Model model){
        int score = Integer.parseInt(in);
        String msg = "";
        System.out.println("aaaaaaaaaaaaaaaaaaaaa");
        if(score >= 90) {
            msg="잘했어여";
        }else if(score >= 70){
            msg="아쉬워요";
        }else if(score >= 50){
            msg="분발하세요";
        } else{
            msg=".....";
        }
        model.addAttribute("msg", msg);
        return "sing/singCheck";
    }

//    1~2개 정도의 값을 model로 보낼 때 ModelAttribute 어노테이션을 사용하면 뷰로 보낼 수 있다.
//    @ModelAttribute("KEY") Object obj
//    전달받은 파라미터를 화면쪽으로 보낼 때 쉽고 간편하게 사용할 수 있다.
//    여러 개의 데이터를 보낼 때에는 Model 데이터 전달자를 사용하고,
//    2개 이하의 데이터를 보낼 때에는 @ModelAttribute()를 사용하는 것이 좋다.
    @GetMapping("/info")
    public void getInfo(@ModelAttribute("name") String name, @ModelAttribute("age") Integer age){}

//    동일한 이름의 파라미터가 여러 개 들어올 때에는 배열 또는 List로 매개변수를 설정한다.
//    이 때 동일한 이름으로 받아야 하기 때문에 @RequestParam("KEY")을 사용해서 전달받을 데이터의 KEY값을 지정해준다.
//    KEY 파라미터명이 전달되면 뒤에 있는 매개변수로 들어간다.

   @GetMapping("/datas")
    public void getDatas(@RequestParam("data")ArrayList<Integer> datas){
        log.info(String.valueOf(datas.size()));
        datas.stream().map(String::valueOf).forEach(log::info);
        datas.forEach(System.out::println);
    }
    //    파라미터 명과 매개변수 명이 다르면 직접 지정해준다.
    @GetMapping("/different")
    public void getData(@RequestParam("data") String name){}
}








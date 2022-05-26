package com.example.study01.controller;

import com.example.study01.domain.vo.KioskVO;
import com.example.study01.domain.vo.ScrollVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.lang.reflect.Member;
import java.util.Random;

@Controller
@RequestMapping("/ex/*")
@Slf4j
public class ExampleController {
    @GetMapping("/test")
    public String test() {
        return "test";
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
    @GetMapping("/tt")
    public String tt() {
        return "upgrade/test2";
    }

    @GetMapping("/upgrade")
    public String upgrade() {
        log.info("aa===============================================");
        return "upgrade/form";
    }

    @PostMapping("/upgrade")
    public String upgrade(String choice, Model model) {
        boolean check = false;
        int strength = 0;
        ScrollVO scrollVO = new ScrollVO();

        switch (Integer.parseInt(choice)) {
            case 10:
                check = isSuccess(10);
                strength = scrollVO.getPersent10();
                break;
            case 60:
                check = isSuccess(60);
                strength = scrollVO.getPersent60();
                break;
            case 100:
                check = isSuccess(100);
                strength = scrollVO.getPersent100();
        }

        if(!check){ return "upgrade/fail"; }
        if(isSuccess(10)){
            strength *= 5;
            model.addAttribute("strength", strength);
            return "upgrade/supperSuccess";
        }
        model.addAttribute("strength", strength);
        return "upgrade/success";
    }

    //확률을 받아 성공여부를 검사하는 메소드
    public boolean isSuccess(int rate) {
        Random r = new Random();
        int index = r.nextInt(10);
        int[] arr = new int[10];
        for (int i = 0; i < rate / 10; i++) {
            arr[i] = 1;
        }
        return arr[index] == 1;
    }

    //5개의 버튼을 가진 페이지로 페이지를 서로 이동하기
    @GetMapping("/move1")
    public String move1(){
        return "/fiveBtn/fiveBtnMain";
    }
    @GetMapping("/move2")
    public String move2(){
        return "/fiveBtn/fiveBtn2";
    }
    @GetMapping("/move3")
    public String move3(){
        return "/fiveBtn/fiveBtn3";
    }
    @GetMapping("/move4")
    public String move4(){
        return "/fiveBtn/fiveBtn4";
    }
    @GetMapping("/move5")
    public String move5(){
        return "/fiveBtn/fiveBtn5";
    }


    //키오스크(kiosk) 만들기
    //처음 페이지에 메뉴,가격을 보여주고 주문받으면 음식 이름/수량/가격이 있는 화면을 출력한다.
    @GetMapping("/kiosk")
    public String kiosk(){
        return "kiosk/kioskMain";
    }

    @PostMapping("/kiosk")
    public String kiosk(KioskVO kioskVO, Model model){
        int coke = kioskVO.getCoke();
        int ramen = kioskVO.getRamen();
        int d = kioskVO.getD();
        int dum = kioskVO.getDumpling();

        //값이 없을때 0이 나오는것을 html에서 조건처리를 못해서 model객체로 사용
        if(coke != 0) model.addAttribute("coke", "콜라 "+ coke);
        if(ramen != 0) model.addAttribute("ramen", "라면 " + ramen);
        if(d != 0) model.addAttribute("d", "떡볶이 "+d);
        if(dum != 0) model.addAttribute("dum", "만두 "+dum);

        return "kiosk/receipt";
    }



}

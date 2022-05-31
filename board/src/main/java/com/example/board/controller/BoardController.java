package com.example.board.controller;

import com.example.board.domain.vo.BoardVO;
import com.example.board.domain.vo.Criteria;
import com.example.board.domain.vo.PageDTO;
import com.example.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;

/*
 *   Task        URL                 Method      Parameter       Form        URL 이동
 *
 *   전체목록     /board/list          GET
 *   등록처리     /board/register      POST        모든 항목        필요         /board/list
 *   조회        /board/read          GET          bno
 *   삭제처리     /board/remove        GET         bno                         /board/list
 *   수정처리     /board/modify        POST        모든 항목        필요         /board/list
 *
 * */

//Controller를 Bean으로 등록
@Controller
@Slf4j  //log4j의 log를 사용하여 출력 테스트함
@RequestMapping("/board/*") // 요청의 /board 를 생략하기 위함
@RequiredArgsConstructor    //생성자 주입(final, NN)
public class BoardController {
    //BoardService를 생성자 주입으로 초기화한다.(해당 컨트롤러에 관련된 요청이들어오면)

    private final BoardService boardService;    //의존성 주입으로 초기화 됨

    //사용자의 요청이 URL을 통해 온다면 디스패처 서블릿이 핸들러 매핑에게 컨트롤러의 위치를 받아오고
    // 핸들러 매핑이 찾은 이 컨트롤러를 dispatcher servlet가
    // 핸들러 어댑터에게 알려주면 컨트롤러에서 사용자의 요청에 맞는 메소드를 실행한다.

    @GetMapping("/list")
//    리턴 타입을 void로 작성해도 되지만,
//    다른 컨트롤러에서 getList()를 호출하기 때문에
//    html 경로를 직접 문자열로 작성해야 한다.
    public String getList(Criteria criteria, Model model){
        //현재 페이지에 관련된 정보가 들어있는 criteria와 화면으로 데이터를 넘겨줄 model객체를 매개변수로 받는다.
        log.info("*************");
        log.info("/list");
        log.info("*************");
        int myTotal = boardService.getMyTotal(criteria);
        //모델객체에 boardList, pageDTO 키로 값을 저장한다.(화면으로 넘어가서 사용이 가능하다.)
        model.addAttribute("boardList", boardService.getList(criteria));
//        model.addAttribute("pageDTO", new PageDTO(criteria, boardService.getTotalPage()));
        model.addAttribute("pageDTO", new PageDTO(criteria, myTotal));
        //pageDTO라는 페이징에 필요한 정보를 가진 객체를 생성하며 생성자로 초기화해서 저장한다.
        log.info("==============================================");
        log.info("==============================================");

        return "/board/list";

        //핸들러 어댑터에게 문자열을 반환한다.(forward방식으로)
        //반환된 문자열은 뷰 리졸버에게 보내면 전체경로를 알려주고 뷰가 이동시킨다.
    }

    //get방식으로 register(글쓰기) 요청이 들어오면 단순 페이지 이동
    @GetMapping("/register")
    public void register(){}

    //post방식으로 register 요청이 들어오면 아래 메소드를 실행한다.
    @PostMapping("/register")
    //redirect방식으로 반환한다. (반환타입 RedirectView / 매개변수는 처리에 필요한 VO와 화면으로 넘길 값을 저장할 rttr)
    public RedirectView register(BoardVO boardVO, RedirectAttributes rttr){
        log.info("*************");
        log.info("/register");
        log.info("*************");
        boardService.register(boardVO); //service에 만들어둔 register메소드를 호출한다.

//        redirect 방식으로 전송할 때에는 request scope를 사용할 수 없다.
//        RedirectAttributes 객체는 두 가지 방법을 제공해준다.
//        1. 쿼리 스트링
//          URL 뒤에 전달한 KEY와 VALUE를 쿼리스트링으로 연결해준다.
//        rttr.addAttribute("boardBno", boardVO.getBoardBno());

//        2. Flash 사용
//          세션에 파라미터를 저장하고, request객체가 초기화 된 후 다시 저장해준다.
        rttr.addFlashAttribute("boardBno", boardVO.getBoardBno());
        //플래쉬로 데이터를 저장하여 사용한다.

        return new RedirectView("/board/list");
        //redirect방식으로 이동하기때문에 RedirectView객체에 문자열을 담아 반환한다.
    }

    //get방식으로 read, modify가 요청되면 아래 메소드를 실행한다.(게시글 상세, 수정)
    @GetMapping({"/read", "/modify"})
    public void read(Long boardBno, Criteria criteria, HttpServletRequest request, Model model){
        log.info("*************");
        String requestURL = request.getRequestURI();
        //현재 URL을 저장한다.
        log.info(requestURL.substring(requestURL.lastIndexOf("/")));
        //뒤에서 '/'를 찾아 인덱스로 반환하고 그 인덱스로 문자열을 잘라낸다.
        log.info("*************");
        log.info("================================");
        log.info(criteria.toString());
        //위에서 가공한 문자열이 read 또는 modify로 출력된다.
        log.info("================================");
        model.addAttribute("board", boardService.read(boardBno));
        //model객체에 board라는 키와 boardVO타입의 값을 저장한다.(화면에서 사용)
    }

//    수정
//    Redirect 방식으로 전송
//    Flash로 데이터 전달 - 수정 성공 시에만 "success" 전달
    @PostMapping("/modify")
    public RedirectView modify(BoardVO boardVO, Criteria criteria, RedirectAttributes rttr){
        log.info("*************");
        log.info("/modify");
        log.info("*************");
        log.info("================================");
        log.info(criteria.toString());
        log.info("================================");
        if(boardService.modify(boardVO)){
//            컨트롤러에서 다른 컨트롤러의 매개변수로 파라미터를 전달할 때에는
//            addAttribute(), 쿼리스트링 방식으로 전달해야 받을 수 있다.
//            Flash방식은 최종 응답 화면에서 사용될 파라미터를 전달할 때에만 사용하도록 한다.
            rttr.addAttribute("boardBno", boardVO.getBoardBno());
            rttr.addAttribute("pageNum", criteria.getPageNum());
            rttr.addAttribute("amount", criteria.getAmount());
        }
        return new RedirectView("/board/read");
    }

    @PostMapping("/remove")
    public String remove(Long boardBno, Criteria criteria, Model model){
        log.info("*************");
        log.info("/remove");
        log.info("*************");
        boardService.remove(boardBno);
        //다른 컨트롤러로 이동하고자 할 때 해당 메소드를 직접 실행한다.
        //만약 필요한 파라미터가 있다면 최초 요청 처리 메소드를 통해 파라미터를 전달해준다.
        return getList(criteria, model);
        //redirect방식이 아닌 forward방식으로 이동할 때에는 컨트롤러를 거치지 않기 때문에
        //forward방식으로 컨트롤러에 거치기 위해 해당 메소드를 직접 호출한다.(어차피 getList()의 반환값도 문자열)
    }
}












package com.example.board.controller;

import com.example.board.domain.vo.BoardVO;
import com.example.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

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

@Controller
@Slf4j
@RequestMapping("/board/*")
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;

    @GetMapping("/list")
    public void getList(Model model){
        log.info("*************");
        log.info("/list");
        log.info("*************");
        model.addAttribute("boardList", boardService.getList());
    }

    @PostMapping("/register")
    public RedirectView register(BoardVO boardVO, RedirectAttributes rttr){
        log.info("*************");
        log.info("/register");
        log.info("*************");
        boardService.register(boardVO);

//        redirect 방식으로 전송할 때에는 request scope를 사용할 수 없다.
//        RedirectAttributes 객체는 두 가지 방법을 제공해준다.
//        1. 쿼리 스트링
//          URL 뒤에 전달한 KEY와 VALUE를 쿼리스트링으로 연결해준다.
//        rttr.addAttribute("boardBno", boardVO.getBoardBno());

//        2. Flash 사용
//          세션에 파라미터를 저장하고, request객체가 초기화 된 후 다시 저장해준다.
        rttr.addFlashAttribute("boardBno", boardVO.getBoardBno());

        return new RedirectView("/board/list");
    }

    @GetMapping("/read")
    public void read(Long boardBno, Model model){
        log.info("*************");
        log.info("/read");
        log.info("*************");
        model.addAttribute("board", boardService.read(boardBno));
    }

//    수정
//    Redirect 방식으로 전송
//    Flash로 데이터 전달 - 수정 성공 시에만 "success" 전달
    @PostMapping("/modify")
    public void modify(){

    }
}

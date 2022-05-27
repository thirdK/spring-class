package com.example.study02.controller;

import com.example.study02.domain.vo.BoardVO;
import com.example.study02.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@Slf4j
@RequestMapping("/board/*")
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;

    @GetMapping("/list")
    public void getList(Model model){
        log.info("*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*");
        log.info("/list");
        log.info("*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*");
        model.addAttribute("boardList", boardService.getList());
    }

    @PostMapping("/register")
    public RedirectView register(BoardVO boardVO, RedirectAttributes rttr){
        log.info("*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*");
        log.info("/register");
        log.info("*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*");
        boardService.register(boardVO);

        rttr.addFlashAttribute("boardBno", boardVO.getBoardBno());
        return new RedirectView("board/list");
    }

    @GetMapping("/read")
    public void read(Long boardBno, Model model){
        log.info("*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*");
        log.info("/read");
        log.info("*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*");
        model.addAttribute("board", boardService.read(boardBno));
    }

    @PostMapping("/modify")
    public RedirectView modify(BoardVO boardVO, RedirectAttributes rttr){
        log.info("*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*");
        log.info("/modify");
        log.info("*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*");
        String result = boardService.modify(boardVO) ? "Success" : "Fail";
        rttr.addFlashAttribute("result", result);
        return new RedirectView("/board/modify");
    }
}

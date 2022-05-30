package com.example.study04.controller;

import com.example.study04.domain.vo.BoardVO;
import com.example.study04.domain.vo.Criteria;
import com.example.study04.domain.vo.PageDTO;
import com.example.study04.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/board/*")
public class BoardController {
    private final BoardService boardService;

    @GetMapping("/list")
    public String getList(Criteria criteria, Model model){
        model.addAttribute("boardList",boardService.getList(criteria));
        model.addAttribute("pageDTO", new PageDTO(criteria, boardService.getTotal()));
        return "/board/list";
    }

    @GetMapping({"/read", "/modify"})
    public void read(Long boardBno, HttpServletRequest request, Model model){
        String requestURL = request.getRequestURI();
        log.info(requestURL.substring(requestURL.lastIndexOf("/")));
        model.addAttribute("board", boardService.read(boardBno));
    }

    @GetMapping("/register")
    public void register(){}

    @PostMapping("/register")
    public RedirectView register(BoardVO boardVO, RedirectAttributes rttr){
        boardService.register(boardVO);
        rttr.addFlashAttribute("boardBno", boardVO.getBoardBno());
        return new RedirectView("/board/list");
    }

    @PostMapping("/modify")
    public RedirectView modify(BoardVO boardVO){
        boardService.modify(boardVO);
        return new RedirectView("/board/list");
    }

    @GetMapping("/remove")
    public String remove(Long boardBno, Criteria criteria ,Model model){
        boardService.remove(boardBno);
        return getList(criteria, model);
    }

}

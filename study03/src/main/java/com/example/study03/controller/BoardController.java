package com.example.study03.controller;

import com.example.study03.domain.vo.BoardVO;
import com.example.study03.domain.vo.Criteria;
import com.example.study03.domain.vo.PageDTO;
import com.example.study03.service.BoardService;
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
@RequestMapping("/board/*")
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;

    @GetMapping("/list")
    public String getList(Criteria criteria, Model model){
        log.info("*************************************");
        log.info("/list");
        log.info("*************************************");
        model.addAttribute("boardList",boardService.getList(criteria));
        model.addAttribute("pageDTO", new PageDTO(criteria, boardService.getTotal()));
        return "/board/list";
    }

    @GetMapping("/register")
    public void register(){}

    @PostMapping("/register")
    public RedirectView register(BoardVO boardVO, RedirectAttributes rttr){
        log.info("*************************************");
        log.info("/list");
        log.info("*************************************");
        boardService.register(boardVO);
        rttr.addFlashAttribute("boardBno", boardVO.getBoardBno());
        return new RedirectView("/board/list");
    }

    @GetMapping("/remove")
    public String remove(Long boardBno, Model model){
        log.info("*************************************");
        log.info("/remove");
        log.info("*************************************");

        boardService.remove(boardBno);
        return getList(new Criteria(), model);
    }

    @GetMapping({"/read", "/modify"})
    public void read(Long boardBno, HttpServletRequest request, Model model){
        log.info("*************************************");
        String requestURL = request.getRequestURI();

        log.info(requestURL.substring(requestURL.lastIndexOf("/")));
        log.info("*************************************");

        model.addAttribute("board", boardService.read(boardBno));
    }

    @PostMapping("/modify")
    public RedirectView modify(BoardVO boardVO, RedirectAttributes rttr){
        log.info("*************************************");
        log.info("/read");
        log.info("*************************************");

        rttr.addFlashAttribute("boardBno", boardVO.getBoardBno());
        boardService.modify(boardVO);
        return new RedirectView("/board/list");
    }
}

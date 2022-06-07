package com.example.study05.controller;

import com.example.study05.domain.vo.BoardVO;
import com.example.study05.domain.vo.Criteria;
import com.example.study05.domain.vo.PageDTO;
import com.example.study05.service.BoardService;
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
@RequiredArgsConstructor
@RequestMapping("/board/*")
public class BoardController {
    private final BoardService boardService;

    @GetMapping("/list")
    public String list(Model model, Criteria criteria){
        model.addAttribute("boardList", boardService.getList(criteria));
        model.addAttribute("pageDTO", new PageDTO(criteria, boardService.getTotal()));
        return "/board/list";
    }

    @GetMapping({"/read", "/modify"})
    public void read(Long boardBno, Model model){
        model.addAttribute("board", boardService.read(boardBno));
    }

    @GetMapping("/register")
    public void register(){}

    @PostMapping("/register")
    public RedirectView register(BoardVO boardVO){
        boardService.register(boardVO);
        return new RedirectView("/board/list");
    }

    @PostMapping("/remove")
    public String remove(Long boardBno, Model model, Criteria criteria){
        log.info("remove.................................................");
        boardService.remove(boardBno);
        return list(model, criteria);
    }

    @PostMapping("/modify")
    public RedirectView modify(BoardVO boardVO, RedirectAttributes rttr){
        log.info(boardVO.toString());
        boardService.modify(boardVO);

        rttr.addAttribute("boardBno", boardVO.getBoardBno());
        return new RedirectView("/board/read");
    }
}

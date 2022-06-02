package com.example.board.controller;

import com.example.board.domain.vo.Criteria;
import com.example.board.domain.vo.ReplyVO;
import com.example.board.service.ReplyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("/test/*")
@RequiredArgsConstructor
public class TestController {
    private final ReplyService replyService;

    @GetMapping("/test1")
    public String test1(){
        return "test1";
    }

    @PostMapping(value = "/new", consumes = "application/json", produces = "text/plain; charset=utf-8")
    public ResponseEntity<String> create(@RequestBody ReplyVO replyVO) throws UnsupportedEncodingException{
        log.info("test");
        replyService.register(replyVO);
        return new ResponseEntity<>(new String("댓글 등록".getBytes(), "UTF-8"), HttpStatus.OK);
    }

    //댓글 1개 조회
    @GetMapping("/{rno}")
    public ReplyVO read(@PathVariable("rno") Long replyNumber){
        log.info("test............. : " + replyNumber);
        return replyService.read(replyNumber);
    }

    //댓글 전체 목록
    @GetMapping("/list/{bno}/{pno}")
    public List<ReplyVO> getList(@PathVariable("pno") int pageNum, @PathVariable("bno") Long boardBno){
        return replyService.getList(new Criteria(pageNum,10), boardBno);
    }

    //댓글 삭제
    @DeleteMapping("/{rno}")
    public void remove(@PathVariable("rno") Long replyNumber){
        replyService.remove(replyNumber);
    }
    //댓글 수정
}

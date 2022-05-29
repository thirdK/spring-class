package com.example.study03.controller;

import com.example.study03.domain.vo.Criteria;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@SpringBootTest
@Slf4j
public class BoardControllerTests {
    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @BeforeEach
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void getListTest() throws Exception {
        log.info(
                mockMvc.perform(MockMvcRequestBuilders.get("/board/list")
                        .param("pageNum", "13")
                        .param("amount", "10")
                ).andReturn().getModelAndView().getModelMap().toString()
        );
    }

    @Test
    public void registerTest() throws Exception {
        log.info(
                mockMvc.perform(
                        MockMvcRequestBuilders.post("/board/register")
                                .param("boardTitle", "테스트 새 글")
                                .param("boardContent", "테스트 새 글 내용")
                                .param("boardWriter", "홍길동")
                ).andReturn().getFlashMap().toString()
        );
    }

    @Test
    public void removeTest() throws Exception {
        log.info(
                mockMvc.perform(
                        MockMvcRequestBuilders.get("/board/remove")
                                .param("boardBno", "126")
                ).andReturn().getModelAndView().getViewName()
        );
    }

    @Test
    public void readTest() throws Exception {
        log.info(
                mockMvc.perform(
                        MockMvcRequestBuilders.get("/board/read")
                                .param("boardBno", "133")
                ).andReturn().getModelAndView().getModelMap().toString()
        );
    }

    @Test
    public void modifyTest() throws Exception {
        log.info(
                mockMvc.perform(MockMvcRequestBuilders.post("/board/modify")
                        .param("boardBno", "133")
                        .param("boardTitle", "수정한다.")
                        .param("boardContent", "수정한다.")
                ).andReturn().getFlashMap().toString()
        );
    }


}

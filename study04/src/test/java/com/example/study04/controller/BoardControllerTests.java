package com.example.study04.controller;

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
        log.info(mockMvc.perform(
                MockMvcRequestBuilders.get("/board/list")
        ).andReturn().getModelAndView().getModelMap().toString());
    }

    @Test
    public void readTest() throws Exception {
        log.info(
                mockMvc.perform(
                        MockMvcRequestBuilders.get("/board/read")
                                .param("boardBno", "137")
                ).andReturn().getFlashMap().toString()
        );
    }

    @Test
    public void registerTest() throws Exception {
        log.info("등록한 게시물 번호  :  " +
                mockMvc.perform(
                        MockMvcRequestBuilders.post("/board/register")
                                .param("boardTitle", "registerTest2")
                                .param("boardContent", "registerTest2")
                                .param("boardWriter", "registerTest2")
                ).andReturn().getFlashMap()
        );
    }

    @Test
    public void modify() throws Exception {
        log.info(
                mockMvc.perform(
                        MockMvcRequestBuilders.post("/board/modify")
                                .param("boardBno", "139")
                                .param("boardTitle", "수정ㅎㅎㅎㅎㅎㅎ")
                                .param("boardContent", "수정ㅎㅎㅎㅎㅎㅎ")
                ).andReturn().getFlashMap().toString()
        );
    }

    @Test
    public void remove() throws Exception {
        log.info(
            mockMvc.perform(
                    MockMvcRequestBuilders.get("/board/remove")
                    .param("boardBno", "139")
            ).andReturn().getModelAndView().getViewName()
        );
    }


}

package com.example.study05.controller;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class BoardControllerTests {
    //브라우저에서 URL을 요청한것 같은 환경을 만들어줌
    private MockMvc mockMvc;

    //서버 환경, 설정, 요청 등을 처리해주는 WebApplicationContext
    @Autowired
    private WebApplicationContext webApplicationContext;

    //하나의 Test가 실행되기 전에 한 번씩 실행됨
    @BeforeEach
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    void getListTest() throws Exception{
        log.info(
                mockMvc.perform(
                        MockMvcRequestBuilders.get("/board/list")
                ).andReturn().getModelAndView().getModelMap().toString()
        );
    }

    @Test
    void readTest() throws Exception{
        log.info(mockMvc.perform(
                MockMvcRequestBuilders.get("/board/read")
                .param("boardBno", "22")
        ).andReturn().getModelAndView().getModelMap().toString());
    }

    @Test
    void registerTest() throws Exception{
        log.info(mockMvc.perform(
                MockMvcRequestBuilders.post("/board/register")
        ).andReturn().getModelAndView().getModelMap().toString());
    }

    @Test
    void removeTest() throws Exception{
        log.info(mockMvc.perform(
                MockMvcRequestBuilders.post("/board/remove")
                .param("boardBno", "22")
        ).andReturn().getModelAndView().getModelMap().toString());
    }

    @Test
    void modify() throws Exception{
        log.info(mockMvc.perform(
                MockMvcRequestBuilders.post("/board/modify")
                .param("boardBno", "214")
                .param("boardTitle", "BoardControllerTest")
                .param("boardContent", "test test test modify")
                .param("boardWriter", "수정자")
        ).andReturn().getModelAndView().getModelMap().toString());
    }
}
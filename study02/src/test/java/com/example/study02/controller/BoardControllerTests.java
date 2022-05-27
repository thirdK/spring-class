package com.example.study02.controller;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletRequest;
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
        log.info(mockMvc.perform(MockMvcRequestBuilders.get("/board/list"))
                .andReturn().getModelAndView().getModelMap().toString());
    }

    @Test
    public void registerTest() throws Exception {
        log.info("작성한 글 번호 : " + mockMvc.perform(MockMvcRequestBuilders.post("/board/register")
                .param("boardTitle", "redirect방식으로 보내기")
                .param("boardContent", "ㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁ")
                .param("boardWriter", "홍홍홍홍")
        ).andReturn().getFlashMap());
    }

    @Test
    public void readTest() throws Exception{
        log.info(mockMvc.perform(MockMvcRequestBuilders.get("/board/read")
        .param("boardBno", "4")
        ).andReturn().getModelAndView().getModelMap().toString());
    }

    @Test
    public void modifyTest() throws Exception{
        log.info(mockMvc.perform(MockMvcRequestBuilders.post("/board/modify")
                .param("boardBno", "4")
                .param("boardTitle", "수정한다!!!!!!!")
                .param("boardContent", "수정했다!!!!!!!!!!!!!")
                .param("boardUpdateDate", "SYSDATE")
        ).andReturn().getFlashMap().toString());
    }
}

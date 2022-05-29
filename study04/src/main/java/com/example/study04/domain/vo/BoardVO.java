package com.example.study04.domain.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

/*

BOARD_BNO NUMBER,
BOARD_TITLE VARCHAR2(2000)NOT NULL,
BOARD_CONTENT VARCHAR2(2000)NOT NULL,
BOARD_WRITER VARCHAR2(1000)NOT NULL,
BOARD_REGISTER_DATE DATE DEFAULT SYSDATE,
BOARD_UPDATE_DATE DATE DEFAULT SYSDATE

*/

@Component
@Data
public class BoardVO {
    private Long boardBno;
    private String boardTitle;
    private String boardContent;
    private String boardWriter;
    private String boardRegisterDate;
    private String boardUpdateDate;
}

package com.example.board.domain.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class ReplyVO {
//    REPLY_NUMBER NUMBER(10),
//    BOARD_BNO NUMBER(10) NOT NULL,
//    REPLY_CONTENT VARCHAR2(2000) NOT NULL,
//    REPLY_WRITER VARCHAR2(1000) NOT NULL,
//    REPLY_REGISTER_DATE DATE DEFAULT SYSDATE,
//    REPLY_UPDATE_DATE DATE DEFAULT SYSDATE,
    private Long replyNumber;
    private Long boardBno;
    private String replyContent;
    private String replyWriter;
    private String replyRegisterDate;
    private String replyUpdateDate;
}

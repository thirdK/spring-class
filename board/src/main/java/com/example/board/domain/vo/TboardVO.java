package com.example.board.domain.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

//TBOARD_NUMBER NUMBER(10) PRIMARY KEY,
//TBOARD_CONTENT VARCHAR2(2000) NOT NULL,
//TBOARD_WRITER VARCHAR2(1000) NOT NULL,
//TBOARD_REGISTER_DATE DATE DEFAULT SYSDATE,
//TBOARD_UPDATE_DATE DATE DEFAULT SYSDATE
@Data
@Component
public class TboardVO {
    private Long tboardNumber;
    private String tboardTitle;
    private String tboardContent;
    private String tboardWriter;
    private String tboardRegisterDate;
    private String tboardUpdateDate;
}

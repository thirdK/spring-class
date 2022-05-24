package com.example.ex02.domain.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class WorkVO {
    private String name;
    private String btn;
    private String time;
    private String inTime;
}

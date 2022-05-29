package com.example.study03.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
@AllArgsConstructor
public class Criteria {
    private int pageNum;    //현재 페이지
    private int amount;     //한 페이지당 글의 수

    public Criteria() {
        this(1, 10);
    }
}

package com.example.ex02.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;
@Data
@Component
@AllArgsConstructor
public class ScrollVO {
    private int percentTen;
    private int percentSixty;
    private int percentHundred;

    public ScrollVO() {
        this(10, 40, 80);
    }
}

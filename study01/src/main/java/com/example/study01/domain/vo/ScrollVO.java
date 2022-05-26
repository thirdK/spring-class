package com.example.study01.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
@AllArgsConstructor
public class ScrollVO {
    private int persent10;
    private int persent60;
    private int persent100;

    public ScrollVO() {
        this(80, 40, 10);
    }
}

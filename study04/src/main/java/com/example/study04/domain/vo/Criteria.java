package com.example.study04.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
@AllArgsConstructor
public class Criteria {
    private int pageNum;
    private int amount;

    public Criteria() {
        this(1, 10);
    }
}

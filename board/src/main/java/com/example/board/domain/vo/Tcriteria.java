package com.example.board.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Tcriteria {
    private int pageNum;
    private int amount;

    public Tcriteria() {
        this(1, 10);
    }
}

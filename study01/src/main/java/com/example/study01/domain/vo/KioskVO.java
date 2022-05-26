package com.example.study01.domain.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class KioskVO {
    private int ramen;
    private int d;
    private int coke;
    private int dumpling;
    private int totalPrice;
}

package com.example.ex00.dependency.qualifier;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Outback implements Restaurant{

    @Override
    @Qualifier("outback")
    public boolean checkSidebar() {
        return true;
    }
}

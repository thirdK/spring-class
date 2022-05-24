package com.example.ex00.dependency.qualifier;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class Vips implements Restaurant{

    @Override
    @Qualifier("vips")
    @Primary
    public boolean checkSidebar() {
        return false;
    }
}

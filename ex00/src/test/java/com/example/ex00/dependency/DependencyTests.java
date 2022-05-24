package com.example.ex00.dependency;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class DependencyTests {
    @Autowired //test에서는 필드 주입을 권장한다.
    private Coding coding;  //의존성 주입은 클래스의 필드만 의미한다 -> 메소드 안에서는 new 사용해야함

    @Test
    public void dependencyTest(){
        log.info("-----------------------");
        log.info("coding : " + coding);
        log.info("computer : " + coding.getComputer());
        log.info("-----------------------");

    }
}

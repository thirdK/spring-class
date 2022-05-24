package com.example.ex00.dependency;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Data
@RequiredArgsConstructor    //final / @NonNull 이 붙은 필드를 초기화(주입을 받을 대상만 골라서 생성자 주입을 한다)
                            // @NonNull 은 Null을 막아준다.
public class Coding {
//    필드 주입 (단위 테스트에서 사용 권장)
//    굉장히 편하다.
//    final을 붙일 수 없기 때문에 다른 곳에서 변형이 가능하다.
//    순환 참조 시 오류가 발생하지 않기 때문에 StackOverFlow가 발생한다.

//    @Autowired
    private final Computer computer;

//    생성자 주입 (권장)
//    순환 참조 시 컴파일러 인지 가능, 오류 발생 (필드 주입의 단점을 보완)
//    메모리에 할당하면서 초기값으로 주입되므로 final 키워드 사용 가능, 다른 곳에서 변형 불가능하다.
//    의존성 주입이 되지 않으면 객체가 생성되지 않으므로 NullPointerException(NPE)를 방어할 수 있다.
//    @Autowired
//    public Coding(Computer computer) { //alt + insert 자동 생성
//        this.computer = computer;
//    }
}

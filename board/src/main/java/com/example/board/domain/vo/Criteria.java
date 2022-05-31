package com.example.board.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

@Component
@Data
@AllArgsConstructor
public class Criteria {
    private int pageNum;    //현재 페이지를 저장할 필드
    private int amount;     //한 페이지당 출력할 게시물 수를 저장할 필드
    private String type;
    private String keyword;

    public Criteria() {
        //기본생성자로 생성하면 필드를 1, 10으로 초기화한다.
        this(1, 10);
        //(어노테이션으로 만든 모든 필드를 매개변수로 받는 생성자를 사용함)
    }

    public Criteria(int pageNum, int amount) {
        this.pageNum = pageNum;
        this.amount = amount;
    }

    public String getListLink(){    //화면 전환에서 pageNum과 amount를 저장하고 쿼리스트링으로 반환하는 메소드
        UriComponentsBuilder builder = UriComponentsBuilder.fromPath("")
                .queryParam("pageNum", this.pageNum)
                .queryParam("amount", this.amount)
                .queryParam("type", this.type)
                .queryParam("keyword", this.keyword);
        return builder.toUriString();   //쿼리스트링 반환
    }

    public String[] getTypes(){
        return type == null ? new String[] {} : type.split("");
    }
}

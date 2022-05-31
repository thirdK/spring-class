package com.example.board.domain.vo;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class PageDTO {
    private Criteria criteria;  //현재 페이지, 한 페이지당 게시물 수.... 를 가진 객체를 저장할 수 있는 참조변수

    private int startPage;  //한 페이지 블록의 시작 페이지
    private int endPage;    //블록의 끝 페이지
    private int realEnd;    //전체 페이지 중 마지막 페이지 숫자
    private int pageCount;  //한 블록당 몇개의 페이지를 표시하는지 저장하는 필드
    private boolean prev, next; // 이전, 다음 여부를 boolean으로 저장

    private int total;      //총 게시글 수

    //두 개의 매개변수를 받으면 pageCount를 자동으로 10으로 초기화 하는 생성자 (연산은 다음 생성자에서 처리)
    public PageDTO(Criteria criteria, int total) {
        this(criteria, 10, total);
    }

    //3개의 매개변수를 받으면 다음과 같이 연산하여 필드를 초기화함
    public PageDTO(Criteria criteria, int pageCount, int total) {
        this.criteria = criteria;   //매개변수로 받은 Criteria 객체를 저장함
        this.total = total;         //위와 동일

        //블록의 끝 페이지 번호 = (현재 페이지번호 / 한 블럭당 페이지 수)를 올림 처리  *  한 블럭당 페이지 수
        this.endPage = (int)Math.ceil(criteria.getPageNum() / (double)pageCount) * pageCount;
        //블록의 시작 페이지 번호는 = 끝 페이지 번호 - 한 블럭당 페이지 수 + 1
        this.startPage = this.endPage - pageCount + 1;
        //전체 페이지 중 끝 페이지 번호 = (전체 게시글 수 / 한 페이지 당 게시글 수) 를 올림 처리
        this.realEnd = (int)Math.ceil((double)total / criteria.getAmount());

        if(realEnd < this.endPage){ //블록의 마지막보다 실제 마지막 페이지가 작다면
            this.endPage = realEnd; //블록의 마지막 = 실제 마지막 페이지
        }

        this.prev = this.startPage > 1; //이전 여부 = 블럭의 시작 페이지 > 1
        this.next = this.endPage < realEnd; //다음 여부 = 블럭의 끝 페이지 < 실제 마지막 페이지
    }
}

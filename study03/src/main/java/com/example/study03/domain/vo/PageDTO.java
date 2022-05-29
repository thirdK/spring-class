package com.example.study03.domain.vo;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class PageDTO {
    //페이징 규칙
    //현재 페이지 시작 글 번호 = (현재 페이지 - 1) * 페이지당 글 수 + 1
    //현재 페이지 시작 글 번호 = (pageNum-1) * amount + 1

    private Criteria criteria;

    private int startPage;  //블럭의 시작 페이지 번호
    private int endPage;    //블럭의 끝 페이지 번호
    private int realEnd;    //전체의 끝 페이지 번호(실제 끝 페이지 번호)
    private int pageCount;  //한 블럭당 몇 개의 페이지인지 나타냄
    private boolean prev, next; //다음, 이전 존재 여부

    private int total;      //전체 페이지 수

    public PageDTO(Criteria criteria, int total) {
        this(criteria, 10, total);
    }

    public PageDTO(Criteria criteria, int pageCount, int total) {
        this.criteria = criteria;
        this.total = total;
        this.endPage = (int)Math.ceil(criteria.getPageNum() / (double)pageCount) * pageCount;
        this.startPage = this.endPage - pageCount + 1;
        this.realEnd = (int)Math.ceil((double)total / criteria.getAmount());

        if(realEnd < this.endPage){
            this.endPage = realEnd;
        }

        this.prev = this.startPage > 1;
        this.next = this.endPage < realEnd;
    }
}

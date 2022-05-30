package com.example.study04.domain.vo;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class PageDTO {
    private Criteria criteria;

    private int startPage;
    private int endPage;
    private int realEnd;
    private int pageCount;

    private boolean prev, next;

    private int total;

    public PageDTO(Criteria criteria, int total) {
        this(criteria, 10, total);
    }

    public PageDTO(Criteria criteria, int pageCount, int total) {
        this.criteria = criteria;
        this.pageCount = pageCount;
        this.total = total;

        this.endPage = (int)Math.ceil(criteria.getPageNum()/(double)pageCount) * pageCount;
        this.startPage = this.endPage - pageCount + 1;

        this.realEnd = (int)Math.ceil((double)total/criteria.getAmount());

        if(this.realEnd < this.endPage){
            this.endPage = this.realEnd;
        }

        this.prev = this.startPage > 1;
        this.next = this.endPage < this.realEnd;
    }
}

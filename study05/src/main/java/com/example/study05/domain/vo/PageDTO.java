package com.example.study05.domain.vo;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@Component
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

        endPage = (int)Math.ceil(criteria.getPageNum()/(double)pageCount) * pageCount;
        startPage = endPage - pageCount + 1;
        realEnd = (int)Math.ceil((double)this.total / criteria.getAmount());

        if(endPage > realEnd){
            endPage = realEnd;
        }

        prev = startPage > 1;
        next = endPage < realEnd;
    }
}

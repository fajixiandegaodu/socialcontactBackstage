package com.socialContact.entity;

import java.util.List;

/**
 * @ClassName: PageResult
 * @Author: 86151
 * @Date: 2021/4/21 14:08
 * @Description: TODO
 */
/*用于Controller
* 返回结果*/
public class PageResult<T> {
    private Long total;
    private List<T> rows;

    public PageResult(Long  total,  List<T>  rows)  {
        super();
        this.total  =  total;
        this.rows  =  rows;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }
}

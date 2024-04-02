package com.onlines.entiry;

import java.io.Serializable;

public class PageDto implements Serializable {
    private static final long serialVersionUID = -3282168743406190217L;
    private int pageNum;
    private int pageSize;
    private long totalCount;

    public PageDto() {
    }

    public int getPageNum() {
        return this.pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return this.pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public long getTotalCount() {
        return this.totalCount;
    }

    public void setTotalCount(long totalCount) {
        this.totalCount = totalCount;
    }

}

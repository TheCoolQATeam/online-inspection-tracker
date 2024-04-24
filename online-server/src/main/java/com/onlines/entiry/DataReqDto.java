package com.onlines.entiry;

public class DataReqDto {
    private Integer beginDate;
    private Integer  endDate;
    private Integer  group;
    private  int pageNum;
    private  int pageSize;

    public Integer  getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Integer  beginDate) {
        this.beginDate = beginDate;
    }

    public Integer  getEndDate() {
        return endDate;
    }

    public void setEndDate(Integer  endDate) {
        this.endDate = endDate;
    }
    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
    public Integer getGroup() {
        return group;
    }

    public void setGroup(Integer group) {
        this.group = group;
    }
}

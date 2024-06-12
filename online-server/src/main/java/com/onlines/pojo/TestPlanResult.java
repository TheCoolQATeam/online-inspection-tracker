package com.onlines.pojo;

import java.util.Date;

public class TestPlanResult {
    private Long id;

    private String jenkinsId;

    private String url;

    private Integer totalNum;

    private Integer passedNum;

    private Integer failedNum;

    private Integer skipedNum;

    private Date beginTime;

    private Long duration;

    private Date createTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getJenkinsId() {
        return jenkinsId;
    }

    public void setJenkinsId(String jenkinsId) {
        this.jenkinsId = jenkinsId == null ? null : jenkinsId.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public Integer getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(Integer totalNum) {
        this.totalNum = totalNum;
    }

    public Integer getPassedNum() {
        return passedNum;
    }

    public void setPassedNum(Integer passedNum) {
        this.passedNum = passedNum;
    }

    public Integer getFailedNum() {
        return failedNum;
    }

    public void setFailedNum(Integer failedNum) {
        this.failedNum = failedNum;
    }

    public Integer getSkipedNum() {
        return skipedNum;
    }

    public void setSkipedNum(Integer skipedNum) {
        this.skipedNum = skipedNum;
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public Long getDuration() {
        return duration;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
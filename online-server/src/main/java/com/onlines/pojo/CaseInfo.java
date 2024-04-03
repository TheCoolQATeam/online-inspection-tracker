package com.onlines.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class CaseInfo {
    private Integer id;
    private String caseId;
    private String states;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;
    private String responseTime;
    private String failedReason;
    private String title;
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getCaseId() {
        return caseId;
    }
    public void setCaseId(String caseId) {
        this.caseId = caseId;
    }
    public String getStates() {
        return states;
    }
    public void setStates(String states) {
        this.states = states;
    }
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    public String getResponseTime() {
        return responseTime;
    }
    public void setResponseTime(String responseTime) {
        this.responseTime = responseTime;
    }
    public String getFailedReason() {
        return failedReason;
    }
    public void setFailedReason(String failedReason) {
        this.failedReason = failedReason;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
}
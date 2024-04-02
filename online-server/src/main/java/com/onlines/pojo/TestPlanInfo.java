package com.onlines.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import net.sf.jsqlparser.expression.DateTimeLiteralExpression;

import java.sql.Date;
import java.sql.Timestamp;

public class TestPlanInfo {
    private Integer id;
    private Integer jenkinsId;
    private String url;
    private Long duration;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Timestamp beginTime;
    private Integer passedNum;
    private Integer failedNum;
    private Integer skippedNum;
    private Integer totalNum;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getJenkinsId() {
        return jenkinsId;
    }
    public void setJenkinsId(Integer jenkinsId) {
        this.jenkinsId = jenkinsId;
    }
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public Long getDuration() {
        return duration;
    }
    public void setDuration(Long duration) {
        this.duration = duration;
    }
    public Timestamp getBeginTime() {
        return beginTime;
    }
    public void setTimestamp(Timestamp beginTime) {
        this.beginTime = beginTime;
    }

    public Integer getFailedNum() {
        return failedNum;
    }

    public void setFailedNum(Integer failedNum) {
        this.failedNum = failedNum;
    }

    public Integer getPassedNum() {
        return passedNum;
    }

    public void setPassedNum(Integer passedNum) {
        this.passedNum = passedNum;
    }

    public Integer getSkippedNum() {
        return skippedNum;
    }

    public void setSkippedNum(Integer skippedNum) {
        this.skippedNum = skippedNum;
    }

    public Integer getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(Integer totalNum) {
        this.totalNum = totalNum;
    }

    @Override
    public String toString() {
        return "testPlanResult{" +
                "id=" + id +
                ", jenkinsId=" + jenkinsId +
                ", url='" + url + '\'' +
                ", duration=" + duration +
                ", beginTime=" + beginTime +
                ", passedNum=" + passedNum +
                ", failedNum=" + failedNum +
                ", skippedNum=" + skippedNum +
                ", totalNum=" + totalNum +
                '}';
    }
}

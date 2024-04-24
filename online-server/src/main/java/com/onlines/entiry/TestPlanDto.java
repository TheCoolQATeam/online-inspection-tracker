package com.onlines.entiry;

public class TestPlanDto {
    private Integer id;
    private Long duration;
    private Long timestamp;
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

    public Long getDuration() {
        return duration;
    }
    public void setDuration(Long duration) {
        this.duration = duration;
    }
    public Long getTimestamp() {
        return timestamp;
    }
    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
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
                ", duration=" + duration +
                ", timestamp=" + timestamp +
                ", passedNum=" + passedNum +
                ", failedNum=" + failedNum +
                ", skippedNum=" + skippedNum +
                ", totalNum=" + totalNum +
                '}';
    }
}

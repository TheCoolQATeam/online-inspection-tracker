package com.onlines.pojo;

public class H5Stat {
    public Integer failedCaseCount;
    public Integer failedCaseCountBefore;

    public Integer timeoutCaseCount;
    public Integer timeoutCaseCountBefore;
    public Integer planCount;
    public Integer planCountBefore;


    public Integer getFailedCaseCount() {
        return failedCaseCount;
    }

    public Integer getPlanCount() {
        return planCount;
    }

    public Integer getTimeoutCaseCount() {
        return timeoutCaseCount;
    }

    public Integer getFailedCaseCountBefore() {
        return failedCaseCountBefore;
    }

    public Integer getPlanCountBefore() {
        return planCountBefore;
    }

    public Integer getTimeoutCaseCountBefore() {
        return timeoutCaseCountBefore;
    }

    public void setFailedCaseCount(Integer failedCaseCount) {
        this.failedCaseCount = failedCaseCount;
    }

    public void setPlanCount(Integer planCount) {
        this.planCount = planCount;
    }

    public void setTimeoutCaseCount(Integer timeoutCaseCount) {
        this.timeoutCaseCount = timeoutCaseCount;
    }

    public void setFailedCaseCountBefore(Integer failedCaseCountBefore) {
        this.failedCaseCountBefore = failedCaseCountBefore;
    }

    public void setPlanCountBefore(Integer planCountBefore) {
        this.planCountBefore = planCountBefore;
    }

    public void setTimeoutCaseCountBefore(Integer timeoutCaseCountBefore) {
        this.timeoutCaseCountBefore = timeoutCaseCountBefore;
    }

    @Override
    public String toString() {
        return super.toString();
    }

}

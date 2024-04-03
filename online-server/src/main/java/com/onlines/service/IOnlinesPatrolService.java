package com.onlines.service;

import com.github.pagehelper.PageInfo;
import com.onlines.entiry.CaseInfoDto;
import com.onlines.entiry.DataReqDto;
import com.onlines.entiry.OnlineSaleDto;
import com.onlines.pojo.H5Stat;
import com.onlines.pojo.OnlinesPatrol;

import java.util.Date;

public interface IOnlinesPatrolService {

    void insertInfoTest(OnlinesPatrol onlinesPatrol);

    PageInfo selectAll(OnlineSaleDto onlineSaleDto);
    //PageInfo updataCase(OnlineSaleDto onlineSaleDto);
    int updataCase(OnlinesPatrol onlinesPatrol);
    int deleteById(int id);
    int resetDatum(int id);
    PageInfo getCaseExecInfo(CaseInfoDto caseInfoDto);
    OnlinesPatrol getCaseBaseInfo(CaseInfoDto caseInfoDto);
    PageInfo getFailedCaseInfo(Date beginDate, Date endDate, DataReqDto params);
    PageInfo getTimeoutCaseInfo(Date beginDate, Date endDate, DataReqDto params);
    PageInfo getTestPlanList(Date beginDate, Date endDate, DataReqDto params);
    H5Stat getH5Stat(Date beginDate, Date endDate, Integer group);
}

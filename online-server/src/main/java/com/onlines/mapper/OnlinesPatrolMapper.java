package com.onlines.mapper;

import com.github.pagehelper.Page;
import com.onlines.entiry.OnlineSaleDto;
import com.onlines.pojo.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
@Mapper
public interface OnlinesPatrolMapper {

    long countByExample(OnlinesPatrolExample example);

    int deleteByExample(OnlinesPatrolExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(OnlinesPatrol record);

    int insertSelective(OnlinesPatrol record);

    List<OnlinesPatrol> selectByExample(OnlinesPatrolExample example);

    OnlinesPatrol selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") OnlinesPatrol record, @Param("example") OnlinesPatrolExample example);

    int updateByExample(@Param("record") OnlinesPatrol record, @Param("example") OnlinesPatrolExample example);

    int updateByPrimaryKeySelective(OnlinesPatrol record);

    int updateByPrimaryKey(OnlinesPatrol record);

//    PageInfo<OnlinesPatrol> selectAll();
    List<OnlinesPatrol> selectAll();
    Page<OnlinesPatrol> getOnlineList(OnlineSaleDto onlineSaleDto);


    String deleteInfo(String title);

    Page<CaseInfo> getCaseInfo(String id, Date beginDate, Date endDate);

    OnlinesPatrol getCaseBaseInfo(String id);

    Page<CaseInfo> getFailedCaseInfo(Date beginDate, Date endDate, Integer group);
    Page<CaseInfo> getFailedCaseInfo(Date beginDate, Date endDate);
    Page<CaseInfo> getTimeoutCaseInfo(Date beginDate, Date endDate, Integer group);
    Page<CaseInfo> getTimeoutCaseInfo(Date beginDate, Date endDate);
    Page<TestPlanInfo> getTestPlanList(Date beginDate, Date endDate);
    Integer getFailedCaseCount(Date beginDate, Date endDate, Integer group);
    Integer getTimeoutCaseCount(Date beginDate, Date endDate, Integer group);
    Integer getPlanCount(Date beginDate, Date endDate);

    OnlinesPatrol selectByTitle(String title);
    String selectByDatumAddress(String title);
    List<OnlinesPatrol> selectDate();
}
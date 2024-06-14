package com.onlines.mapper;

import com.github.pagehelper.Page;
import com.onlines.pojo.PlanResultTest;
import com.onlines.pojo.PlanResultTestExample;

import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PlanResultTestMapper {
    long countByExample(PlanResultTestExample example);

    int deleteByExample(PlanResultTestExample example);

    int deleteByPrimaryKey(Long id);

    int insert(PlanResultTest record);

    int insertSelective(PlanResultTest record);

    List<PlanResultTest> selectByExample(PlanResultTestExample example);

    PlanResultTest selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") PlanResultTest record, @Param("example") PlanResultTestExample example);

    int updateByExample(@Param("record") PlanResultTest record, @Param("example") PlanResultTestExample example);

    int updateByPrimaryKeySelective(PlanResultTest record);

    int updateByPrimaryKey(PlanResultTest record);

    Page<PlanResultTest> getTestPlanList(Date beginDate, Date endDate);
}
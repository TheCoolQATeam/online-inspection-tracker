package com.onlines.mapper;

import com.onlines.pojo.TestPlanResult;
import com.onlines.pojo.TestPlanResultExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TestPlanResultMapper {
    long countByExample(TestPlanResultExample example);

    int deleteByExample(TestPlanResultExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TestPlanResult row);

    int insertSelective(TestPlanResult row);

    List<TestPlanResult> selectByExample(TestPlanResultExample example);

    TestPlanResult selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("row") TestPlanResult row, @Param("example") TestPlanResultExample example);

    int updateByExample(@Param("row") TestPlanResult row, @Param("example") TestPlanResultExample example);

    int updateByPrimaryKeySelective(TestPlanResult row);

    int updateByPrimaryKey(TestPlanResult row);
}
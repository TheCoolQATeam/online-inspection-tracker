package com.onlines.mapper;

import com.onlines.pojo.CaseResponse;
import com.onlines.pojo.CaseResponseExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CaseResponseMapper {
    long countByExample(CaseResponseExample example);

    int deleteByExample(CaseResponseExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CaseResponse row);

    int insertSelective(CaseResponse row);

    List<CaseResponse> selectByExample(CaseResponseExample example);

    CaseResponse selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("row") CaseResponse row, @Param("example") CaseResponseExample example);

    int updateByExample(@Param("row") CaseResponse row, @Param("example") CaseResponseExample example);

    int updateByPrimaryKeySelective(CaseResponse row);

    int updateByPrimaryKey(CaseResponse row);
}
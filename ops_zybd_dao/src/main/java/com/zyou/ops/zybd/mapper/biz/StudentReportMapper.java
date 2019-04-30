package com.zyou.ops.zybd.mapper.biz;

import com.zyou.ops.util.base.BaseMapper;
import com.zyou.ops.zybd.entity.biz.StudentReport;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface StudentReportMapper extends BaseMapper<StudentReport,Integer> {
    int deleteByPrimaryKey(Integer ssId);

    Long insert(StudentReport record);

    int insertSelective(StudentReport record);

    StudentReport selectByPrimaryKey(Integer ssId);

    int updateByPrimaryKeySelective(StudentReport record);

    int updateByPrimaryKey(StudentReport record);

    //回访园所打卡数据
    List<Map> selectReturnVisitReport(@Param("startDate")String startDate,@Param("endDate")String endDate);
}
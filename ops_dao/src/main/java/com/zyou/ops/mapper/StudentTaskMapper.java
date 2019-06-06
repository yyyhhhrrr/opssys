package com.zyou.ops.mapper;

import com.zyou.ops.entity.StudentTask;
import com.zyou.ops.util.base.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentTaskMapper extends BaseMapper<StudentTask,Integer> {
    int deleteByPrimaryKey(Integer stId);

    Long insert(StudentTask record);

    int insertSelective(StudentTask record);

    StudentTask selectByPrimaryKey(Integer stId);

    int updateByPrimaryKeySelective(StudentTask record);

    int updateByPrimaryKey(StudentTask record);

    List<StudentTask> getStudentTaskListByClassType(@Param("st_class_type") Integer classType);
}
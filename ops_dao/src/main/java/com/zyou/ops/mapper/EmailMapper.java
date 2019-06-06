package com.zyou.ops.mapper;

import com.zyou.ops.entity.Email;
import com.zyou.ops.entity.Task;
import com.zyou.ops.util.base.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface EmailMapper extends BaseMapper<Email,Integer> {
    int deleteByPrimaryKey(Integer emailId);

    Long insert(Email record);

    int insertSelective(Email record);

    Email selectByPrimaryKey(Integer emailId);

    int updateByPrimaryKeySelective(Email record);

    int updateByPrimaryKey(Email record);

    List<Email> getTaskListByEmail(@Param("email_id")Integer id);

    Long addTaskByEmail(Map<String,Integer> map);

    Long deleteTaskByEmail(Map<String,Integer> map);

    List<Email> getEmailListByTask(@Param("tsk_id")Integer id);
}
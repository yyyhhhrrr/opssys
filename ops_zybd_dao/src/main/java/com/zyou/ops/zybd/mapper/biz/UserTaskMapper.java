package com.zyou.ops.zybd.mapper.biz;

import com.zyou.ops.util.base.BaseMapper;
import com.zyou.ops.zybd.entity.biz.UserTask;

public interface UserTaskMapper extends BaseMapper<UserTask,Integer> {
    int deleteByPrimaryKey(Long buId);

    Long insert(UserTask record);

    int insertSelective(UserTask record);

    UserTask selectByPrimaryKey(Long buId);

    int updateByPrimaryKeySelective(UserTask record);

    int updateByPrimaryKeyWithBLOBs(UserTask record);

    int updateByPrimaryKey(UserTask record);
}
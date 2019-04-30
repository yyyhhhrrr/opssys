package com.zyou.ops.zybd.mapper.bizbase;

import com.zyou.ops.util.base.BaseMapper;
import com.zyou.ops.zybd.entity.bizbase.Classes;

public interface ClassesMapper extends BaseMapper<Classes,Integer> {
    int deleteByPrimaryKey(Long bcId);

    Long insert(Classes record);

    int insertSelective(Classes record);

    Classes selectByPrimaryKey(Long bcId);

    int updateByPrimaryKeySelective(Classes record);

    int updateByPrimaryKey(Classes record);
}
package com.zyou.ops.zybd.mapper.sys;

import com.zyou.ops.util.base.BaseMapper;
import com.zyou.ops.zybd.entity.sys.Area;

public interface AreaMapper extends BaseMapper<Area,Integer> {
    int deleteByPrimaryKey(Integer saId);

    Long insert(Area record);

    int insertSelective(Area record);

    Area selectByPrimaryKey(Integer saId);

    int updateByPrimaryKeySelective(Area record);

    int updateByPrimaryKey(Area record);
}
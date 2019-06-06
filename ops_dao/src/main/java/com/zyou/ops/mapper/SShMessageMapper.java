package com.zyou.ops.mapper;

import com.zyou.ops.entity.SShMessage;
import com.zyou.ops.util.base.BaseMapper;

import java.util.List;

public interface SShMessageMapper extends BaseMapper<SShMessage,Integer> {
    int deleteByPrimaryKey(Integer sshId);

    Long insert(SShMessage record);

    int insertSelective(SShMessage record);

    SShMessage selectByPrimaryKey(Integer sshId);

    int updateByPrimaryKeySelective(SShMessage record);

    int updateByPrimaryKey(SShMessage record);

    List<SShMessage> selectByServer();
}
package com.zyou.ops.zybd.service.impl;

import com.zyou.ops.util.base.BaseMapper;
import com.zyou.ops.util.base.baseImpl.BaseServiceImpl;
import com.zyou.ops.util.datasource.DataSource;
import com.zyou.ops.zybd.entity.biz.UserTask;
import com.zyou.ops.zybd.mapper.biz.UserTaskMapper;
import com.zyou.ops.zybd.service.UserTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @BelongsProject: opssys
 * @BelongsPackage: com.zyou.ops.zybd.service.impl
 * @Author: yang
 * @CreateTime: 2019-05-21 14:27
 * @Description: ${Description}
 */

@Service
@DataSource("zybdDataSource")
public class UserTaskServiceImpl extends BaseServiceImpl<UserTask,Integer> implements UserTaskService {
    @Autowired
    private UserTaskMapper userTaskMapper;

    @Override
    public BaseMapper<UserTask, Integer> getBaseMapper() {
        return userTaskMapper;
    }

    @Override
    public Long insert(UserTask record) {
        return userTaskMapper.insert(record);
    }
}

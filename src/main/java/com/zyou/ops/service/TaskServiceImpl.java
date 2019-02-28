package com.zyou.ops.service;

import com.zyou.ops.entity.Task;
import com.zyou.ops.mapper.BaseMapper;
import com.zyou.ops.mapper.TaskMapper;
import com.zyou.ops.service.base.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @BelongsProject: opssys
 * @BelongsPackage: com.zyou.ops.service
 * @Author: yang
 * @CreateTime: 2019-02-13 14:00
 * @Description: ${Description}
 */
@Service
public class TaskServiceImpl extends BaseServiceImpl<Task,Integer> implements TaskService{

    @Autowired
    TaskMapper taskMapper;

    @Override
    public BaseMapper<Task, Integer> getBaseMapper() {
        return taskMapper;
    }


    @Override
    public List<Task> queryTaskList() throws DataAccessException {
        return taskMapper.queryTaskList();
    }
}

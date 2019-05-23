package com.zyou.ops.service.impl;

import com.zyou.ops.entity.StudentTask;
import com.zyou.ops.mapper.StudentTaskMapper;
import com.zyou.ops.service.StudentTaskService;
import com.zyou.ops.util.base.BaseMapper;
import com.zyou.ops.util.base.baseImpl.BaseServiceImpl;
import com.zyou.ops.util.datasource.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @BelongsProject: opssys
 * @BelongsPackage: com.zyou.ops.service.impl
 * @Author: yang
 * @CreateTime: 2019-05-21 15:47
 * @Description: ${Description}
 */

@Service
@DataSource("opsDataSource")
public class StudentTaskServiceImpl extends BaseServiceImpl<StudentTask,Integer> implements StudentTaskService {

    @Autowired
    private StudentTaskMapper studentTaskMapper;

    @Override
    public BaseMapper<StudentTask, Integer> getBaseMapper() {
        return studentTaskMapper;
    }

    @Override
    public List<StudentTask> getStudentTaskListByClassType(Integer classType) {
        return studentTaskMapper.getStudentTaskListByClassType(classType);
    }
}

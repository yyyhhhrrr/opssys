package com.zyou.ops.service;

import com.zyou.ops.entity.StudentTask;
import com.zyou.ops.util.base.BaseService;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @BelongsProject: opssys
 * @BelongsPackage: com.zyou.ops.service
 * @Author: yang
 * @CreateTime: 2019-05-21 15:46
 * @Description: ${Description}
 */
public interface StudentTaskService extends BaseService<StudentTask,Integer> {

    List<StudentTask> getStudentTaskListByClassType(Integer classType);
}

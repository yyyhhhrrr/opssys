package com.zyou.ops.service;

import com.zyou.ops.entity.Task;
import com.zyou.ops.util.base.BaseService;
import org.springframework.dao.DataAccessException;

import java.util.List;

/**
 * @BelongsProject: opssys
 * @BelongsPackage: com.zyou.ops.service
 * @Author: yang
 * @CreateTime: 2019-01-30 16:49
 * @Description: ${Description}
 */
public interface TaskService extends BaseService<Task,Integer> {
   List<Task> getTaskListNotInByEmail(Integer email_id);
}

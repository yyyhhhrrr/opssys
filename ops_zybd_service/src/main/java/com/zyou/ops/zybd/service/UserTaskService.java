package com.zyou.ops.zybd.service;

import com.zyou.ops.util.base.BaseService;
import com.zyou.ops.zybd.entity.biz.UserTask;

/**
 * @BelongsProject: opssys
 * @BelongsPackage: com.zyou.ops.zybd.service
 * @Author: yang
 * @CreateTime: 2019-05-21 14:27
 * @Description: ${Description}
 */
public interface UserTaskService extends BaseService<UserTask,Integer> {
    Long insert(UserTask record);
}

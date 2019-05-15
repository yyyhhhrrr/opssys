package com.zyou.ops.service;

import com.zyou.ops.entity.Email;
import com.zyou.ops.util.base.BaseService;
import org.apache.ibatis.annotations.Param;


import java.util.List;
import java.util.Map;

/**
 * @BelongsProject: opssys
 * @BelongsPackage: com.zyou.ops.service
 * @Author: yang
 * @CreateTime: 2019-05-10 16:22
 * @Description: ${Description}
 */
public interface EmailService extends BaseService<Email,Integer> {
    List<Email> getTaskListByEmail(Integer id);

    Long addTaskByEmail(Map<String,Integer> map);

    Long deleteTaskByEmail(Map<String,Integer> map);

    List<Email> getEmailListByTask(Integer id);
}

package com.zyou.ops.mapper;

import com.zyou.ops.entity.Task;
import com.zyou.ops.util.base.BaseMapper;
import org.springframework.dao.DataAccessException;

import java.util.List;

/**
 * @BelongsProject: opssys
 * @BelongsPackage: com.zyou.ops.mapper
 * @Author: yang
 * @CreateTime: 2019-01-30 17:09
 * @Description: ${Description}
 */
public interface TaskMapper extends BaseMapper<Task,Integer> {

    public List<Task> queryTaskList() throws DataAccessException;

}

package com.zyou.ops.mapper;

import com.zyou.ops.entity.Interface;
import com.zyou.ops.util.base.BaseMapper;
import org.springframework.dao.DataAccessException;

import java.util.List;

/**
 * @BelongsProject: opssys
 * @BelongsPackage: com.zyou.ops.mapper
 * @Author: yang
 * @CreateTime: 2019-01-30 17:08
 * @Description: ${Description}
 */
public interface InterfaceMapper extends BaseMapper<Interface, Integer> {
    public List<Interface> selectInterfaceExcpet(final Integer id) throws DataAccessException;
}

package com.zyou.ops.service.impl;


import com.zyou.ops.entity.Interface;
import com.zyou.ops.service.InterfaceService;
import com.zyou.ops.util.base.BaseMapper;
import com.zyou.ops.mapper.InterfaceMapper;
import com.zyou.ops.util.base.baseImpl.BaseServiceImpl;


import com.zyou.ops.util.datasource.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @BelongsProject: opssys
 * @BelongsPackage: com.zyou.ops.service
 * @Author: yang
 * @CreateTime: 2019-01-31 11:21
 * @Description: ${Description}
 */
@Service
@DataSource("opsDataSource")
public class InterfaceServiceImpl extends BaseServiceImpl<Interface,Integer> implements InterfaceService {

    @Autowired
    InterfaceMapper interfaceMapper;

    @Override
    public BaseMapper<Interface, Integer> getBaseMapper() {
        return interfaceMapper;
    }

    @Override
    public List<Interface> selectInterfaceExcpet(Integer id) throws DataAccessException {
        return interfaceMapper.selectInterfaceExcpet(id);
    }
}

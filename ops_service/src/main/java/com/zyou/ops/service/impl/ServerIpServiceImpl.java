package com.zyou.ops.service.impl;


import com.zyou.ops.entity.ServerIp;
import com.zyou.ops.service.ServerIpService;
import com.zyou.ops.util.base.BaseMapper;
import com.zyou.ops.mapper.ServerIpMapper;
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
 * @CreateTime: 2019-02-11 14:43
 * @Description: ${Description}
 */
@Service
@DataSource("opsDataSource")
public class ServerIpServiceImpl extends BaseServiceImpl<ServerIp,Integer> implements ServerIpService {
    @Autowired
    ServerIpMapper serverIpMapper;

    @Override
    public BaseMapper<ServerIp,Integer> getBaseMapper() {
        return serverIpMapper;
    }



}

package com.zyou.ops.service;

import com.zyou.ops.entity.ServerIp;
import com.zyou.ops.mapper.BaseMapper;
import com.zyou.ops.mapper.ServerIpMapper;
import com.zyou.ops.service.base.BaseServiceImpl;
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
public class ServerIpServiceImpl extends BaseServiceImpl<ServerIp,Integer> implements ServerIpService {
    @Autowired
    ServerIpMapper serverIpMapper;

    @Override
    public BaseMapper<ServerIp,Integer> getBaseMapper() {
        return serverIpMapper;
    }


    @Override
    public List<ServerIp> selcetServerExcpet(Integer id) throws DataAccessException {
        return serverIpMapper.selectServerExcpet(id);
    }
}

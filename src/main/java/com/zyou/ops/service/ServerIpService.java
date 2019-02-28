package com.zyou.ops.service;

import com.zyou.ops.entity.ServerIp;
import com.zyou.ops.service.base.BaseService;
import org.springframework.dao.DataAccessException;

import java.util.List;

/**
 * @BelongsProject: opssys
 * @BelongsPackage: com.zyou.ops.service
 * @Author: yang
 * @CreateTime: 2019-01-30 16:31
 * @Description: ${Description}
 */
public interface ServerIpService extends BaseService<ServerIp,Integer> {

    public List<ServerIp> selcetServerExcpet(Integer id) throws DataAccessException;
}

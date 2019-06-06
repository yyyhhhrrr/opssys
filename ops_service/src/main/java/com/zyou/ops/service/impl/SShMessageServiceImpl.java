package com.zyou.ops.service.impl;

import com.zyou.ops.entity.SShMessage;
import com.zyou.ops.mapper.SShMessageMapper;
import com.zyou.ops.service.SShMessageService;
import com.zyou.ops.util.base.BaseMapper;
import com.zyou.ops.util.base.baseImpl.BaseServiceImpl;
import com.zyou.ops.util.datasource.DataSource;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @BelongsProject: opssys
 * @BelongsPackage: com.zyou.ops.service.impl
 * @Author: yang
 * @CreateTime: 2019-06-06 15:26
 * @Description: ${Description}
 */
@Service
@DataSource("opsDataSource")
public class SShMessageServiceImpl extends BaseServiceImpl<SShMessage, Integer> implements SShMessageService {


    @Autowired
    private SShMessageMapper sShMessageMapper;

    @Override
    public BaseMapper<SShMessage, Integer> getBaseMapper() {
        return sShMessageMapper;
    }


    @Override
    public List<SShMessage> selectByServer() {
        return sShMessageMapper.selectByServer();
    }
}

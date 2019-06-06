package com.zyou.ops.service;

import com.zyou.ops.entity.SShMessage;
import com.zyou.ops.util.base.BaseService;
import com.zyou.ops.util.base.baseImpl.BaseServiceImpl;

import java.util.List;

/**
 * @BelongsProject: opssys
 * @BelongsPackage: com.zyou.ops.service
 * @Author: yang
 * @CreateTime: 2019-06-06 15:25
 * @Description: ${Description}
 */
public interface SShMessageService extends BaseService<SShMessage,Integer> {
    List<SShMessage> selectByServer();
}

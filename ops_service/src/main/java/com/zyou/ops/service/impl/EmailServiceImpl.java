package com.zyou.ops.service.impl;

import com.zyou.ops.entity.Email;
import com.zyou.ops.mapper.EmailMapper;
import com.zyou.ops.service.EmailService;
import com.zyou.ops.util.base.BaseMapper;
import com.zyou.ops.util.base.baseImpl.BaseServiceImpl;
import com.zyou.ops.util.datasource.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @BelongsProject: opssys
 * @BelongsPackage: com.zyou.ops.service.impl
 * @Author: yang
 * @CreateTime: 2019-05-10 16:22
 * @Description: ${Description}
 */
@Service
@DataSource("opsDataSource")
public class EmailServiceImpl extends BaseServiceImpl<Email,Integer> implements EmailService {

    @Autowired
    private EmailMapper emailMapper;

    @Override
    public BaseMapper<Email, Integer> getBaseMapper() {
        return emailMapper;
    }

    @Override
    public List<Email> getTaskListByEmail(Integer id) {
        return emailMapper.getTaskListByEmail(id);
    }

    @Override
    public Long addTaskByEmail(Map<String, Integer> map) {
        return emailMapper.addTaskByEmail(map);
    }

    @Override
    public Long deleteTaskByEmail(Map<String, Integer> map) {
        return emailMapper.deleteTaskByEmail(map);
    }

    @Override
    public List<Email> getEmailListByTask(Integer id) {
        return emailMapper.getEmailListByTask(id);
    }


}

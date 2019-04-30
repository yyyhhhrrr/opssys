package com.zyou.ops.service;

import com.zyou.ops.entity.User;
import com.zyou.ops.util.base.BaseService;
import org.springframework.dao.DataAccessException;

import java.util.List;

/**
 * @BelongsProject: opssys
 * @BelongsPackage: com.zyou.ops.service
 * @Author: yang
 * @CreateTime: 2019-01-30 16:49
 * @Description: ${Description}
 */
public interface UserService extends BaseService<User,Integer> {
    public User selectByUsername(String username) throws DataAccessException;

    public List<User> selectUser() throws  DataAccessException;

    public void insertUser(User user) throws DataAccessException;

//    public void insertMongoUser(User user) throws DataAccessException;
//
//    public User selectMongoUser() throws  DataAccessException;
}

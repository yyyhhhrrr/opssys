package com.zyou.ops.mapper;

import com.zyou.ops.entity.User;
import com.zyou.ops.util.base.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.dao.DataAccessException;

import java.util.List;

/**
 * @BelongsProject: opssys
 * @BelongsPackage: com.zyou.ops.mapper
 * @Author: yang
 * @CreateTime: 2019-01-30 17:10
 * @Description: ${Description
 */
public interface UserMapper extends BaseMapper<User,Integer> {

    public User selectByUsername(@Param(value = "username") String username) throws DataAccessException;

    public List<User> selectUser() throws DataAccessException;

    public void insertUser(User user) throws DataAccessException;



}

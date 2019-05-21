package com.zyou.ops.mapper;

import com.zyou.ops.entity.Permission;
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

//    public User selectByUsername(@Param(value = "username") String username) throws DataAccessException;
//
//    public List<User> selectUser() throws DataAccessException;
//
//    public void insertUser(User user) throws DataAccessException;


    /**
     * 根据账号获取账号密码
     * @param username
     * @return UserPojo
     */
    User getUserByUserName(@Param("username") String username);

    /**
     * 根据角色id获取该账号的权限
     * @param roleId
     * @return List
     */
    List<Permission> getPermissionsByRoleId(@Param("role_id")int roleId);

    /**
     * 根据userId获取角色id
     * @param userId
     * @return LIST
     */
    List<Integer> getUserRoleByUserId(@Param("user_id") int userId);



}

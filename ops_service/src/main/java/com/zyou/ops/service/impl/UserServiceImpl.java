package com.zyou.ops.service.impl;


import com.zyou.ops.entity.User;
import com.zyou.ops.service.UserService;
import com.zyou.ops.util.base.BaseMapper;
import com.zyou.ops.mapper.UserMapper;
import com.zyou.ops.util.base.baseImpl.BaseServiceImpl;
import com.zyou.ops.util.datasource.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @BelongsProject: opssys
 * @BelongsPackage: com.zyou.ops.service
 * @Author: yang
 * @CreateTime: 2019-01-31 11:16
 * @Description: ${Description}
 */
@Service
@DataSource("opsDataSource")
public class UserServiceImpl extends BaseServiceImpl<User,Integer> implements UserService {

    @Autowired
    private UserMapper userMapper;
//    @Autowired
//    private MongoTemplate mongoTemplate;


    @Override
    public BaseMapper<User, Integer> getBaseMapper() {
        return userMapper;
    }


    public User selectByUsername(String username){
        return userMapper.selectByUsername(username);

    }

    public List<User> selectUser() {
        return  userMapper.selectUser();
    }

    public void insertUser(User user){
        userMapper.insertUser(user);
    }

//    @Override
//    public void insertMongoUser(User user) throws DataAccessException {
//          mongoTemplate.save(user,"t_user");
//    }
//
//    @Override
//    public User selectMongoUser() throws DataAccessException {
////       Query query=new Query(Criteria.where("us_username").is("123"));
////       List<User> user=mongoTemplate.find(query,User.class);
////        return mongoTemplate.findAll(User.class);
//        Query sql = new Query(Criteria.where("us_username").is("123"));
//
//        return mongoTemplate.findOne(sql,User.class);
//    }


}

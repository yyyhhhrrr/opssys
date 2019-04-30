package com.zyou.ops.service;

import com.zyou.ops.entity.User;
import com.zyou.ops.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @BelongsProject: opssys
 * @BelongsPackage: com.zyou.ops.service
 * @Author: yang
 * @CreateTime: 2019-01-31 13:10
 * @Description: ${Description}
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:spring/applicationContext.xml"})
public class UserServiceImplTest {

    @Autowired
    UserService userService;

    @Test
    public void test() throws Exception {

//        User user=new User();
//        user.setUs_username("123");
//        user.setUs_password("123131");
//
//        userService.insertMongoUser(user);
//        User user=userService.selectMongoUser();
//        System.out.println(user);
    }
}
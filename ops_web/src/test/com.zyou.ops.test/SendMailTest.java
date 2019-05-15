package com.zyou.ops.test;

import com.zyou.ops.util.mail.SendMail;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.ArrayList;
import java.util.List;

/**
 * @BelongsProject: opssys
 * @BelongsPackage: com.zyou.ops.test
 * @Author: yang
 * @CreateTime: 2019-05-15 10:40
 * @Description: ${Description}
 */
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:spring/applicationContext.xml"})
public class SendMailTest {

    @Autowired
    private SendMail sendMail;

    @Test
    public void test(){
        List<String> emailList=new ArrayList<>();
        emailList.add("562605133@qq.com");
        sendMail.getContext("1","1",emailList,"404");
    }
}

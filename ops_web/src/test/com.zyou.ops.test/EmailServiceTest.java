package com.zyou.ops.test;

import com.zyou.ops.entity.Email;
import com.zyou.ops.entity.Interface;
import com.zyou.ops.service.EmailService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @BelongsProject: opssys
 * @BelongsPackage: com.zyou.ops.test
 * @Author: yang
 * @CreateTime: 2019-05-10 16:27
 * @Description: ${Description}
 */
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:spring/applicationContext.xml"})
public class EmailServiceTest {

    @Autowired
    private EmailService emailService;

    @Test
    public void test() throws Exception {
        List<Email> emailListByTask = emailService.getEmailListByTask(1);
        System.out.println(emailListByTask);

    }
}

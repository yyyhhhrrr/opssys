package com.zyou.ops.test;

import com.zyou.ops.quartz.conf.QuartzScheduler;
import com.zyou.ops.zybd.service.UserTaskService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * @BelongsProject: opssys
 * @BelongsPackage: com.zyou.ops.test
 * @Author: yang
 * @CreateTime: 2019-05-21 16:58
 * @Description: ${Description}
 */
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:spring/applicationContext.xml"})
public class UserTaskServiceTest {

    @Autowired
    private UserTaskService userTaskService;
    @Autowired
    private QuartzScheduler quartzScheduler;

    @Test
    public void test() throws SchedulerException {
       quartzScheduler.startJob();

    }
}

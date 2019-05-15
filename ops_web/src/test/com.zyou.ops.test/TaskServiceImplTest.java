package com.zyou.ops.test;

import com.zyou.ops.entity.Task;
import com.zyou.ops.service.TaskService;
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
 * @BelongsPackage: com.zyou.ops.service
 * @Author: yang
 * @CreateTime: 2019-02-13 17:33
 * @Description: ${Description}
 */
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:spring/applicationContext.xml"})
public class TaskServiceImplTest {

    @Autowired
    TaskService taskService;

    @Test
    public void test() throws Exception {
        List<Task> taskListNotInByEmail = taskService.getTaskListNotInByEmail(1);
        System.out.println(taskListNotInByEmail);


    }

}
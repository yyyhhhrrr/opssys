package com.zyou.ops.test;

import com.zyou.ops.entity.StudentTask;
import com.zyou.ops.service.StudentTaskService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

/**
 * @BelongsProject: opssys
 * @BelongsPackage: com.zyou.ops.test
 * @Author: yang
 * @CreateTime: 2019-05-21 15:55
 * @Description: ${Description}
 */
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:spring/applicationContext.xml"})
public class StudentTaskServiceTest {

    @Autowired
    private StudentTaskService studentTaskService;

    @Test
    public void test(){
        List<StudentTask> studentTaskListByClassType = studentTaskService.getStudentTaskListByClassType(1);
        System.out.println(studentTaskListByClassType.get(0).getSt_content().trim());

    }
}

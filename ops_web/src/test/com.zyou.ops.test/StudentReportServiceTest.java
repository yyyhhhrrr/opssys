package com.zyou.ops.test;

import com.zyou.ops.zybd.service.StudentReportService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @BelongsProject: opssys
 * @BelongsPackage: com.zyou.ops.test
 * @Author: yang
 * @CreateTime: 2019-04-29 15:33
 * @Description: ${Description}
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:spring/applicationContext.xml"})
public class StudentReportServiceTest {

    @Autowired
    private StudentReportService studentReportService;

    @Test
    public void test(){
        System.out.println(studentReportService.selectReturnVisitReport("2019-04-13",""));
    }
}

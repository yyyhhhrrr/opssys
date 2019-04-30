package com.zyou.ops.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @BelongsProject: opssys
 * @BelongsPackage: com.zyou.ops.service
 * @Author: yang
 * @CreateTime: 2019-02-13 11:07
 * @Description: ${Description}
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:spring/applicationContext-datasource.xml"})
public class ServerIpServiceImplTest {

    @Autowired
    ServerIpService serverIpService;



    @Test
    public void test() throws Exception {
           System.out.println(serverIpService.searchAll().get(0));
    }

}
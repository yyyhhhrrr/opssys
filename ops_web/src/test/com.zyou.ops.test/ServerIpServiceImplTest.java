package com.zyou.ops.test;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zyou.ops.entity.ServerIp;
import com.zyou.ops.service.ServerIpService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

/**
 * @BelongsProject: opssys
 * @BelongsPackage: com.zyou.ops.service
 * @Author: yang
 * @CreateTime: 2019-02-13 11:07
 * @Description: ${Description}
 */
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:spring/applicationContext.xml"})
public class ServerIpServiceImplTest {

    @Autowired
    ServerIpService serverIpService;



    @Test
    public void test() throws Exception {
        PageHelper.startPage(1,2);
        List<ServerIp> list=serverIpService.searchAll();
        PageInfo<ServerIp> p=new PageInfo<>(list);
        System.out.println(p.getList());
        System.out.println(list);

    }

}
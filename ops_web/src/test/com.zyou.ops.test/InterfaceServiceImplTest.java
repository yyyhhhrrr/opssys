package com.zyou.ops.test;

import com.zyou.ops.entity.Interface;
import com.zyou.ops.service.InterfaceService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @BelongsProject: opssys
 * @BelongsPackage: com.zyou.ops.service
 * @Author: yang
 * @CreateTime: 2019-02-13 09:49
 * @Description: ${Description}
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:spring/applicationContext.xml"})
public class InterfaceServiceImplTest {

    @Autowired
    private InterfaceService interfaceService;

    @Test
    public void test() throws Exception {

        List<Interface> itcList=interfaceService.searchAll();
        System.out.println(itcList);

    }

}
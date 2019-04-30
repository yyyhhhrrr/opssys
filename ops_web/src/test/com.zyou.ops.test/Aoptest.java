package com.zyou.ops.test;

import com.zyou.ops.entity.Interface;
import com.zyou.ops.service.impl.InterfaceServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @BelongsProject: opssys
 * @BelongsPackage: com.zyou.ops.test
 * @Author: yang
 * @CreateTime: 2019-04-18 15:54
 * @Description: ${Description}
 */
public class Aoptest {


        public static void main(String[] args) {
            ApplicationContext ctx = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
            InterfaceServiceImpl companyService= (InterfaceServiceImpl) ctx.getBean("interfaceServiceImpl");
            List<Interface> interfaceList = companyService.searchAll();
            System.out.println(interfaceList);
        }
}

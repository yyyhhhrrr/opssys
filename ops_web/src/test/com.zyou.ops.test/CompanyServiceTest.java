package com.zyou.ops.test;

import com.zyou.ops.entity.Interface;
import com.zyou.ops.service.InterfaceService;
import com.zyou.ops.zybd.entity.bizbase.Company;
import com.zyou.ops.zybd.entity.sys.Province;
import com.zyou.ops.zybd.mapper.bizbase.CompanyMapper;
import com.zyou.ops.zybd.service.CompanyService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @BelongsProject: opssys
 * @BelongsPackage: com.zyou.ops.test
 * @Author: yang
 * @CreateTime: 2019-04-17 17:10
 * @Description: ${Description}
 */

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:spring/applicationContext.xml"})
public class CompanyServiceTest {

    @Autowired
    private CompanyService companyService;

    @Test
    public void test() throws Exception {
        List<Province> provinces = companyService.selectProvince();
        System.out.println(provinces.get(0).getProvinceId());

    }
}
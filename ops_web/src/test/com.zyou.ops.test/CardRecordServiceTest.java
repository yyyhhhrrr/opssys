package com.zyou.ops.test;

import com.zyou.ops.service.InterfaceService;
import com.zyou.ops.util.poiTemplate.ProvinceExportExcel;
import com.zyou.ops.zybd.service.CardRecordService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @BelongsProject: opssys
 * @BelongsPackage: com.zyou.ops.test
 * @Author: yang
 * @CreateTime: 2019-04-19 14:32
 * @Description: ${Description}
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:spring/applicationContext.xml"})
public class CardRecordServiceTest {

    @Autowired
    private CardRecordService cardRecordService;

    @Autowired
    private InterfaceService interfaceService;

    @Test
    public void test() throws Exception {
//        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("MM月dd日");
//        Date date=new Date();
//        String day=simpleDateFormat.format(date);
//        System.out.println(day);
        String startDate="2019-04-17";
        String s=startDate+" 00:00:00";
        String e=startDate+" 23:59:59";
        List<Map> objects = cardRecordService.selectStudentReport(3354,s,e);


    }
}

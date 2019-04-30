package com.zyou.ops.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zyou.ops.entity.ServerIp;

import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.log4j.Logger;
import org.junit.Test;
import java.util.HashMap;
import java.util.Map;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @BelongsProject: opssys
 * @BelongsPackage: com.zyou.ops.service
 * @Author: yang
 * @CreateTime: 2019-02-19 09:04
 * @Description: ${Description}
 */
public class Test1 {

    private static Logger log= Logger.getLogger("File");

    @Test
    public void test(){
        int  a=1;
        //1
        System.out.println(1+"");
        //2
        Integer.toString(1);
        //3
        String f= String.valueOf(1);


        String b="1";

        int c=Integer.parseInt(b);

        String aa="重地";
        String cc="通话";
        System.out.println(aa.hashCode());
        System.out.println(cc.hashCode());
        System.out.println(aa.toString());



    }
}

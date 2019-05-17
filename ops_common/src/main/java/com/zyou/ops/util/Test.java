package com.zyou.ops.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zyou.ops.util.utils.HttpUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @BelongsProject: opssys
 * @BelongsPackage: com.zyou.ops.util
 * @Author: yang
 * @CreateTime: 2019-05-16 10:01
 * @Description: ${Description}
 */
public class Test {

    public static void main(String[] args) {
//        JSONObject json=new JSONObject();
//        List<String> list= new ArrayList<>();
//        Map<String,String> map=new HashMap<>();
//        map.put("key","123");
//        list.add("123");
//        list.add("123");
//        json.put("list",list);
//        json.put("list",2);
//        json.put("map",map);
//        json.put("int",1);
//        String s = JSONObject.toJSONString(json);
//        String a="{\"email_id\":\"1\",\"tsk_id\":7}";
//        JSONObject x = (JSONObject)JSON.parse(a);
//        Map xx=JSONObject.parseObject(a);
//        xx.put("email_id",((JSONObject) xx).getInteger("email_id"));
//        System.out.println(xx);
//        System.out.println(json);
//        System.out.println(s);
//        System.out.println(json.getString("int") instanceof String);
        JSONObject jsonObject=JSONObject.parseObject("{\"cardNum\":\"2787504611\",\"companyId\":\"180\"}");
        String s = HttpUtils.sendPost("http://39.104.137.176:7001/card/cardValidate", "{Content-Type=application/json,token=2951314e0796466EE5c36ae737566128}", jsonObject);
        System.out.println(s);
    }
}

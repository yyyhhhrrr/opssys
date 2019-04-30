package com.zyou.ops.service;

import java.util.Objects;

/**
 * @BelongsProject: opssys
 * @BelongsPackage: com.zyou.ops.service
 * @Author: yang
 * @CreateTime: 2019-02-25 14:48
 * @Description: ${Description}
 */
public class Mytest  {

    private static String a="";

    private static void test() throws MyException{
        System.out.println("aaa");
        if(a!=null){
            throw new MyException("aaaa出错");
        }
    }
    public static void test2(){
        try {
            test();
        } catch (MyException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        test2();
    }
}

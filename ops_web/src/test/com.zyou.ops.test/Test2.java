package com.zyou.ops.service;

import com.zyou.ops.entity.User;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @BelongsProject: opssys
 * @BelongsPackage: com.zyou.ops.service
 * @Author: yang
 * @CreateTime: 2019-02-25 14:03
 * @Description: ${Description}
 */
public class Test2 {




    public static void main(String[] args) throws IOException, ClassNotFoundException {
//        FileInputStream fileOutputStream=new FileInputStream("d:\\a.txt");
////        fileOutputStream.write("你好".getBytes());
//       System.out.println(fileOutputStream.read());

//        FileWriter fileWriter=new FileWriter("d:\\a.txt");
//        fileWriter.write("啊啊");
//        fileWriter.flush(); //字符流 必须要flush 才能写入文件
//        fileWriter.close();


        //缓存流
//        FileWriter fileWriter=new FileWriter("d://a.txt");
//        BufferedWriter bufferedWriter=new BufferedWriter(fileWriter);
//
//        bufferedWriter.write("啊啊啊");
//        bufferedWriter.flush();
//        bufferedWriter.close();

//        FileReader fileReader=new FileReader("d://a.txt");
//        int len=0;
//        while((len=fileReader.read())!=-1){
//            System.out.println((char)len);
//        }

        // 转换流
//        OutputStreamWriter outputStreamWriter=new OutputStreamWriter(new FileOutputStream("d://a.txt"), StandardCharsets.UTF_8);
//        outputStreamWriter.write("啊啊啊啊");
//        outputStreamWriter.flush();
//        outputStreamWriter.close();

    //序列化流
//        ObjectOutputStream objectOutputStream=new ObjectOutputStream(new FileOutputStream("d://a.txt"));
//        User user=new User();
//        user.setUs_username("aaaa");
//
//        objectOutputStream.writeObject(user);

        ObjectInputStream objectInputStream=new ObjectInputStream(new FileInputStream("d://a.txt"));
        Object o=objectInputStream.readObject();
        User user=(User)o;
        System.out.println(user.getUs_username());



    }
}

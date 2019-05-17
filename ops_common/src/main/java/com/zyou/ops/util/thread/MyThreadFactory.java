package com.zyou.ops.util.thread;

import com.zyou.ops.entity.Interface;
import com.zyou.ops.entity.ServerIp;
import com.zyou.ops.entity.Task;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadFactory;

/**
 * @BelongsProject: opssys
 * @BelongsPackage: com.zyou.ops.util
 * @Author: yang
 * @CreateTime: 2019-02-18 16:51
 * @Description: ${Description}
 */

/**
 * 线程工厂类
 */
public class MyThreadFactory implements ThreadFactory {

    //存储线程id的map
    public Map<Integer, Long> getThreadMap() {
        return threadMap;
    }

    public void setThreadMap(Map<Integer, Long> threadMap) {
        this.threadMap = threadMap;
    }

    private Map<Integer,Long> threadMap;

    private MyThreadFactory(){
        threadMap=new HashMap<>();
    }

    private static MyThreadFactory instance =new MyThreadFactory();

    public static MyThreadFactory getInstance(){
        return instance;
    }



    //生产线程
    @Override
    public Thread newThread(Runnable r) {
        return new Thread(r);
    }





    public static void main(String args[]){
//        MyThreadFactory myThreadFactory=MyThreadFactory.getInstance();
//        Task task=new Task();
//        ServerIp serverIp=new ServerIp();
//        serverIp.setSv_ip("39.104.13.49");
//        Interface itc=new Interface();
//        itc.setIt_port(7001);
//        itc.setIt_address("/card/cardValidate");
//
//        List<String> emailList=new ArrayList<>();
//        emailList.add("562605133@qq.com");
//        task.setAnInterface(itc);
//        task.setServerIp(serverIp);
//        task.setTsk_pm_header("{Content-Type=application/json,token=2951314e0796466EE5c36ae737566128}");
//        task.setTsk_pm_json("{\"cardNum\":\"2787504611\",\"companyId\":\"181\"}");
//        //    DetectionTask detectionTask = new DetectionTask(task);
//        MyThreadFactory factory = new MyThreadFactory();
//        Thread taskThread1=factory.newThread(new DetectionTask(task,true,emailList,));
//        Thread taskThread2=factory.newThread(new DetectionTask(task,true,emailList));
//        taskThread1.start();
//        taskThread2.start();
//        System.out.println("********"+taskThread1.getId());
//        System.out.println("********"+taskThread2.getId());



    }
}

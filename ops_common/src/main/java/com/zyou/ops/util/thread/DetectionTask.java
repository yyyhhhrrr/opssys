package com.zyou.ops.util.thread;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zyou.ops.entity.Task;
import com.zyou.ops.util.mail.SendMail;
import com.zyou.ops.util.utils.HttpUtils;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;


/**
 * @BelongsProject: opssys
 * @BelongsPackage: com.zyou.ops.util
 * @Author: yang
 * @CreateTime: 2019-02-18 17:11
 * @Description: ${Description}
 */

/**
 * 巡检任务类（实现runable接口）
 */
public class DetectionTask  implements Runnable {

    private Task task;//任务

    private List<String> emailList=new ArrayList<>();

    private SendMail sendMail;

    private volatile boolean flag;//true 执行 false 取消

    private static Logger log = Logger.getLogger(DetectionTask.class);

    private static Logger infoLogger = Logger.getLogger("INFO_LOG");

    private static Logger errorLogger = Logger.getLogger("ERROR_LOG");



    @Override
    public void run() {
        try {
            while (flag) {
                while (!Thread.currentThread().isInterrupted()) {
                                String result = "";//检测结果
                                String url = "http://" + task.getServerIp().getSv_ip() + ":" + task.getAnInterface().getIt_port() + task.getAnInterface().getIt_address();
                                String header = task.getTsk_pm_header();
                                String jsonString = task.getTsk_pm_json();
                                JSONObject json = JSON.parseObject(jsonString);
                                result = HttpUtils.sendPost(url, header, json);
                                if(result!=null){
                                    if(result.contains(task.getTsk_pm_result())){
                                       infoLogger.info("[访问成功] - [url:"+url+ "]");
                                     }
                                    else if(result.contains("404")){
                                        errorLogger.error("[访问失败,404] - [url:"+url+ "]");
                                        sendMail.getContext(task.getTsk_detail(),url,emailList,"404");
                                    }
                                    else if(result.contains("500")){
                                        errorLogger.error("[访问失败,500] - [url:"+url+ "]");
                                        sendMail.getContext(task.getTsk_detail(),url,emailList,"500");
                                    }
                                }
                                else{
                                        errorLogger.error("[访问失败] - [url:"+url+ "]");
                                    sendMail.getContext(task.getTsk_detail(),url,emailList,"访问失败");
                                }

                    Thread.sleep(task.getTsk_time());
                }
            }
        }catch (InterruptedException e) {
                System.out.println("thread is interrupted!");
            }



        }



    public DetectionTask(Task task, boolean flag, List<String> emailList, SendMail sendMail) {
        this.task = task;
        this.flag = flag;
        this.emailList=emailList;
        this.sendMail=sendMail;
    }
}

package com.zyou.ops.controller;

import com.zyou.ops.quartz.conf.QuartzScheduler;
import com.zyou.ops.util.utils.ValidateUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @BelongsProject: opssys
 * @BelongsPackage: com.zyou.ops.controller
 * @Author: yang
 * @CreateTime: 2019-05-21 15:58
 * @Description: ${Description}
 */

@RestController
@Api(value = "studentTask",description = "助力任务")
@RequestMapping("/studentTask")
public class StudentTaskController {

    @Autowired
    private QuartzScheduler quartzScheduler;

    @RequestMapping(value = "/start",method = RequestMethod.POST,produces = "text/html;charset=UTF-8")
    @ApiOperation("开启系统任务")
    public String start() throws SchedulerException {
        Trigger.TriggerState jobState = quartzScheduler.getJobState("job1", "group1");
        if (jobState== Trigger.TriggerState.NONE){
            quartzScheduler.startJob();
            return "开启成功";
        }else if(jobState== Trigger.TriggerState.NORMAL){
            return "任务已经开启";
        }else if(jobState== Trigger.TriggerState.PAUSED){
            quartzScheduler.resumeJob("job1","group1");
            return "开启成功";
        }
        return "错误";
    }

    @RequestMapping(value = "/stop",method = RequestMethod.POST,produces = "text/html;charset=UTF-8")
    @ApiOperation("关闭系统任务")
    public String stop() throws SchedulerException {
        Trigger.TriggerState jobState = quartzScheduler.getJobState("job1", "group1");
        if (jobState== Trigger.TriggerState.NONE){
            return "关闭失败，任务未开启";
        }else if(jobState== Trigger.TriggerState.NORMAL){
            quartzScheduler.pauseJob("job1","group1");
            return "关闭成功";
        }else if(jobState== Trigger.TriggerState.PAUSED){
            return "任务已关闭";
        }
        return "错误";
    }
    @RequestMapping("/index")
    public ModelAndView queryInterface(HttpServletRequest request) throws Exception{
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("task/studentTask");
        return modelAndView;
    }
}

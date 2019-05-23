package com.zyou.ops.quartz.job;

import com.zyou.ops.entity.StudentTask;
import com.zyou.ops.service.StudentTaskService;
import com.zyou.ops.util.utils.ListUtils;
import com.zyou.ops.util.utils.ValidateUtil;
import com.zyou.ops.zybd.entity.biz.UserTask;
import com.zyou.ops.zybd.service.UserTaskService;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * @BelongsProject: springbootmybatisdemo
 * @BelongsPackage: com.yhr.springbootmybatisdemo.job
 * @Author: yang
 * @CreateTime: 2019-03-15 09:19
 * @Description: ${Description}
 */

@SuppressWarnings("all")
public class UserTaskJob implements Job {

    private void before() {
        System.out.println("任务开始执行");
    }

    private Logger logger = LoggerFactory.getLogger(UserTaskJob.class);

    @Autowired
    private StudentTaskService studentTaskService;
    @Autowired
    private UserTaskService userTaskService;

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {

        //job 中注入spring容器管理的bean
        SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);

        String printTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        logger.debug("现在的时间:" + printTime + "  开始定时任务:" + UserTaskJob.class.getName());
        List<StudentTask> smailList = new ListUtils<StudentTask>().getRandomList(studentTaskService.getStudentTaskListByClassType(1), 3);
        List<StudentTask> midList = new ListUtils<StudentTask>().getRandomList(studentTaskService.getStudentTaskListByClassType(2), 2);
        List<StudentTask> bigList = new ListUtils<StudentTask>().getRandomList(studentTaskService.getStudentTaskListByClassType(3), 2);
        smailList.forEach(studentTask -> userTaskService.insert(getUserTask(studentTask,1)));
        midList.forEach(studentTask -> userTaskService.insert(getUserTask(studentTask,2)));
        bigList.forEach(studentTask -> userTaskService.insert(getUserTask(studentTask,3)));

    }

    private void after() {
        System.out.println("任务执行完毕");
    }

    public static UserTask getUserTask(StudentTask studentTask, Integer classType) {
        if (ValidateUtil.isNotEmpty(studentTask)) {
            if (studentTask.getSt_type() == 1) {
                return new UserTask("生活习惯", studentTask.getSt_name(), studentTask.getSt_content(), classType);
            } else if (studentTask.getSt_type() == 2) {
                return new UserTask("学习习惯", studentTask.getSt_name(), studentTask.getSt_content(), classType);
            } else if (studentTask.getSt_type() == 3) {
                return new UserTask("行为习惯", studentTask.getSt_name(), studentTask.getSt_content(), classType);
            } else if (studentTask.getSt_type() == 4) {
                return new UserTask("其他", studentTask.getSt_name(), studentTask.getSt_content(), classType);
            }
        } else {
            return null;
        }
        return null;
    }
}

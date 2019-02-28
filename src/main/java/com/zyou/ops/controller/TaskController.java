package com.zyou.ops.controller;

import com.alibaba.fastjson.JSONObject;
import com.zyou.ops.entity.ServerIp;
import com.zyou.ops.entity.StatusMap;
import com.zyou.ops.entity.Task;
import com.zyou.ops.service.ServerIpService;
import com.zyou.ops.service.TaskService;
import com.zyou.ops.thread.DetectionTask;
import com.zyou.ops.thread.MyThreadFactory;
import com.zyou.ops.thread.ThreadUtil;
import com.zyou.ops.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @BelongsProject: opssys
 * @BelongsPackage: com.zyou.ops.controller
 * @Author: yang
 * @CreateTime: 2019-02-13 13:42
 * @Description: ${Description}
 */
@Controller
@RequestMapping("main")
public class TaskController {

    @Autowired
    private TaskService taskService;

    private Map<Integer, Boolean> statusMap = new StatusMap().getStatusMap();

    private MyThreadFactory taskThreadFactory=MyThreadFactory.getInstance();//检测任务线程工厂

    private Map<Integer,Long> taskThreadMap=taskThreadFactory.getThreadMap();//存放线程id的map



    @RequestMapping("/taskList")
    public ModelAndView queryTask(HttpServletRequest request) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("api/taskList");
        return modelAndView;
    }


    @RequestMapping("/getTaskList")
    @ResponseBody
    public Map<String,Object> getAllByBeginNumber(Integer pageSize, Integer pageNumber) {
        // 查看全部数据执行后端分页查询
        Map<String,Object> queryMap = new HashMap<>();
        if (pageNumber <= 1){
            pageNumber = 1;
        }
        int beginNumber = (pageNumber - 1)* pageSize;
        queryMap.put("beginNumber", beginNumber);
        queryMap.put("limit", pageSize);
        //数据库查询信息
        List<Task> taskList = taskService.getAllByPage(queryMap);
        int total=taskService.getCount();
        for (Task task : taskList) {
            task.setTsk_pm_json(task.getTsk_pm_json().replaceAll("\"", "&quot;"));
            task.setTsk_pm_result(task.getTsk_pm_result().replaceAll("\"", "&quot;"));
        }
        //内存中查询状态
        //false关闭 True开启
        if (statusMap.size() > 0) {
            for (int i = 0; i < taskList.size(); i++) {
                int tsk_id = taskList.get(i).getTsk_id();// 任务id
                if (statusMap.containsKey(tsk_id)) {
                    //如果map的key 在tsk_id 中
                    taskList.get(i).setStatus(statusMap.get(tsk_id));
                    //设置task状态为内存中的map的状态
                } else {
                    //如果map 里面没有对应ID的状态说明 关闭（false）
                    taskList.get(i).setStatus(false);
                }
            }
        } else {
            //如果没有任务， 内存中就没有
            //默认未开启 0
            for (int i = 0; i < taskList.size(); i++) {
                taskList.get(i).setStatus(false);
            }
        }
        Map<String,Object> responseMap = new HashMap<>();
        //key需要与js中 dataField对应，bootStrap默认值为rows
        responseMap.put("rows",taskList );
        // 需要返回到前台，用于计算分页导航栏
        responseMap.put("total", total);
        return responseMap;
    }


    @RequestMapping(value = "/saveTask", produces = "text/html;charset=UTF-8")
    public ResponseEntity<String> save(Model model, HttpServletRequest request, Task task) throws Exception {
        Long result = 0L;
        result = taskService.create(task);
        if (result == 1) {
            return new ResponseEntity<String>(Constants.SUBMIT_OK, HttpStatus.OK);
        } else {
            return new ResponseEntity<String>(Constants.SUBMIT_ERROR, HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "updateTask", produces = "text/html;charset=UTF-8")
    public ResponseEntity<String> update(Model model, HttpServletRequest request, Task task) throws Exception {
        Long result = 0L;
        result = taskService.update(task);
        if (result == 1) {
            return new ResponseEntity<String>(Constants.UPDATE_OK, HttpStatus.OK);
        } else {
            return new ResponseEntity<String>(Constants.UPDATE_ERROR, HttpStatus.BAD_REQUEST);
        }

    }

    @RequestMapping(value = "/deleteTask", produces = "text/html;charset=UTF-8")
    public ResponseEntity<String> deleteById(HttpServletRequest request) throws Exception {
        Long result = 0L;
        Integer tsk_id = Integer.valueOf(request.getParameter("tsk_id"));
        result = taskService.delete(tsk_id);
        if (result == 1) {
            return new ResponseEntity<String>(Constants.DELETE_OK, HttpStatus.OK);
        } else {
            return new ResponseEntity<String>(Constants.DELETE_ERROR, HttpStatus.BAD_REQUEST);
        }
    }


    //任务列表
    @RequestMapping(value="/task",produces = "text/html;charset=UTF-8")
    public ResponseEntity<String> task(HttpServletRequest request) throws Exception {
        Integer tsk_id = Integer.valueOf(request.getParameter("tsk_id"));
        String state = request.getParameter("state");
        Task task=new Task();
        task=taskService.searchById(tsk_id);


        //关闭线程
        if (state.equals("true")) {

            Long currentThreadId=taskThreadMap.get(tsk_id);
            Thread currentThread= ThreadUtil.findThread(currentThreadId);

            if (currentThread != null){
                currentThread.interrupt();
                statusMap.put(tsk_id,false);
            }

        }
        //启动线程
        else if(state.equals("false")) {
            Thread taskThread=taskThreadFactory.newThread(new DetectionTask(task,true));
            taskThread.start();
            taskThreadMap.put(tsk_id,taskThread.getId());
            statusMap.put(tsk_id, true);

        }else {
            return new ResponseEntity<String>(Constants.ERROR, HttpStatus.OK);
        }
        return new ResponseEntity<String>(Constants.SUCCESS, HttpStatus.OK);
    }
}

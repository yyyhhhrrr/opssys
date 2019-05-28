package com.zyou.ops.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zyou.ops.entity.*;
import com.zyou.ops.service.EmailService;
import com.zyou.ops.service.ServerIpService;
import com.zyou.ops.service.TaskService;

import com.zyou.ops.util.mail.SendMail;
import com.zyou.ops.util.thread.DetectionTask;
import com.zyou.ops.util.thread.MyThreadFactory;
import com.zyou.ops.util.thread.ThreadUtil;
import com.zyou.ops.util.tree.TreeNode;
import com.zyou.ops.util.utils.Constants;
import com.zyou.ops.util.utils.ValidateUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.poi.ss.formula.functions.T;
import org.apiguardian.api.API;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @BelongsProject: opssys
 * @BelongsPackage: controller
 * @Author: yang
 * @CreateTime: 2019-02-13 13:42
 * @Description: ${Description}
 */
@RestController
@RequestMapping("main")
@Api(value = "task",description = "检测任务")
public class TaskController {

    @Autowired
    private TaskService taskService;
    @Autowired
    private EmailService emailService;
    @Autowired
    private SendMail sendMail;
    @Autowired
    private ServerIpService serverIpService;


    private Map<Integer, Boolean> statusMap = new StatusMap().getStatusMap();

    private MyThreadFactory taskThreadFactory=MyThreadFactory.getInstance();//检测任务线程工厂

    private Map<Integer,Long> taskThreadMap=taskThreadFactory.getThreadMap();//存放线程id的map



    @RequestMapping("/taskList")
    public ModelAndView queryTask(HttpServletRequest request) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("api/taskList");
        return modelAndView;
    }


    @RequestMapping(value = "/getTaskList",method = RequestMethod.GET,produces = "application/json;charset=UTF-8")
    @ApiOperation(value="检测任务列表")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "query",name="pageNumber",value="页数",dataType = "int"),
            @ApiImplicitParam(paramType = "query",name="pageSize",value="页面大小",dataType = "int")})
    public Map<String,Object> getAllByBeginNumber(Integer pageSize, Integer pageNumber,String svIp,String svOs,String itPort,String itAddress,String tskDetail) throws Exception {
        // 查看全部数据执行后端分页查询
        Task mytask=new Task();
        ServerIp serverIp=new ServerIp();
        Interface anInterface=new Interface();
        if(ValidateUtil.isNotEmpty(svIp)){
            serverIp.setSv_ip(svIp);
        }
        if(ValidateUtil.isNotEmpty(svOs)){
            serverIp.setSv_os(svOs);
        }
        if(ValidateUtil.isNotEmpty(itPort)){
            anInterface.setIt_port(Integer.valueOf(itPort));
        }
        if(ValidateUtil.isNotEmpty(itAddress)){
           anInterface.setIt_address(itAddress);
        }
        if(ValidateUtil.isNotEmpty(tskDetail)){
            tskDetail=new String(tskDetail.getBytes("ISO8859-1"),"utf-8");
            mytask.setTsk_detail(tskDetail);
        }
        mytask.setServerIp(serverIp);
        mytask.setAnInterface(anInterface);
        PageHelper.startPage(pageNumber,pageSize);
        List<Task> taskList = taskService.searchAll(mytask);
        PageInfo<Task> p=new PageInfo<>(taskList);
        int total= (int) p.getTotal();
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

    @RequestMapping(value = "/updateTask", produces = "text/html;charset=UTF-8")
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
        List<Email> emailListByTask = emailService.getEmailListByTask(tsk_id);
        List<String> emailList=new ArrayList<>();
        for (Email email : emailListByTask) {
            emailList.add(email.getEmail_address());
        }

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
            Thread taskThread=taskThreadFactory.newThread(new DetectionTask(task,true,emailList,sendMail));
            taskThread.start();
            taskThreadMap.put(tsk_id,taskThread.getId());
            statusMap.put(tsk_id, true);

        }else {
            return new ResponseEntity<String>(Constants.ERROR, HttpStatus.OK);
        }
        return new ResponseEntity<String>(Constants.SUCCESS, HttpStatus.OK);
    }


    @RequestMapping(value = "/getTreeNode",method = RequestMethod.GET,produces = "application/json;charset=UTF-8")
    @ApiOperation("获取树节点")
    public String getTreeNode() throws Exception {
        List<TreeNode> nodeList=new ArrayList<>();
        ServerIp serverIp=new ServerIp();
        serverIp.setSv_detail("快乐唷唷");
        List<ServerIp> serverIpList = serverIpService.searchAll(serverIp);
        List<TreeNode> linuxTreeList=new ArrayList<>();
        for (ServerIp server : serverIpList) {
            TreeNode treeNode = new TreeNode(server.getSv_ip(), null);
            linuxTreeList.add(treeNode);
        }
        TreeNode linux =new TreeNode("快乐唷唷",linuxTreeList);
        ServerIp serverIp2=new ServerIp();
        serverIp2.setSv_detail("脑科学");
        List<ServerIp> serverIpList1 = serverIpService.searchAll(serverIp2);
        List<TreeNode> windowsTreeList=new ArrayList<>();
        for (ServerIp server : serverIpList1) {
            TreeNode treeNode = new TreeNode(server.getSv_ip(), null);
            windowsTreeList.add(treeNode);

        }
        TreeNode windows =new TreeNode("脑科学",windowsTreeList);
        nodeList.add(linux);
        nodeList.add(windows);
        TreeNode p1 =new TreeNode("服务器",nodeList);
        List<TreeNode> nodeListp=new ArrayList<>();
        nodeListp.add(p1);
        JSONArray jsonArray=JSONArray.parseArray(JSON.toJSONString(nodeListp));
        return jsonArray.toString();
    }
}

package com.zyou.ops.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zyou.ops.entity.Email;
import com.zyou.ops.entity.Interface;
import com.zyou.ops.entity.Task;
import com.zyou.ops.service.EmailService;
import com.zyou.ops.service.TaskService;
import com.zyou.ops.util.utils.Constants;
import com.zyou.ops.util.utils.ValidateUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Array;
import java.util.*;

/**
 * @BelongsProject: opssys
 * @BelongsPackage: com.zyou.ops.controller
 * @Author: yang
 * @CreateTime: 2019-05-10 17:26
 * @Description: ${Description}
 */

@RestController
@RequestMapping("/email")
@Api(value="email",description = "报警管理")
public class EmailController {

    @Autowired
    private EmailService emailService;
    @Autowired
    private TaskService taskService;

    @RequestMapping("/emailList")
    public ModelAndView queryInterface(HttpServletRequest request) throws Exception{
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("email/email");
        return modelAndView;
    }

    @RequestMapping(value="/saveEmail",produces = "text/html;charset=UTF-8")
    public ResponseEntity<String> save(Model model, HttpServletRequest request, Email email) throws Exception{
        Long result = 0L;
        result=emailService.create(email);
        if(result==1){
            return new ResponseEntity<String>(Constants.SUBMIT_OK, HttpStatus.OK);
        }else{
            return new ResponseEntity<String>(Constants.SUBMIT_ERROR,HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/getEmailList",method = RequestMethod.GET,produces = "application/json;charset=UTF-8")
    @ApiOperation(value="报警人列表")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "query",name="pageNumber",value="页数",dataType = "int"),
            @ApiImplicitParam(paramType = "query",name="pageSize",value="页面大小",dataType = "int")})
    public Map<String,Object> getAllByBeginNumber(Integer pageSize, Integer pageNumber,String emailUsername) throws Exception {
        Map<String, Object> responseMap = new HashMap<>();
        Email email=new Email();
        if(ValidateUtil.isNotEmpty(emailUsername)) {
            email.setEmail_username(emailUsername);
        }
        if(ValidateUtil.isAllEmpty(pageSize,pageNumber)){
            //不分页
            List<Email> serverIpList=new ArrayList<>();
            serverIpList=emailService.searchAll();
            responseMap.put("list",serverIpList);
        }
        else {
            // 查看全部数据执行后端分页查询
            PageHelper.startPage(pageNumber, pageSize);
            List<Email> emailList = emailService.searchAll(email);
            PageInfo<Email> p = new PageInfo<>(emailList);
            int total = (int) p.getTotal();
            //key需要与js中 dataField对应，bootStrap默认值为rows
            responseMap.put("rows", emailList);
            // 需要返回到前台，用于计算分页导航栏
            responseMap.put("total", total);
        }
        return responseMap;
    }

    @RequestMapping(value="/updateEmail",produces = "text/html;charset=UTF-8")
    public ResponseEntity<String> update(Model model, HttpServletRequest request, Email email) throws Exception{
        Long result=0L;
        result=emailService.update(email);
        if(result==1){
            return new ResponseEntity<String>(Constants.UPDATE_OK, HttpStatus.OK);
        }else{
            return new ResponseEntity<String>(Constants.UPDATE_ERROR,HttpStatus.BAD_REQUEST);
        }

    }

    @RequestMapping(value="/deleteTaskByEmail/{id}",method = RequestMethod.POST,produces = "text/html;charset=UTF-8")
    public ResponseEntity<String> deleteTaskByEmail(HttpServletRequest request,@PathVariable("id")Integer email_id) throws Exception{
        Long result=0L;
        Integer tsk_id=Integer.valueOf(request.getParameter("tsk_id"));
        Map<String,Integer> map=new HashMap<>();
        map.put("ref_email_id",email_id);
        map.put("ref_task_id",tsk_id);
        result=emailService.deleteTaskByEmail(map);
        if(result==1){
            return new ResponseEntity<String>(Constants.DELETE_OK,HttpStatus.OK);
        }else{
            return new ResponseEntity<String>(Constants.DELETE_ERROR,HttpStatus.BAD_REQUEST);
        }
    }


    @RequestMapping(value="/deleteEmail",produces = "text/html;charset=UTF-8")
    public ResponseEntity<String> deleteById(HttpServletRequest request) throws Exception{
        Long result=0L;
        Integer email_id=Integer.valueOf(request.getParameter("email_id"));
        result=emailService.delete(email_id);
        if(result==1){
            return new ResponseEntity<String>(Constants.DELETE_OK,HttpStatus.OK);
        }else{
            return new ResponseEntity<String>(Constants.DELETE_ERROR,HttpStatus.BAD_REQUEST);
        }
    }


    @RequestMapping(value="/getTaskListByEmail/{id}/{flag}",method = RequestMethod.GET,produces = "application/json;charset=UTF-8")
    @ApiOperation("根据id获取报警人检测任务列表")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path",name="id",value="报警人id",dataType = "int"),
            @ApiImplicitParam(paramType = "path",name="flag",value="是否查询已有任务",dataType = "boolean"),//flag=true 不查询
            @ApiImplicitParam(paramType = "query",name="pageNumber",value="页数",dataType = "int"),
            @ApiImplicitParam(paramType = "query",name="pageSize",value="页面大小",dataType = "int")})

    public Map<String,Object> getTaskListByEmail(@PathVariable("id") Integer email_id,
                                                 @PathVariable("flag") Boolean flag,
                                                 Integer pageNumber,
                                                 Integer pageSize) throws Exception {
        Map<String, Object> responseMap = new HashMap<>();
        // 查看全部数据执行后端分页查询
        PageHelper.startPage(pageNumber, pageSize);
        List<Task> taskList=null;
        if(ValidateUtil.isNotEmpty(flag)) {
            if (flag == true) {
                taskList = taskService.getTaskListNotInByEmail(email_id);
            } else {
                taskList = emailService.getTaskListByEmail(email_id).get(0).getTaskList();
            }
        }
        PageInfo<Task> p = new PageInfo<>(taskList);
        int total = (int) p.getTotal();
        //key需要与js中 dataField对应，bootStrap默认值为rows
        responseMap.put("rows", taskList);
        // 需要返回到前台，用于计算分页导航栏
        responseMap.put("total", total);

        return responseMap;
    }

    @RequestMapping(value = "/addTaskByEmail",method = RequestMethod.POST,produces = "text/html;charset=UTF-8")
    @ApiOperation("根据email_id 新增检测任务")
    public ResponseEntity<String> addTaskByEmail(
            //HttpServletRequest request,@PathVariable("id")Integer email_id
   @RequestBody List<String> list) {
        Long result=0L;
        try {
            for (String s : list) {
                Map map = JSONObject.parseObject(s);
                map.put("ref_email_id", ((JSONObject) map).getInteger("ref_email_id"));
                System.out.println(map);
                result = emailService.addTaskByEmail(map);
            }
        }catch (Exception e){
            return new ResponseEntity<String>(Constants.SUBMIT_ERROR,HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<String>(Constants.SUBMIT_OK,HttpStatus.OK);

    }


}

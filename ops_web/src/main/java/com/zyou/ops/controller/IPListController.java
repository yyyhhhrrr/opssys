package com.zyou.ops.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zyou.ops.entity.ServerIp;
import com.zyou.ops.service.ServerIpService;

import com.zyou.ops.util.utils.Constants;
import com.zyou.ops.util.utils.ValidateUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @BelongsProject: opssys
 * @BelongsPackage: controller
 * @Author: yang
 * @CreateTime: 2019-02-11 11:25
 * @Description: 服务器信息控制层
 */
@RestController
@RequestMapping("main")
@Api(value = "ip",description = "服务器")
public class IPListController {


    @Autowired
    ServerIpService serverIpService;

    @RequestMapping(value="/saveIP",method = RequestMethod.POST,produces = "text/html;charset=UTF-8")
    @ApiOperation(value="服务器列表")
    public ResponseEntity<String> save(Model model, HttpServletRequest request, ServerIp serverIp) throws Exception{
        Long result = 0L;
        result=serverIpService.create(serverIp);
        if(result==1){
            return new ResponseEntity<String>(Constants.SUBMIT_OK,HttpStatus.OK);
        }else{
            return new ResponseEntity<String>(Constants.SUBMIT_ERROR,HttpStatus.BAD_REQUEST);
        }
    }

    //页面
    @RequestMapping("/ipList")
    public ModelAndView queryServerIp(HttpServletRequest request) throws Exception{
       ModelAndView modelAndView=new ModelAndView();
       modelAndView.setViewName("api/ipList");
       return modelAndView;
    }


    //获得服务器列表
    @RequestMapping(value="/getIPList",method= RequestMethod.GET,produces = "application/json;charset=UTF-8")
    @ApiOperation(value="服务器列表")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "query",name="pageNumber",value="页数",dataType = "int"),
            @ApiImplicitParam(paramType = "query",name="pageSize",value="页面大小",dataType = "int")})
    public Map<String,Object> getAllByBeginNumber(Integer pageSize, Integer pageNumber) throws Exception {
        Map<String, Object> responseMap = new HashMap<>();
        if(ValidateUtil.isAllEmpty(pageSize,pageNumber)){
            //不分页
            List<ServerIp> serverIpList=new ArrayList<ServerIp>();
            serverIpList=serverIpService.searchAll();
            responseMap.put("list",serverIpList);
        }
        else {
            // 查看全部数据执行后端分页查询
            PageHelper.startPage(pageNumber, pageSize);
            List<ServerIp> ipList = serverIpService.searchAll();
            PageInfo<ServerIp> p = new PageInfo<>(ipList);
            int total = (int) p.getTotal();
            //key需要与js中 dataField对应，bootStrap默认值为rows
            responseMap.put("rows", ipList);
            // 需要返回到前台，用于计算分页导航栏
            responseMap.put("total", total);
            System.out.println(responseMap);
        }
        return responseMap;
    }

    @RequestMapping(value="updateIP",produces ="text/html;charset=UTF-8")
    public ResponseEntity<String> update(Model model, HttpServletRequest request, ServerIp serverIp) throws Exception{
        Long result=0L;
        result=serverIpService.update(serverIp);
        if(result==1){
            return new ResponseEntity<String>(Constants.UPDATE_OK, HttpStatus.OK);
        }else{
            return new ResponseEntity<String>(Constants.UPDATE_ERROR,HttpStatus.BAD_REQUEST);
        }

    }

    @RequestMapping(value="/deleteIP",produces = "text/html;charset=UTF-8")
    public ResponseEntity<String> deleteById(HttpServletRequest request) throws Exception{
        Long result=0L;
        Integer sv_id=Integer.valueOf(request.getParameter("sv_id"));
        result=serverIpService.delete(sv_id);
        if(result==1){
            return new ResponseEntity<String>(Constants.DELETE_OK,HttpStatus.OK);
        }else{
            return new ResponseEntity<String>(Constants.DELETE_ERROR,HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value="server/{id}",method = RequestMethod.GET,produces = "application/json;charset=UTF-8")
    @ApiOperation(value="根据id获取服务器")
    public ServerIp queryServerIPById(@PathVariable("id") String id) throws  Exception{
        Integer sv_id=Integer.valueOf(id);
        ServerIp serverIp=serverIpService.searchById(sv_id);
        return serverIp;
    }


}

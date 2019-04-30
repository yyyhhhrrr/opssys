package com.zyou.ops.controller;

import com.alibaba.fastjson.JSONObject;
import com.zyou.ops.entity.ServerIp;
import com.zyou.ops.service.ServerIpService;

import com.zyou.ops.util.utils.Constants;
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
 * @Description: ${Description}
 */
@Controller
@RequestMapping("main")
public class IPListController {


    @Autowired
    ServerIpService serverIpService;

    @RequestMapping(value="/saveIP",produces = "text/html;charset=UTF-8")
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


    //表格数据填充
    @RequestMapping("/getIPList")
    @ResponseBody
    public Map<String,Object> getAllByBeginNumber(Integer pageSize, Integer pageNumber){
        // 查看全部数据执行后端分页查询
        Map<String,Object> queryMap = new HashMap<>();
        if (pageNumber <= 1){
            pageNumber = 1;
        }
        int beginNumber = (pageNumber - 1)* pageSize;
        queryMap.put("beginNumber", beginNumber);
        queryMap.put("limit", pageSize);
        List<ServerIp> ipList = serverIpService.getAllByPage(queryMap);
        int total = serverIpService.getCount();
        Map<String,Object> responseMap = new HashMap<>();
        //key需要与js中 dataField对应，bootStrap默认值为rows
        responseMap.put("rows",ipList );
        // 需要返回到前台，用于计算分页导航栏
        responseMap.put("total", total);
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


    //服务器下拉菜单
    @RequestMapping(value="queryServer",produces ="application/json;charset=UTF-8" )
    public @ResponseBody
    ArrayList<ServerIp> queryServerPOST(HttpServletRequest request, HttpServletResponse response) throws Exception{

        ArrayList<ServerIp> serverIpList=new ArrayList<ServerIp>();
        serverIpList.addAll(serverIpService.searchAll());

        return serverIpList;
    }


    //修改服务器下拉菜单
    @RequestMapping(value="queryServerExcept",produces ="application/json;charset=UTF-8" )
    public @ResponseBody
    ArrayList<ServerIp> queryServerExcpetPOST(@RequestBody JSONObject data) throws Exception{

        ArrayList<ServerIp> serverIpExcpetList=new ArrayList<ServerIp>();
        Integer sv_id=Integer.valueOf(data.getString("sv_id"));
//        Integer sv_id=Integer.valueOf(request.getParameter("sv_id"));
//
        serverIpExcpetList.addAll(serverIpService.selcetServerExcpet(sv_id));

//        serverIpExcpetList=(ArrayList<ServerIp>) serverIpService.selcetServerExcpet(sv_id);


        return serverIpExcpetList;
    }


    @RequestMapping(value="queryServerIPById")
    public @ResponseBody
    ServerIp queryServerIPById(HttpServletRequest request) throws  Exception{
        Integer sv_id=Integer.valueOf(request.getParameter("sv_id"));
        ServerIp serverIp=serverIpService.searchById(sv_id);
        return serverIp;
    }


}

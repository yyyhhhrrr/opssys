package com.zyou.ops.controller;


import com.alibaba.fastjson.JSONObject;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zyou.ops.entity.Interface;
import com.zyou.ops.service.InterfaceService;
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
import java.util.*;

/**
 * @BelongsProject: opssys
 * @BelongsPackage: controller
 * @Author: yang
 * @CreateTime: 2019-02-11 13:09
 * @Description: ${Description}
 */

@RestController
@RequestMapping("main")
@Api(value = "interface",description = "接口")
public class InterfaceController {

    @Autowired
    private InterfaceService interfaceService;

    @RequestMapping(value="/saveInterface",produces = "text/html;charset=UTF-8")
    public ResponseEntity<String> save(Model model, HttpServletRequest request, Interface itc) throws Exception{
        Long result = 0L;
        result=interfaceService.create(itc);
        if(result==1){
            return new ResponseEntity<String>(Constants.SUBMIT_OK, HttpStatus.OK);
        }else{
            return new ResponseEntity<String>(Constants.SUBMIT_ERROR,HttpStatus.BAD_REQUEST);
        }
    }



    @RequestMapping("/interfaceList")
    public ModelAndView queryInterface(HttpServletRequest request) throws Exception{
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("api/interfaceList");
        return modelAndView;
    }



  //获得接口列表
    @RequestMapping(value = "/getInterfaceList",method=RequestMethod.GET,produces = "application/json;charset=UTF-8")
    @ApiOperation(value="接口列表")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "query",name="pageNumber",value="页数",dataType = "int"),
            @ApiImplicitParam(paramType = "query",name="pageSize",value="页面大小",dataType = "int")})
    public Map<String,Object> getAllByBeginNumber(Integer pageSize, Integer pageNumber,String itPort,String itAddress,String itDetail) throws Exception {
        Map<String, Object> responseMap = new HashMap<>();
        Interface anInterface=new Interface();
        if(ValidateUtil.isNotEmpty(itPort)){
            anInterface.setIt_port(Integer.valueOf(itPort));
        }
        if(ValidateUtil.isNotEmpty(itAddress)){
            anInterface.setIt_address(itAddress);
        }
        if(ValidateUtil.isNotEmpty(itDetail)){
            itDetail=new String(itDetail.getBytes("ISO8859-1"),"utf-8");
            anInterface.setIt_detail(itDetail);
        }

        if(ValidateUtil.isAllEmpty(pageSize,pageNumber)){
            //不分页
            List<Interface> serverIpList=new ArrayList<Interface>();
            serverIpList=interfaceService.searchAll();
            responseMap.put("list",serverIpList);
        }
        else {
            // 查看全部数据执行后端分页查询
            PageHelper.startPage(pageNumber, pageSize);
            List<Interface> interfaceList = interfaceService.searchAll(anInterface);
            PageInfo<Interface> p = new PageInfo<>(interfaceList);
            int total = (int) p.getTotal();
            //key需要与js中 dataField对应，bootStrap默认值为rows
            responseMap.put("rows", interfaceList);
            // 需要返回到前台，用于计算分页导航栏
            responseMap.put("total", total);
            System.out.println(responseMap);
        }
        return responseMap;
    }


    @RequestMapping(value="/updateInterface",produces = "text/html;charset=UTF-8")
    public ResponseEntity<String> update(Model model, HttpServletRequest request, Interface itc) throws Exception{
        Long result=0L;
        result=interfaceService.update(itc);
        if(result==1){
            return new ResponseEntity<String>(Constants.UPDATE_OK, HttpStatus.OK);
        }else{
            return new ResponseEntity<String>(Constants.UPDATE_ERROR,HttpStatus.BAD_REQUEST);
        }

    }

    @RequestMapping(value="/deleteInterface",produces = "text/html;charset=UTF-8")
    public ResponseEntity<String> deleteById(HttpServletRequest request) throws Exception{
        Long result=0L;
        Integer it_id=Integer.valueOf(request.getParameter("it_id"));
        result=interfaceService.delete(it_id);
        if(result==1){
            return new ResponseEntity<String>(Constants.DELETE_OK,HttpStatus.OK);
        }else{
            return new ResponseEntity<String>(Constants.DELETE_ERROR,HttpStatus.BAD_REQUEST);
        }
    }



    @RequestMapping(value="interface/{id}",method = RequestMethod.GET,produces = "application/json;charset=UTF-8")
    @ApiOperation(value="根据id获取接口")
    public Interface queryInterfaceById(@PathVariable("id")String id) throws Exception{
        Integer it_id=Integer.valueOf(id);
        Interface itc=interfaceService.searchById(it_id);
        return itc;
    }


}

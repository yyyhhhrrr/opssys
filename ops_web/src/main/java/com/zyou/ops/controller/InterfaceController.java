package com.zyou.ops.controller;


import com.alibaba.fastjson.JSONObject;


import com.zyou.ops.entity.Interface;
import com.zyou.ops.service.InterfaceService;
import com.zyou.ops.util.utils.Constants;
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

@Controller
@RequestMapping("main")
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



  //表格数据填充
    @RequestMapping("/getInterfaceList")
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
        List<Interface> interfaceList = interfaceService.getAllByPage(queryMap);
        int total = interfaceService.getCount();
        Map<String,Object> responseMap = new HashMap<>();
        //key需要与js中 dataField对应，bootStrap默认值为rows
        responseMap.put("rows", interfaceList);
        // 需要返回到前台，用于计算分页导航栏
        responseMap.put("total", total);
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

    //接口地址下拉菜单
    @RequestMapping(value="queryInterface",produces ="application/json;charset=UTF-8" )
    public @ResponseBody
    ArrayList<Interface> queryServerPOST(HttpServletRequest request, HttpServletResponse response) throws Exception{

        ArrayList<Interface> interfaceList=new ArrayList<Interface>();
        interfaceList.addAll(interfaceService.searchAll());

        return interfaceList;
    }

    //修改接口地址下拉菜单
    @RequestMapping(value="queryInterfaceExcept",produces ="application/json;charset=UTF-8" )
    public @ResponseBody
    ArrayList<Interface> queryServerExceptPOST(@RequestBody JSONObject data) throws Exception{

        ArrayList<Interface> interfaceExceptList=new ArrayList<Interface>();
        Integer it_id=Integer.valueOf(data.getString("it_id"));
        interfaceExceptList.addAll(interfaceService.selectInterfaceExcpet(it_id));
        return interfaceExceptList;
    }

    @RequestMapping("queryInterfaceById")
    public @ResponseBody
    Interface queryInterfaceById(HttpServletRequest request) throws Exception{
        Integer it_id=Integer.valueOf(request.getParameter("it_id"));
        Interface itc=interfaceService.searchById(it_id);
        return itc;
    }


}

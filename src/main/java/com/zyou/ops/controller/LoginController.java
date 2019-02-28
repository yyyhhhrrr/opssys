package com.zyou.ops.controller;

import com.alibaba.fastjson.JSONObject;
import com.zyou.ops.entity.User;
import com.zyou.ops.service.UserService;
import com.zyou.ops.util.RequestUtils;
import com.zyou.ops.util.ResponseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @BelongsProject: opssys
 * @BelongsPackage: com.zyou.ops.controller
 * @Author: yang
 * @CreateTime: 2019-02-01 15:23
 * @Description: ${Description}
 */
@Controller
public class LoginController {
    @Autowired
    private UserService userService;

    @RequestMapping("/successLogin")
    public ModelAndView login(HttpServletRequest request, ModelAndView model){

        String username= RequestUtils.getString(request,"username");
        String pwd=RequestUtils.getString(request,"pwd");
        User user=new User();
        user.setUs_username(username);
        user.setUs_username(pwd);
        model.addObject("user",user);
        model.setViewName("api/index");
        return model;
    }

    @RequestMapping("/validateLogin")
    public void login(HttpServletRequest request, HttpServletResponse response){

        //获取form表单数据
        String loginObj=RequestUtils.getString(request,"loginObj");
        //Json字符串序列化成json对象
        JSONObject loginJson=JSONObject.parseObject(loginObj);
        String username=loginJson.getString("username");
        String pwd=loginJson.getString("pwd");
        //根据账号查询用户名是否存在
        User user=userService.selectByUsername(username);
        JSONObject result=new JSONObject();

        if(user == null){
            result.put("accountMsg","用户名不存在");
        }
        else if (!pwd.equals(user.getUs_password())){
            result.put("pwdMsg","用户名密码错误");
        }else{
            result.put("user",user);
        }
        String resultStr=result.toJSONString();
        ResponseUtils.send(response,resultStr);
    }


    @RequestMapping("/Login")
    public String login() throws Exception{
        return "login";


    }
}

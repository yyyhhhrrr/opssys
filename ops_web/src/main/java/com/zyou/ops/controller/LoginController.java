package com.zyou.ops.controller;

import com.alibaba.fastjson.JSONObject;
import com.zyou.ops.entity.User;
import com.zyou.ops.service.UserService;

import com.zyou.ops.util.utils.RequestUtils;
import com.zyou.ops.util.utils.ResponseUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @BelongsProject: opssys
 * @BelongsPackage: controller
 * @Author: yang
 * @CreateTime: 2019-02-01 15:23
 * @Description: ${Description}
 */
@Controller
@Api(value="login",description = "登录")
public class LoginController {


    //页面
    @RequestMapping("/index")
    public ModelAndView index(HttpServletRequest request) throws Exception{
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("index");
        return modelAndView;
    }



    @RequestMapping(value = "/validateLogin",produces = "application/json;charset=UTF-8")
    @ResponseBody
    @ApiOperation("登录验证")
    @ApiImplicitParams(
                   {@ApiImplicitParam(paramType = "query",name="username",value="用户名",dataType = "String"),
                    @ApiImplicitParam(paramType = "query",name="pwd",value="密码",dataType = "String")})
    public String login(String username,String pwd,HttpSession session, HttpServletResponse response,boolean rememberMe){
        JSONObject result = new JSONObject();
        if(username==""||username==null){
            result.put("accountMsg", "账号不能为空");
            return result.toJSONString();
        }
        //主体,当前状态为没有认证的状态“未认证”
        Subject subject = SecurityUtils.getSubject();
        // 登录后存放进shiro token
        UsernamePasswordToken token = new UsernamePasswordToken(username, pwd,rememberMe);
        User user;
        //根据账号查询用户名是否存在
        try {
            subject.login(token);//login 调用 securityManager 传入参数token ,securityManager调用 认证方法 Authenticationinfo进行认证 传入参数token
            user = (User) subject.getPrincipal();
            session.setAttribute("user", subject);
            result.put("user",user);
        }catch (Exception e){
            result.put("pwdMsg","用户名密码错误");
        }
        return result.toJSONString();
    }





//    @RequestMapping(value = "/login")
//    public String Login(String username, String password, HttpSession session, Model model){
//        if(username==null){
//            model.addAttribute("message", "账号不为空");
//            return "login";
//        }
//
//
//        //主体,当前状态为没有认证的状态“未认证”
//        Subject subject = SecurityUtils.getSubject();
//        // 登录后存放进shiro token
//        UsernamePasswordToken token=new UsernamePasswordToken(username,password);
//        User user;
//        //登录方法（认证是否通过）
//        //使用subject调用securityManager,安全管理器调用Realm
//        try {
//            //利用异常操作
//            //需要开始调用到Realm中
//            System.out.println("========================================");
//            System.out.println("1、进入认证方法");
//            subject.login(token);//login 调用 securityManager 传入参数token ,securityManager调用 认证方法 Authenticationinfo进行认证 传入参数token
//            user = (User)subject.getPrincipal();
//            session.setAttribute("user",subject);
//            model.addAttribute("message", "登录完成");
//            System.out.println("登录完成");
//        } catch (UnknownAccountException e) {
//            model.addAttribute("message", "账号密码不正确");
//            return "login";
//        }
//
//
//        return "index";
//    }



    @RequestMapping("/Login")
    public String login() throws Exception{
        return "login";
    }

    @RequestMapping("/regist")
    public String regist() throws Exception{
        return "regist";
    }

    @RequestMapping("/dashboard")
    public String dashboard() throws Exception{
        return "dashboard";
    }
}

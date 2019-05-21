package com.zyou.ops.shiro;



import com.zyou.ops.entity.Permission;
import com.zyou.ops.entity.User;
import com.zyou.ops.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


/**
 * 自定义realm
 */
public class MyShiroRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection pc) {

        /**
         *
         * 流程
         * 1.根据用户user->2.获取角色id->3.根据角色id获取权限permission
         */
        //方法一：获得user对象
        User user=(User)pc.getPrimaryPrincipal();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        //获取permission
        if(user!=null) {
            List<Permission> permissionsByUser = userService.getPermissionsByUser(user);
            if (permissionsByUser.size()!=0) {
                for (Permission p: permissionsByUser) {
                    info.addStringPermission(p.getUrl());
                }
                return info;
            }
        }



        //方法二： 从subject管理器里获取user
//      Subject subject = SecurityUtils.getSubject();
//      User _user = (User) subject.getPrincipal();
//      System.out.println("subject"+_user.getUsername());




        return null;
    }

    // 认证方法
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //验证账号密码
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        System.out.println(token.getUsername());
        User user = userService.getUserByUserName(token.getUsername());
        if(user==null){
            return null;
        }
        //最后的比对需要交给安全管理器
        //三个参数进行初步的简单认证信息对象的包装
        AuthenticationInfo info = new SimpleAuthenticationInfo(user, user.getUs_password(), this.getClass().getSimpleName());
        return info;
    }



}

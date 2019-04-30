package com.zyou.ops.aspect;

import com.zyou.ops.util.datasource.AspectUtil;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @BelongsProject: opssys
 * @BelongsPackage: com.zyou.ops.aspect
 * @Author: yang
 * @CreateTime: 2019-04-18 17:04
 * @Description: ${Description}
 */

@Component
@Aspect
@Order(0)
public class BaseAspect {
    @Autowired
    private AspectUtil aspectUtil;

    @Pointcut("execution(* com.zyou.ops.util.base.baseImpl.BaseServiceImpl.*(..))")
    public void point(){

    }
    @AfterReturning(value = "point()", returning = "result")
    public void after(JoinPoint joinPoint,Object result){
        aspectUtil.afterReturning(joinPoint,result);
    }

    @Before(value = "point()")
    public void before(JoinPoint point) throws Exception {
        aspectUtil.intercept(point);
    }



}

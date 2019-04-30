package com.zyou.ops.aspect;


import com.zyou.ops.util.datasource.AspectUtil;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @BelongsProject: opssys
 * @BelongsPackage: com.zyou.ops.util.datasource
 * @Author: yang
 * @CreateTime: 2019-04-17 16:35
 * @Description: DataSource注解切面
 */



@Component("opsAspect")
@Aspect
@Order(1)
public class OpsDataSourceAspect  {

    @Autowired
    private AspectUtil aspectUtil;

    /**
     * 拦截目标方法，获取由@DataSource指定的数据源标识，设置到线程存储中以便切换数据源
     *
     * @param
     * @throws Exception
     */

    @Pointcut("execution(* com.zyou.ops.service.*.*(..))")
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


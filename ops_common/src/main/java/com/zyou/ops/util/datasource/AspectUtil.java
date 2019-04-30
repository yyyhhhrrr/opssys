package com.zyou.ops.util.datasource;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * @BelongsProject: opssys
 * @BelongsPackage: com.zyou.ops.aspect
 * @Author: yang
 * @CreateTime: 2019-04-18 17:29
 * @Description: 统一处理切面 之前切换数据源和之后关闭数据源的通用类
 */
@Component
public class AspectUtil {

    private Logger log= LoggerFactory.getLogger(AspectUtil.class);


    /**
     * 拦截目标方法，获取由@DataSource指定的数据源标识，设置到线程存储中以便切换数据源
     *
     * @param
     * @throws Exception
     */
    public void intercept(JoinPoint point) throws Exception {
        Class<?> target = point.getTarget().getClass();
        MethodSignature signature = (MethodSignature) point.getSignature();
        // 默认使用目标类型的注解，如果没有则使用其实现接口的注解
        for (Class<?> clazz : target.getInterfaces()) {
            resolveDataSource(clazz, signature.getMethod());
        }
        resolveDataSource(target, signature.getMethod());
    }

    /**
     * 提取目标对象方法注解和类型注解中的数据源标识
     *
     * @param clazz
     * @param method
     */
    private void resolveDataSource(Class<?> clazz, Method method) {
        try {
            Class<?>[] types = method.getParameterTypes();
            // 默认使用类型注解
            if (clazz.isAnnotationPresent((Class<? extends Annotation>) DataSource.class)) {
                DataSource source = clazz.getAnnotation(DataSource.class);
                DynamicDataSourceHolder.setDataSource(source.value());
                log.debug("当前数据源:{}",source.value());
            }
            // 方法注解可以覆盖类型注解
            Method m = clazz.getMethod(method.getName(), types);
            if (m != null && m.isAnnotationPresent(DataSource.class)) {
                DataSource source = m.getAnnotation(DataSource.class);
                DynamicDataSourceHolder.setDataSource(source.value());
                log.debug("当前数据源:{}",source.value());
            }

        } catch (Exception e) {
            log.error(clazz + ":" + e.getMessage());
        }
    }


    public void afterReturning(JoinPoint joinPoint,Object result){
        DynamicDataSourceHolder.clearDataSource();
    }
}

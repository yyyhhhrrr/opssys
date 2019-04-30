package com.zyou.ops.util.datasource;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @BelongsProject: opssys
 * @BelongsPackage: com.zyou.ops.util.datasource
 * @Author: yang
 * @CreateTime: 2019-04-17 16:34
 * @Description: 自定义注解 切换数据源
 */

@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface DataSource {
    String value();


}

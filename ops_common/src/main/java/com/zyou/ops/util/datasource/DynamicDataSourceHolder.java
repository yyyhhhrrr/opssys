package com.zyou.ops.util.datasource;

/**
 * @BelongsProject: opssys
 * @BelongsPackage: com.zyou.ops.util.datasource
 * @Author: yang
 * @CreateTime: 2019-04-17 16:23
 * @Description: 创建DynamicDataSourceHolder用于持有当前线程中使用的数据源
 */
public class DynamicDataSourceHolder {

    private static final ThreadLocal<String> THREAD_DATA_SOURCE = new ThreadLocal<String>();

    public static String getDataSource() {
        return THREAD_DATA_SOURCE.get();
    }

    public static void setDataSource(String dataSource) {
        THREAD_DATA_SOURCE.set(dataSource);
    }

    public static void clearDataSource() {
        THREAD_DATA_SOURCE.remove();
    }


}

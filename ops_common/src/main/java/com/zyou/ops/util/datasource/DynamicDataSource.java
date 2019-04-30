package com.zyou.ops.util.datasource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @BelongsProject: opssys
 * @BelongsPackage: com.zyou.ops.util.datasource
 * @Author: yang
 * @CreateTime: 2019-04-17 16:22
 * @Description: ${Description}
 */
public class DynamicDataSource extends AbstractRoutingDataSource {
    @Override
    protected Object determineCurrentLookupKey() {
        return DynamicDataSourceHolder.getDataSource();
    }
}

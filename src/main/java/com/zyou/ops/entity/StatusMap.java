package com.zyou.ops.entity;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.HashMap;
import java.util.Map;

/**
 * @BelongsProject: opssys
 * @BelongsPackage: com.zyou.ops.entity
 * @Author: yang
 * @CreateTime: 2019-02-18 14:43
 * @Description: ${Description}
 */

/**
 * 存储内存中的任务map对象
 */
public class StatusMap {
    public  Map<Integer, Boolean> statusMap;

    public Map<Integer, Boolean> getStatusMap() {
        return statusMap;
    }

    public void setStatusMap(Map<Integer, Boolean> statusMap) {
        this.statusMap = statusMap;
    }

    public  StatusMap(){
      statusMap = new HashMap<>();
    }



}

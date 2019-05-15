package com.zyou.ops.zybd.entity.sys;

import java.io.Serializable;

/**
 * @BelongsProject: opssys
 * @BelongsPackage: com.zyou.ops.zybd.entity.sys
 * @Author: yang
 * @CreateTime: 2019-05-09 14:44
 * @Description: ${Description}
 */
public class Province implements Serializable {

    private Integer province_id;
    private String name;

    public Integer getProvinceId() {
        return province_id;
    }

    public void setProvinceId(Integer province_id) {
        this.province_id = province_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

package com.zyou.ops.zybd.service;

import com.zyou.ops.util.base.BaseService;
import com.zyou.ops.zybd.entity.bizbase.Company;
import com.zyou.ops.zybd.entity.sys.Province;

import java.util.List;
import java.util.Map;

/**
 * @BelongsProject: opssys
 * @BelongsPackage: com.zyou.ops.zybd.service
 * @Author: yang
 * @CreateTime: 2019-04-17 17:14
 * @Description: ${Description}
 */
public interface CompanyService extends BaseService<Company,Integer> {
    List<Province> selectProvince();
}

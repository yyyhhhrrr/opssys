package com.zyou.ops.zybd.service.impl;

import com.zyou.ops.util.base.BaseMapper;
import com.zyou.ops.util.base.baseImpl.BaseServiceImpl;

import com.zyou.ops.util.datasource.DataSource;
import com.zyou.ops.zybd.entity.bizbase.Company;
import com.zyou.ops.zybd.entity.sys.Province;
import com.zyou.ops.zybd.mapper.bizbase.CompanyMapper;
import com.zyou.ops.zybd.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @BelongsProject: opssys
 * @BelongsPackage: com.zyou.ops.zybd.service
 * @Author: yang
 * @CreateTime: 2019-04-17 17:06
 * @Description: ${Description}
 */

@Service
@DataSource("zybdDataSource")
public class CompanyServiceImpl extends BaseServiceImpl<Company,Integer> implements CompanyService {

    @Autowired
    private CompanyMapper companyMapper;

    @Override
    public BaseMapper<Company, Integer> getBaseMapper() {
        return companyMapper;
    }

    @Override
    public List<Province> selectProvince() {
        return companyMapper.selectProvince();
    }
}

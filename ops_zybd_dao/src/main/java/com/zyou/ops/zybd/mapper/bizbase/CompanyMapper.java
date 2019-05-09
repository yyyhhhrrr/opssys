package com.zyou.ops.zybd.mapper.bizbase;

import com.zyou.ops.util.base.BaseMapper;
import com.zyou.ops.zybd.entity.bizbase.Company;
import com.zyou.ops.zybd.entity.sys.Province;

import java.util.List;
import java.util.Map;

public interface CompanyMapper extends BaseMapper<Company,Integer> {
    int deleteByPrimaryKey(Long bcId);

    Long insert(Company record);

    int insertSelective(Company record);

    Company selectByPrimaryKey(Long bcId);

    int updateByPrimaryKeySelective(Company record);

    int updateByPrimaryKey(Company record);

    List<Province> selectProvince();

}
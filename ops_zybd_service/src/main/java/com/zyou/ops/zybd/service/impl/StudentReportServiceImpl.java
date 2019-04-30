package com.zyou.ops.zybd.service.impl;

import com.zyou.ops.util.base.BaseMapper;
import com.zyou.ops.util.base.baseImpl.BaseServiceImpl;
import com.zyou.ops.util.datasource.DataSource;
import com.zyou.ops.zybd.entity.biz.StudentReport;
import com.zyou.ops.zybd.mapper.biz.StudentReportMapper;
import com.zyou.ops.zybd.service.StudentReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @BelongsProject: opssys
 * @BelongsPackage: com.zyou.ops.zybd.service.impl
 * @Author: yang
 * @CreateTime: 2019-04-29 15:28
 * @Description: ${Description}
 */

@Service
@DataSource("zybdDataSource")
public class StudentReportServiceImpl extends BaseServiceImpl<StudentReport,Integer> implements StudentReportService {


    @Autowired
    private StudentReportMapper studentReportMapper;

    @Override
    public BaseMapper<StudentReport, Integer> getBaseMapper() {
        return studentReportMapper;
    }

    @Override
    public List<Map> selectReturnVisitReport(String startDate, String endDate) {
        return studentReportMapper.selectReturnVisitReport(startDate,endDate);
    }
}

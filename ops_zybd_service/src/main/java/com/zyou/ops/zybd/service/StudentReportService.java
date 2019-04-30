package com.zyou.ops.zybd.service;

import com.zyou.ops.util.base.BaseService;
import com.zyou.ops.zybd.entity.biz.StudentReport;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @BelongsProject: opssys
 * @BelongsPackage: com.zyou.ops.zybd.service
 * @Author: yang
 * @CreateTime: 2019-04-29 15:27
 * @Description: ${Description}
 */
public interface StudentReportService extends BaseService<StudentReport,Integer> {

    //回访园所打卡数据
    List<Map> selectReturnVisitReport(String startDate,String endDate);
}

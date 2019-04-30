package com.zyou.ops.zybd.service;

import com.zyou.ops.util.base.BaseService;
import com.zyou.ops.zybd.entity.biz.CardRecord;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @BelongsProject: opssys
 * @BelongsPackage: com.zyou.ops.zybd.service
 * @Author: yang
 * @CreateTime: 2019-04-19 14:30
 * @Description: ${Description}
 */
public interface CardRecordService extends BaseService<CardRecord,Integer> {
    List<Map> selectStudentReport(Integer companyId,String startDate,String endDate);
    List<Map> selectSelfSupportReport(String startDate, String endDate);
}

package com.zyou.ops.zybd.service.impl;

import com.zyou.ops.util.base.BaseMapper;
import com.zyou.ops.util.base.baseImpl.BaseServiceImpl;
import com.zyou.ops.util.datasource.DataSource;
import com.zyou.ops.zybd.entity.biz.CardRecord;
import com.zyou.ops.zybd.mapper.biz.CardRecordMapper;
import com.zyou.ops.zybd.service.CardRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @BelongsProject: opssys
 * @BelongsPackage: com.zyou.ops.zybd.service
 * @Author: yang
 * @CreateTime: 2019-04-19 14:31
 * @Description: ${Description}
 */
@Service
@DataSource("zybdDataSource")
public class CardRecordServiceImpl extends BaseServiceImpl<CardRecord,Integer> implements CardRecordService {

    @Autowired
    private CardRecordMapper cardRecordMapper;

    @Override
    public BaseMapper<CardRecord, Integer> getBaseMapper() {
        return cardRecordMapper;
    }

    @Override
    public List<Map> selectStudentReport(Integer companyId, String startDate, String endDate) {
        return cardRecordMapper.selectStudentReport(companyId,startDate,endDate);
    }

    @Override
    public List<Map> selectSelfSupportReport(String startDate, String endDate) {
        return cardRecordMapper.selectSelfSupportReport(startDate,endDate);
    }


}

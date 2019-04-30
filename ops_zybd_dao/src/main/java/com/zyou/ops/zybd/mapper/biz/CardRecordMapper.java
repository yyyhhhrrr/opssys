package com.zyou.ops.zybd.mapper.biz;

import com.zyou.ops.util.base.BaseMapper;
import com.zyou.ops.zybd.entity.biz.CardRecord;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface CardRecordMapper extends BaseMapper<CardRecord,Integer> {
    int deleteByPrimaryKey(Long bcId);

    Long insert(CardRecord record);

    int insertSelective(CardRecord record);

    CardRecord selectByPrimaryKey(Long bcId);

    int updateByPrimaryKeySelective(CardRecord record);

    int updateByPrimaryKey(CardRecord record);

    //省打卡
    List<Map> selectStudentReport(@Param("companyId")Integer companyId,@Param("startDate")String startDate,@Param("endDate")String endDate);

    //自营园打卡
    List<Map> selectSelfSupportReport(@Param("startDate")String startDate,@Param("endDate")String endDate);
}
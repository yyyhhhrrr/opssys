package com.zyou.ops.controller;

import com.zyou.ops.util.poiTemplate.ProvinceExportExcel;
import com.zyou.ops.util.poiTemplate.ReturnVisitExportExcel;
import com.zyou.ops.util.poiTemplate.SelfSupportExportExcel;
import com.zyou.ops.zybd.entity.sys.Province;
import com.zyou.ops.zybd.service.CardRecordService;
import com.zyou.ops.zybd.service.CompanyService;
import com.zyou.ops.zybd.service.StudentReportService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @BelongsProject: opssys
 * @BelongsPackage: com.zyou.ops.controller
 * @Author: yang
 * @CreateTime: 2019-04-23 17:49
 * @Description: 数据导入控制层
 */
@RestController
@RequestMapping("/export")
@Api(value="export",description = "数据导出")
public class ExportController {

    @Autowired
    private CardRecordService cardRecordService;
    @Autowired
    private StudentReportService studentReportService;
    @Autowired
    private CompanyService companyService;

    private SimpleDateFormat simpleDateFormat=new SimpleDateFormat("MM月dd日");
    private String format = simpleDateFormat.format(new Date());
    private SimpleDateFormat simpleDateFormat2=new SimpleDateFormat("yyyy-MM-dd");

//    String startDate="2019-04-17";
//    String s=startDate+" 00:00:00";
//    String e=startDate+" 23:59:59";


    /**
     * 省份打卡
     * @param response
     * @param province_id
     * @param province_name
     * @param date
     * @return
     * @throws DataAccessException
     * @throws UnsupportedEncodingException
     * @throws ParseException
     */
    @RequestMapping(value = "/province",method = RequestMethod.GET,produces = "applcation/json;charset=UTF-8")
    @ApiOperation("省份成长报告导出")
    @ApiImplicitParams(
           {@ApiImplicitParam(paramType = "query",name="province_id",value="省份id",dataType = "int"),
            @ApiImplicitParam(paramType = "query",name="province_name",value="省份名称",dataType = "String"),
            @ApiImplicitParam(paramType = "query",name="date",value="时间",dataType = "String")})
    public  String export(HttpServletResponse response,
                          Integer province_id,
                          String province_name,
                          String date) throws DataAccessException, UnsupportedEncodingException, ParseException {
        response.setContentType("application/x-download;charset=UTF-8");
//        Integer province_id=Integer.valueOf(request.getParameter("province_id"));
        province_name=new String(province_name.getBytes("ISO8859-1"),"utf-8");
        date=new String(date.getBytes("ISO8859-1"),"utf-8");
        Date mydate=simpleDateFormat2.parse(date);
        String date_format=simpleDateFormat.format(mydate);
        String date_format2=simpleDateFormat2.format(mydate);
        String sd=date_format2+" 00:00:00";
        String ed=date_format2+" 23:59:59";
        try {
            ServletOutputStream out = response.getOutputStream();
            try{
                response.setHeader("Content-Disposition","attachment;fileName="+ URLEncoder.encode(province_name+"幼儿园"+date_format+"打卡数据.xls","UTF-8"));
            }catch (UnsupportedEncodingException e1){
                e1.printStackTrace();
            }
            ProvinceExportExcel.export(province_name,cardRecordService.selectStudentReport(province_id,sd,ed),out,date_format);
            return "success";
        }catch (Exception e){
            e.printStackTrace();
            return "导出信息失败";
        }
    }

    @RequestMapping("/index")
    public ModelAndView index(HttpServletRequest request) throws Exception{
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("export/export");
        return modelAndView;
    }


    /**
     * 自营园打卡
     * @param response
     * @param company_name
     * @param date
     * @return
     * @throws DataAccessException
     * @throws UnsupportedEncodingException
     * @throws ParseException
     */
    @RequestMapping(value = "/selfExport",method = RequestMethod.GET,produces = "application/json;charset=UTF-8")
    @ApiOperation("自营园成长报告导出")
    @ApiImplicitParams(
           {@ApiImplicitParam(paramType = "query",name="company_name",value="园所名称",dataType = "String"),
            @ApiImplicitParam(paramType = "query",name="date",value="时间",dataType = "String")})
    public  String selfExport(HttpServletResponse response,
                              String company_name,
                              String date
    ) throws DataAccessException, UnsupportedEncodingException, ParseException {
        response.setContentType("application/x-download;charset=UTF-8");
        company_name=new String(company_name.getBytes("ISO8859-1"),"utf-8");
        date=new String(date.getBytes("ISO8859-1"),"utf-8");
        Date mydate=simpleDateFormat2.parse(date);
        String date_format=simpleDateFormat.format(mydate);
        String date_format2=simpleDateFormat2.format(mydate);
        String sd=date_format2+" 00:00:00";
        String ed=date_format2+" 23:59:59";

        try {
            ServletOutputStream out = response.getOutputStream();
            try{
                response.setHeader("Content-Disposition","attachment;fileName="+ URLEncoder.encode(company_name+"幼儿园"+date_format+"打卡数据.xls","UTF-8"));
            }catch (UnsupportedEncodingException e1){
                e1.printStackTrace();
            }
            SelfSupportExportExcel.export(company_name,cardRecordService.selectSelfSupportReport(sd,ed),out,date_format);
            return "success";
        }catch (Exception e){
            e.printStackTrace();
            return "导出信息失败";
        }
    }

    /**
     * 回访园所打卡
     * @param response
     * @param company_name
     * @param start_date
     * @param end_date
     * @return
     * @throws DataAccessException
     * @throws UnsupportedEncodingException
     * @throws ParseException
     */
    @RequestMapping(value = "/returnVisitExport",method = RequestMethod.GET,produces = "applcation/json;charset=UTF-8")
    @ApiOperation("回访园成长报告导出")
    @ApiImplicitParams(
           {@ApiImplicitParam(paramType = "query",name="company_name",value="园所名称",dataType = "String"),
            @ApiImplicitParam(paramType = "query",name="start_date",value="开始时间",dataType = "String"),
            @ApiImplicitParam(paramType = "query",name="end_date",value="结束时间",dataType = "String"),})
    public  String ReturnVisitExport(HttpServletResponse response,
                                     String company_name,
                                     String start_date,
                                     String end_date
    ) throws DataAccessException, UnsupportedEncodingException, ParseException {
        response.setContentType("application/x-download;charset=UTF-8");
        company_name=new String(company_name.getBytes("ISO8859-1"),"utf-8");
        start_date=new String(start_date.getBytes("ISO8859-1"),"utf-8");
        end_date=new String(end_date.getBytes("ISO8859-1"),"utf-8");
        String start_format=simpleDateFormat.format(simpleDateFormat2.parse(start_date));
        String end_format=simpleDateFormat.format(simpleDateFormat2.parse(end_date));
        try {
            ServletOutputStream out = response.getOutputStream();
            try{
                response.setHeader("Content-Disposition","attachment;fileName="+ URLEncoder.encode(company_name+"幼儿园"+start_format+"-"+end_format+"打卡数据.xls","UTF-8"));
            }catch (UnsupportedEncodingException e1){
                e1.printStackTrace();
            }
            ReturnVisitExportExcel.export(company_name,studentReportService.selectReturnVisitReport(start_date,end_date),out,start_format,end_format);
            return "success";
        }catch (Exception e){
            e.printStackTrace();
            return "导出信息失败";
        }
    }

    @RequestMapping(value="/selectProvince",method = RequestMethod.GET,produces = "application/json;charset=UTF-8")
    @ApiOperation(value="查询所有省份")
    public Map<String,Object> selectProvince() throws Exception{
        List<Province> provincelist = companyService.selectProvince();
        Map<String,Object> responseMap=new HashMap<>();
        responseMap.put("list",provincelist);
        return responseMap;
    }
}

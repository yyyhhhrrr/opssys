package com.zyou.ops.controller;

import com.zyou.ops.util.poiTemplate.ProvinceExportExcel;
import com.zyou.ops.util.poiTemplate.ReturnVisitExportExcel;
import com.zyou.ops.util.poiTemplate.SelfSupportExportExcel;
import com.zyou.ops.zybd.service.CardRecordService;
import com.zyou.ops.zybd.service.StudentReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @BelongsProject: opssys
 * @BelongsPackage: com.zyou.ops.controller
 * @Author: yang
 * @CreateTime: 2019-04-23 17:49
 * @Description: 数据导入控制层
 */
@Controller
@RequestMapping("/export")
public class ExportController {

    @Autowired
    private CardRecordService cardRecordService;
    @Autowired
    private StudentReportService studentReportService;

    private SimpleDateFormat simpleDateFormat=new SimpleDateFormat("MM月dd日");
    private String format = simpleDateFormat.format(new Date());
    private SimpleDateFormat simpleDateFormat2=new SimpleDateFormat("yyyy-MM-dd");

    String startDate="2019-04-17";
    String s=startDate+" 00:00:00";
    String e=startDate+" 23:59:59";


    /**
     * 宁夏打卡
     * @param response
     * @param request
     * @return
     * @throws DataAccessException
     * @throws UnsupportedEncodingException
     */
    @RequestMapping(value = "/province",method = RequestMethod.GET)
    public @ResponseBody String export(HttpServletResponse response, HttpServletRequest request
                                       ) throws DataAccessException, UnsupportedEncodingException {
        response.setContentType("application/x-download;charset=UTF-8");
        Integer province_id=Integer.valueOf(request.getParameter("province_id"));
        String province_name=new String(request.getParameter("province_name").getBytes("ISO8859-1"),"utf-8");
        System.out.println(province_id+":"+province_name);

        try {
            ServletOutputStream out = response.getOutputStream();
            try{
                response.setHeader("Content-Disposition","attachment;fileName="+ URLEncoder.encode(province_name+"幼儿园"+format+"打卡数据.xls","UTF-8"));
            }catch (UnsupportedEncodingException e1){
                e1.printStackTrace();
            }
            ProvinceExportExcel.export(province_name,cardRecordService.selectStudentReport(province_id,s,e),out,format);
            return "success";
        }catch (Exception e){
            e.printStackTrace();
            return "导出信息失败";
        }
    }

    @RequestMapping("/index")
    public String index(){
        return "export/export";
    }

    /**
     * 自营园打卡
     * @param response
     * @param request
     * @return
     * @throws DataAccessException
     * @throws UnsupportedEncodingException
     */
    @RequestMapping(value = "/selfExport",method = RequestMethod.GET)
    public @ResponseBody String selfExport(HttpServletResponse response, HttpServletRequest request
    ) throws DataAccessException, UnsupportedEncodingException {
        response.setContentType("application/x-download;charset=UTF-8");

        String company_name=new String(request.getParameter("company_name").getBytes("ISO8859-1"),"utf-8");


        try {
            ServletOutputStream out = response.getOutputStream();
            try{
                response.setHeader("Content-Disposition","attachment;fileName="+ URLEncoder.encode(company_name+"幼儿园"+format+"打卡数据.xls","UTF-8"));
            }catch (UnsupportedEncodingException e1){
                e1.printStackTrace();
            }
            SelfSupportExportExcel.export(company_name,cardRecordService.selectSelfSupportReport(s,e),out,format);
            return "success";
        }catch (Exception e){
            e.printStackTrace();
            return "导出信息失败";
        }
    }

    @RequestMapping(value = "/returnVisitExport",method = RequestMethod.GET)
    public @ResponseBody String ReturnVisitExport(HttpServletResponse response, HttpServletRequest request
    ) throws DataAccessException, UnsupportedEncodingException, ParseException {
        response.setContentType("application/x-download;charset=UTF-8");

        String company_name=new String(request.getParameter("company_name").getBytes("ISO8859-1"),"utf-8");
        String start_date=new String(request.getParameter("start_date").getBytes("ISO8859-1"),"utf-8");
        String end_date=new String(request.getParameter("end_date").getBytes("ISO8859-1"),"utf-8");
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
}

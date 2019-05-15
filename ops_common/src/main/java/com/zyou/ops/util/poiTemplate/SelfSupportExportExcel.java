package com.zyou.ops.util.poiTemplate;

import com.zyou.ops.util.utils.StringMatchUtil;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.*;

import javax.servlet.ServletOutputStream;
import java.awt.*;
import java.util.List;
import java.util.Map;

/**
 * @BelongsProject: opssys
 * @BelongsPackage: com.zyou.ops.util.poiTemplate
 * @Author: yang
 * @CreateTime: 2019-04-25 13:10
 * @Description: 自营员打卡模板
 */
public class SelfSupportExportExcel {
    public static void export(String provinceName, List<Map> resultMap, ServletOutputStream out, String format) throws Exception{


        //标题
        String[] title = {"序号", "幼儿园", "班级名称", "平均心情", "平均饮水", "平均饮食", "平均睡眠",
                "平均大便","平均小便", "平均洗手","平均打卡总次数"};

        //创建Excel工作簿
        HSSFWorkbook workbook = new HSSFWorkbook();

        //创建一个工作表sheet
        HSSFSheet sheet = workbook.createSheet();

        //创建题目行
        HSSFRow firstRow = sheet.createRow(0);
        HSSFCell cell = null;
        firstRow.setHeightInPoints(50);


        //创建标题行
        HSSFRow row = sheet.createRow(1);
        HSSFCell cell1 = null;
        row.setHeightInPoints(50);//设置单元格高度


        //设置标题单元 样式
        HSSFCellStyle titleStyle = workbook.createCellStyle();
        titleStyle.setBorderRight(BorderStyle.THIN); //右边实线
        titleStyle.setBorderLeft(BorderStyle.THIN);//左边实线
        titleStyle.setBorderTop(BorderStyle.THIN);//上边实线
        titleStyle.setBorderBottom(BorderStyle.THIN);//下边实线
        titleStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);//设置背景色必须要写
        titleStyle.setVerticalAlignment(VerticalAlignment.CENTER);//设置上下居中
        titleStyle.setAlignment(HorizontalAlignment.CENTER);//设置左右居中
        titleStyle.setFillForegroundColor(HSSFColor.HSSFColorPredefined.LIME.getIndex());//设置单元格背景色
        HSSFPalette customPalette = workbook.getCustomPalette();
        customPalette.setColorAtIndex(HSSFColor.HSSFColorPredefined.LIME.getIndex(),(byte) 233, (byte) 198, (byte) 129);

        //标题字体 样式1
        HSSFFont titleFont = workbook.createFont();
        titleFont.setFontHeightInPoints((short) 20);//设置字体大小
        titleFont.setFontName("宋体");//设置字体
        titleFont.setBold(true);//加粗
        titleStyle.setFont(titleFont);


        //设置标题单元 样式1
        HSSFCellStyle titleStyle1 = workbook.createCellStyle();
        titleStyle1.setBorderRight(BorderStyle.THIN);
        titleStyle1.setBorderLeft(BorderStyle.THIN);
        titleStyle1.setBorderTop(BorderStyle.THIN);
        titleStyle1.setBorderBottom(BorderStyle.THIN);
        titleStyle1.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        titleStyle1.setVerticalAlignment(VerticalAlignment.CENTER);
        titleStyle1.setAlignment(HorizontalAlignment.CENTER);
        titleStyle1.setFillForegroundColor(HSSFColor.HSSFColorPredefined.GREEN.getIndex());//设置单元格背景色
        HSSFPalette customPalette2 = workbook.getCustomPalette();
        customPalette2.setColorAtIndex(HSSFColor.HSSFColorPredefined.GREEN.getIndex(),(byte) 193, (byte) 236, (byte) 216);
        //标题字体 样式1
        HSSFFont titleFont1 = workbook.createFont();
        titleFont1.setFontHeightInPoints((short) 12);
        titleFont1.setFontName("宋体");
        titleFont1.setBold(true);
        titleStyle1.setFont(titleFont1);


        //设置标题单元 样式2
        HSSFCellStyle titleStyle2 = workbook.createCellStyle();
        titleStyle2.setBorderRight(BorderStyle.THIN);
        titleStyle2.setBorderLeft(BorderStyle.THIN);
        titleStyle2.setBorderTop(BorderStyle.THIN);
        titleStyle2.setBorderBottom(BorderStyle.THIN);
        titleStyle2.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        titleStyle2.setVerticalAlignment(VerticalAlignment.CENTER);
        titleStyle2.setAlignment(HorizontalAlignment.CENTER);
        HSSFPalette customPalette3 = workbook.getCustomPalette();
        customPalette3.setColorAtIndex(HSSFColor.HSSFColorPredefined.LIME.getIndex(),(byte) 233, (byte) 198, (byte) 129);
        titleStyle2.setWrapText(true);
        titleStyle2.setWrapText(true);

        //标题字体 样式2
        HSSFFont titleFont2 = workbook.createFont();
        titleFont2.setFontHeightInPoints((short) 12);
        titleFont2.setFontName("宋体");
        titleFont2.setBold(true);
        titleStyle2.setFont(titleFont2);

        //设置标题单元 样式3
        HSSFCellStyle titleStyle3 = workbook.createCellStyle();
        titleStyle3.setBorderRight(BorderStyle.THIN);
        titleStyle3.setBorderLeft(BorderStyle.THIN);
        titleStyle3.setBorderTop(BorderStyle.THIN);
        titleStyle3.setBorderBottom(BorderStyle.THIN);
        titleStyle3.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        titleStyle3.setVerticalAlignment(VerticalAlignment.CENTER);
        titleStyle3.setAlignment(HorizontalAlignment.CENTER);
        titleStyle3.setWrapText(true); //设置内容换行
        //标题字体 样式3
        HSSFFont titleFont3 = workbook.createFont();
        titleFont3.setFontHeightInPoints((short) 12);
        titleFont3.setFontName("宋体");
        titleStyle3.setFont(titleFont3);


        //插入第一行数据 题目
        String mytitle=provinceName+"幼儿园"+format+"打卡数据";
        cell = firstRow.createCell(0);
        cell.setCellValue(mytitle);
        cell.setCellStyle(titleStyle);
        CellRangeAddress region = new CellRangeAddress(0, 0, 0, 10);//合并单元格
        sheet.addMergedRegion(region);//加入sheet
        sheet.createFreezePane(0, 2);//设置冻结窗格

        //插入第二行数据 标题
        for (int i = 0; i < title.length; i++) {
            cell1 = row.createCell(i);
            cell1.setCellValue(title[i]);
            if (StringMatchUtil.match(title[i], "(次/人)")) {
                cell1.setCellStyle(titleStyle2);
            } else {
                cell1.setCellStyle(titleStyle1);
                sheet.autoSizeColumn(cell1.getColumnIndex());//根据内容自动填充表格
            }

        }

        int size=resultMap.size();
        //追加数据
        int j=0;//添加空行
        int k=1;//添加序号
        for (int i = 0; i < size; i++) {
            HSSFRow nextrow = sheet.createRow(j + 2);
            HSSFCell cell2 = nextrow.createCell(0);
            cell2.setCellValue(k);
            cell2.setCellStyle(titleStyle3);
            cell2 = nextrow.createCell(1);
            if (resultMap.get(i).get("company_name").toString() != null) {
                cell2.setCellValue(resultMap.get(i).get("company_name").toString());
            } else {
                cell2.setCellValue("");
            }
            sheet.setColumnWidth(1, 20 * 256);//设置幼儿园一列的宽高
            cell2.setCellStyle(titleStyle3);
            cell2 = nextrow.createCell(2);
            if (resultMap.get(i).get("class_name").toString() != null) {
                cell2.setCellValue(resultMap.get(i).get("class_name").toString());
            } else {
                cell2.setCellValue("");
            }
            cell2.setCellStyle(titleStyle3);
            cell2 = nextrow.createCell(3);
            if (resultMap.get(i).get("happy_avg") != null) {
                cell2.setCellValue(resultMap.get(i).get("happy_avg").toString());
            } else {
                cell2.setCellValue("");
            }
            cell2.setCellStyle(titleStyle3);
            cell2 = nextrow.createCell(4);
            if (resultMap.get(i).get("water_avg") != null) {
                cell2.setCellValue(resultMap.get(i).get("water_avg").toString());
            } else {
                cell2.setCellValue("");
            }
            cell2.setCellStyle(titleStyle3);
            cell2 = nextrow.createCell(5);
            if (resultMap.get(i).get("food_avg") != null) {
                cell2.setCellValue(resultMap.get(i).get("food_avg").toString());
            } else {
                cell2.setCellValue("");
            }
            cell2.setCellStyle(titleStyle3);
            cell2 = nextrow.createCell(6);
            if (resultMap.get(i).get("sleep_avg") != null) {
                cell2.setCellValue(resultMap.get(i).get("sleep_avg").toString());
            } else {
                cell2.setCellValue("");
            }
            cell2.setCellStyle(titleStyle3);
            cell2 = nextrow.createCell(7);
            if (resultMap.get(i).get("shit_avg") != null) {
                cell2.setCellValue(resultMap.get(i).get("shit_avg").toString());
            } else {
                cell2.setCellValue("");
            }
            cell2.setCellStyle(titleStyle3);
            cell2 = nextrow.createCell(8);
            if (resultMap.get(i).get("urinate_avg") != null) {
                cell2.setCellValue(resultMap.get(i).get("urinate_avg").toString());
            } else {
                cell2.setCellValue("");
            }
            cell2.setCellStyle(titleStyle3);
            cell2 = nextrow.createCell(9);
            if (resultMap.get(i).get("wash_avg") != null) {
                cell2.setCellValue(resultMap.get(i).get("wash_avg").toString());
            } else {
                cell2.setCellValue("");
            }
            cell2.setCellStyle(titleStyle3);
            cell2 = nextrow.createCell(10);
            if (resultMap.get(i).get("avg") != null) {
                cell2.setCellValue(resultMap.get(i).get("avg").toString());
            } else {
                cell2.setCellValue("");
            }
            cell2.setCellStyle(titleStyle3);
            sheet.autoSizeColumn(cell2.getColumnIndex());

            //添加空行
            j++;
            if(i!=size-1&&!resultMap.get(i).get("company_name").equals(resultMap.get(i+1).get("company_name"))) {
                k = 1;
                j++;
            }
            else {
                k++;
            }

        }
//       File file = new File("F:/"+mytitle+".xlsx");
        try{
            workbook.write(out);
            out.flush();
            out.close();


        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("导出信息失败");
        }
    }
}

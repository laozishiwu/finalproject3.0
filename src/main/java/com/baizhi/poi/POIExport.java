package com.baizhi.poi;

import com.baizhi.entity.User;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class POIExport {
    public static void main(String[] args) throws IOException {
        /*创建工作薄对象*/
        Workbook workbook = new HSSFWorkbook();
        /*创建工作表对象*/
        Sheet sheet = workbook.createSheet("user");
        /* 第一个参数 第几列  第二个参数  列宽*/
        sheet.setColumnWidth(2, 26 * 256);
        /*创建行   参数：行下标*/
        Row row = sheet.createRow(0);
        /*修改日期样式*/
        DataFormat dataFormat = workbook.createDataFormat();
        short format = dataFormat.getFormat("yyyy年MM月dd天");
        CellStyle cellStyle1 = workbook.createCellStyle();
        cellStyle1.setDataFormat(format);
        /*创建单元格样式*/
        CellStyle cellStyle = workbook.createCellStyle();
        /*居中*/
        cellStyle.setAlignment(HorizontalAlignment.CENTER);
        /*修改字体*/
        Font font = workbook.createFont();
        font.setFontName("楷体");
        font.setBold(true);
        font.setColor(Font.COLOR_RED);
        font.setItalic(true);
        cellStyle.setFont(font);
        String[] strs = {"编号", "姓名", "生日"};
        for (int i = 0; i < strs.length; i++) {
            Cell cell = row.createCell(i);
            cell.setCellStyle(cellStyle);
            cell.setCellValue(strs[i]);
        }
        /*数据行  查询数据库*/

        List<User> emps = Arrays.asList();
        for (int i = 0; i < emps.size(); i++) {
            Row row1 = sheet.createRow(i + 1);
            row1.createCell(0).setCellValue(emps.get(i).getId());
            row1.createCell(1).setCellValue(emps.get(i).getName());
            Cell cell = row1.createCell(2);
            cell.setCellStyle(cellStyle1);
            cell.setCellValue(emps.get(i).getRegisttime());
        }


        workbook.write(new FileOutputStream(new File("C:/a.xls")));

    }
}

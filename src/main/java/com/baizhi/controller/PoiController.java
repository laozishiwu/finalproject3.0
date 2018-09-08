package com.baizhi.controller;

import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/poi")
public class PoiController {
    @Autowired
    private UserService userService;

    @RequestMapping("/Export.do")
    @ResponseBody
    public void Export(HttpServletResponse response) {
        //创建工作薄对象
        Workbook workbook = new HSSFWorkbook();
        //创建工作表对象
        Sheet sheet = workbook.createSheet("user");
        //设置行款：第几列，列宽
        sheet.setColumnWidth(6, 26 * 256);
        sheet.setColumnWidth(11, 26 * 256);
        //创建行，参数：航下表
        Row row = sheet.createRow(0);
        //修改日期格式
        DataFormat dataFormat = workbook.createDataFormat();
        short format = dataFormat.getFormat("yyyy年MM月dd日");
        //创建单元格格式
        CellStyle cellStyle = workbook.createCellStyle();
        cellStyle.setDataFormat(format);
        //居中
        cellStyle.setAlignment(HorizontalAlignment.CENTER);
        //修改字体
        Font font = workbook.createFont();
        font.setFontName("楷体");
        font.setBold(true);
        font.setColor(Font.COLOR_RED);
        font.setItalic(true);
        cellStyle.setFont(font);
        String[] str = {"编号", "姓名", "法号", "头像", "性别", "籍贯", "格言", "手机", "密码", "加密盐", "状态", "注册时间"};
        for (int i = 0; i < str.length; i++) {
            Cell cell = row.createCell(i);
            cell.setCellStyle(cellStyle);
            cell.setCellValue(str[i]);
        }
        //数据行：查询数据库
        List<User> users = userService.queryAll();
        for (int i = 0; i < users.size(); i++) {
            Row row1 = sheet.createRow(i + 1);
            row1.createCell(0).setCellValue(users.get(i).getId());
            row1.createCell(1).setCellValue(users.get(i).getName());
            row1.createCell(2).setCellValue(users.get(i).getDhamaname());
            row1.createCell(3).setCellValue(users.get(i).getImg());
            row1.createCell(4).setCellValue(users.get(i).getSex());
            row1.createCell(5).setCellValue(users.get(i).getLocation());
            row1.createCell(6).setCellValue(users.get(i).getSign());
            row1.createCell(7).setCellValue(users.get(i).getPhone());
            row1.createCell(8).setCellValue(users.get(i).getPassword());
            row1.createCell(9).setCellValue(users.get(i).getSalt());
            row1.createCell(10).setCellValue(users.get(i).getStatus());
            row1.createCell(11).setCellValue(users.get(i).getRegisttime());
            Cell cell = row1.createCell(11);
            cell.setCellStyle(cellStyle);
            cell.setCellValue(users.get(i).getId());
            cell.setCellValue(users.get(i).getName());
            cell.setCellValue(users.get(i).getDhamaname());
            cell.setCellValue(users.get(i).getImg());
            cell.setCellValue(users.get(i).getSex());
            cell.setCellValue(users.get(i).getLocation());
            cell.setCellValue(users.get(i).getSign());
            cell.setCellValue(users.get(i).getPhone());
            cell.setCellValue(users.get(i).getPassword());
            cell.setCellValue(users.get(i).getSalt());
            cell.setCellValue(users.get(i).getStatus());
            cell.setCellValue(users.get(i).getRegisttime());
        }
        String a = new Date().getTime() + "userExcel.xls";
        String newName = null;
        try {
            newName = new String(a.getBytes("UTF-8"), "ISO-8859-1");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        response.setHeader("content-disposition", "attachment;filename=" + newName);
        response.setContentType("application/vnd.ms-excel");
        try {
            ((HSSFWorkbook) workbook).write(response.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/Import.do")
    @ResponseBody
    public List<User> Import(MultipartFile file) {
        try {
            Workbook workbook = new HSSFWorkbook(file.getInputStream());
            Sheet sheet = workbook.getSheet("user");
            List<User> users = new ArrayList<>();
            for (int i = 1; i < sheet.getLastRowNum() + 1; i++) {
                Row row = sheet.getRow(i);
                Integer id = Integer.valueOf((int) row.getCell(0).getNumericCellValue());
                //String id = row.getCell(0).getNumericCellValue() + "";
                String name = row.getCell(1).getStringCellValue();
                String dhamaname = row.getCell(2).getStringCellValue();
                String img = row.getCell(3).getStringCellValue();
                String sex = row.getCell(4).getStringCellValue();
                String location = row.getCell(5).getStringCellValue();
                String sign = row.getCell(6).getStringCellValue();
                String phone = row.getCell(7).getStringCellValue();
                String password = row.getCell(8).getStringCellValue();
                String salt = row.getCell(9).getStringCellValue();
                String status = row.getCell(10).getStringCellValue();
                //row.getCell(11).setCellType(CELL_TYPE_NUMERIC);
                Date registtime = row.getCell(11).getDateCellValue();
                User user = new User(id, name, dhamaname, img, sex, location, sign, phone, password, salt, status, registtime);
                users.add(user);
            }
            for (User use : users) {
                System.out.println(use);
            }
            return users;
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("导入数据失败！");
        }

    }

    @RequestMapping("/customerExport")
    @ResponseBody
    public void customerExport(String titles, String params, HttpServletResponse response) {

        Workbook workbook = new HSSFWorkbook();
        //字体样式
        DataFormat dataFormat = workbook.createDataFormat();
        short format = dataFormat.getFormat("yyyy年MM月dd日");
        CellStyle cellStyle = workbook.createCellStyle();
        cellStyle.setDataFormat(format);
        /*标题行*/
        Sheet sheet = workbook.createSheet("emp");
        Row row = sheet.createRow(0);
        String[] strs = titles.split(",");
        for (int i = 0; i < strs.length; i++) {
            row.createCell(i).setCellValue(strs[i]);
        }
        /*数据行*/
        String[] fileds = params.split(",");
        List<User> emps = userService.queryAll();
        for (int i = 0; i < emps.size(); i++) {
            Row row1 = sheet.createRow(i + 1);
            User emp = emps.get(i);
            /*获取类对象*/
            Class<? extends User> empClass = emp.getClass();
            for (int j = 0; j < fileds.length; j++) {
                Cell cell = row1.createCell(j);
                /*获得方法名*/
                String methodName = "get" + fileds[j].substring(0, 1).toUpperCase() + fileds[j].substring(1);
                /*获取调用的方法对象*/
                try {
                    Method method = empClass.getMethod(methodName, null);
                    Object invoke = method.invoke(emp, null);
                    if (invoke instanceof Date) {
                        sheet.setColumnWidth(j, 21 * 256);
                        cell.setCellStyle(cellStyle);
                        cell.setCellValue((Date) invoke);
                    } else {
                        cell.setCellValue((String) invoke);
                    }
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
                /*创建单元格并且填充内容*/
            }
        }
        String a = new Date().getTime() + "empExcel.xls";
        String newName = null;
        try {
            newName = new String(a.getBytes("UTF-8"), "ISO-8859-1");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        response.setHeader("content-disposition", "attachment;filename=" + newName);
        response.setContentType("application/vnd.ms-excel");

        try {
            workbook.write(response.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

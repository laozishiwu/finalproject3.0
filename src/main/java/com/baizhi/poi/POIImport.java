package com.baizhi.poi;

import com.baizhi.entity.User;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class POIImport {
    public static void main(String[] args) throws IOException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Workbook workbook = new HSSFWorkbook(new FileInputStream(new File("c:/a.xls")));
        Sheet sheet = workbook.getSheet("user");
        Row row = sheet.getRow(0);
        List<String> titles = new ArrayList<>();
        for (int i = 0; i < row.getLastCellNum(); i++) {
            String title = row.getCell(i).getStringCellValue();
            titles.add(title);
        }
        List<User> emps = new ArrayList<>();
        for (int i = 1; i < sheet.getLastRowNum() + 1; i++) {

            Row row1 = sheet.getRow(i);
            User user = new User();
            Class<? extends User> aClass = user.getClass();
            for (int j = 0; j < titles.size(); j++) {
                int cellType = row1.getCell(j).getCellType();
                String methodName = "set" + titles.get(j).substring(0, 1).toUpperCase() + titles.get(j).substring(1);
                if (cellType == Cell.CELL_TYPE_STRING) {
                    String stringCellValue = row1.getCell(j).getStringCellValue();
                    setParamter(aClass, methodName, user, stringCellValue, String.class);
                } else {
                    Date dateCellValue = row1.getCell(j).getDateCellValue();
                    setParamter(aClass, methodName, user, dateCellValue, Date.class);
                }
            }
            emps.add(user);
        }
        for (User emp : emps) {
            System.out.println(emp);
        }

    }

    public static void setParamter(Class<? extends User> aClass, String methodName, Object object, Object args, Class<?>... parameterTypes) {
        Method method = null;
        try {
            method = aClass.getMethod(methodName, parameterTypes);
            method.invoke(object, args);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }
}

package com.onlines.service;

import com.onlines.pojo.OnlinesPatrol;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//@Override
public class ExcelUpload {
    public List<OnlinesPatrol> uploadExcel(String fileName,InputStream str) {
        Map<String, Object> ruslt = new HashMap<>();
        List<OnlinesPatrol> onlinesPatrols = new ArrayList<>();
        try {

            //判断文件格式并获取工作簿
            Workbook workbook;
            if (fileName.endsWith("xls")) {
                workbook = new HSSFWorkbook(str);
            } else if (fileName.endsWith("xlsx")) {
                workbook = new XSSFWorkbook(str);
            } else {
                workbook = null;
            }
//            else {
////                ruslt.put("code", "1");
////                ruslt.put("message", "文件格式非excl");
////                return ruslt;
//            }
            //判断第一页不为空
            if (null != workbook.getSheetAt(0)) {
                //读取excl第二行，从1开始
                for (int rowNumofSheet = 1; rowNumofSheet <= workbook.getSheetAt(0).getLastRowNum(); rowNumofSheet++) {
                    if (null != workbook.getSheetAt(0).getRow(rowNumofSheet)) {
                        //定义行，并赋值
                        Row aRow = workbook.getSheetAt(0).getRow(rowNumofSheet);
                        OnlinesPatrol onlinesPatrol = new OnlinesPatrol();
                        System.out.println(aRow.getLastCellNum());
                        for (int cellNumofRow = 0; cellNumofRow < aRow.getLastCellNum(); cellNumofRow++) {
                            //读取rowNumOfSheet值所对应行的数据
                            //获得行的列数
                            Cell xCell = aRow.getCell(cellNumofRow);
                            Object cell_val;
                            if (cellNumofRow == 3) {
                                if (xCell != null && !xCell.toString().trim().isEmpty()) {
                                    cell_val = xCell.getStringCellValue();
                                    if (cell_val != null) {
                                        String temp = (String) cell_val;
                                        System.out.println("0-" + temp);
                                        if (!StringUtils.isEmpty(temp)) {
                                            onlinesPatrol.setGroupId(temp);
                                        }
                                    }
                                }
                            }
                            if (cellNumofRow == 0) {
                                if (xCell != null && !xCell.toString().trim().isEmpty()) {
                                    cell_val = xCell.getStringCellValue();
                                    if (cell_val != null) {
                                        String temp = (String) cell_val;
                                        if (!StringUtils.isEmpty(temp)) {
                                            onlinesPatrol.setUrl(temp);
                                        }
                                        System.out.println("1-" + temp);
                                    }
                                }
                            }
                            if (cellNumofRow == 1) {
                                if (xCell != null && !xCell.toString().trim().isEmpty()) {
                                    cell_val = xCell.getStringCellValue();
                                    if (cell_val != null) {
                                        String temp = (String) cell_val;
                                        if (!StringUtils.isEmpty(temp)) {
                                            onlinesPatrol.setTitle(temp);
                                        }
                                        System.out.println("1-" + temp);
                                    }
                                }
                            }
                            if (cellNumofRow == 2) {
                                if (xCell != null && !xCell.toString().trim().isEmpty()) {
                                    cell_val = xCell.getStringCellValue();
                                    if (cell_val != null) {
                                        String temp = (String) cell_val;
                                        if (!StringUtils.isEmpty(temp)) {
                                            onlinesPatrol.setHtmlinfo(temp);
                                        }
                                        System.out.println("1-" + temp);
                                    }
                                }
                            }
                            if (cellNumofRow == 4) {
                                if (xCell != null && !xCell.toString().trim().isEmpty()) {
                                    cell_val = xCell.getStringCellValue();
                                    if (cell_val != null) {
                                        String temp = (String) cell_val;
                                        if (!StringUtils.isEmpty(temp)) {
                                            onlinesPatrol.setUsername(temp);
                                        }
                                        System.out.println("1-" + temp);
                                    }
                                }
                            }

                        }
                        onlinesPatrols.add(onlinesPatrol);
//保存数据库
                    }
                }
                ruslt.put("code", "0");
                ruslt.put("message", "成功插入数据库！");
            } else {
                ruslt.put("code", "1");
                ruslt.put("message", "第一页EXCL无数据！");
            }
        } catch (Exception e) {
            e.printStackTrace();
            ruslt.put("code", "1");
            ruslt.put("message", e.getMessage());
        }
        return onlinesPatrols;
    }
}



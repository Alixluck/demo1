package com.alix.orm.demo1.common.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.math.BigDecimal;

/**
 * @author 杨安星(Alix)
 * @create 2019-11-29 17:26
 */
@Slf4j
public class ExcelUtils {

    /**
     * excel To sql file
     */
    private static void excelToSql() throws IOException {
        File xlsFile = new File("C:\\Users\\PC\\Desktop\\pdf\\费率表.xlsx");
        // 获得工作簿
        XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(xlsFile));
        int sheetNum = workbook.getNumberOfSheets();
        for (int i = 7; i < 8; i++) {
            // 获得工作表
            XSSFSheet sheet = workbook.getSheetAt(21);
            File file = new File("split/" + sheet.getSheetName() + ".sql");
            if (file.exists()) {
                file.delete();
            }
            Writer writer = null;
            writer = new FileWriter(file, true);
            int rows = sheet.getPhysicalNumberOfRows();
            int lines = 0;
            for (int j = 1; j < 13; j++) {
                for (int t = 4; t < rows; t++) {
                    Row row = sheet.getRow(t);
                    Row payLine = sheet.getRow(2);
                    Row sexLine = sheet.getRow(3);
                    if (!StringUtils.isEmpty(row.getCell(j).toString())) {
                        StringBuilder sqlbuff = new StringBuilder("INSERT INTO t_rate_extend (risk_code, rule, fee, rule_value) VALUES (");
                        sqlbuff.append("'I195000002',");
                        sqlbuff.append("'age/sex/paymentCode/termCode/d10079/d10080/d10083/d10084/d10085',");
                        sqlbuff.append("'").append(double2String(Double.parseDouble(row.getCell(j).toString()))).append("'");
                        sqlbuff.append(",'");
                        sqlbuff.append(row.getCell(0) + "/");
                        if ("男".equals(sexLine.getCell(j).toString().trim())) {
                            sqlbuff.append("M/");
                        } else if ("女".equals(sexLine.getCell(j).toString().trim())) {
                            sqlbuff.append("F/");
                        }
                        if ("趸交".equals(payLine.getCell(j).toString().trim())) {
                            sqlbuff.append("single/");
                        } else if (StringUtils.isEmpty(payLine.getCell(j).toString().trim()) && "趸交".equals(payLine.getCell(j - 1).toString().trim())) {
                            sqlbuff.append("single/");
                        } else if ("5 年交".equals(payLine.getCell(j).toString().trim())) {
                            sqlbuff.append("year_5/");
                        } else if (StringUtils.isEmpty(payLine.getCell(j).toString().trim()) && "5 年交".equals(payLine.getCell(j - 1).toString().trim())) {
                            sqlbuff.append("year_5/");
                        } else if ("10 年交".equals(payLine.getCell(j).toString().trim())) {
                            sqlbuff.append("year_10/");
                        } else if (StringUtils.isEmpty(payLine.getCell(j).toString().trim()) && "10 年交".equals(payLine.getCell(j - 1).toString().trim())) {
                            sqlbuff.append("year_10/");
                        } else if ("15 年交".equals(payLine.getCell(j).toString().trim())) {
                            sqlbuff.append("year_15/");
                        } else if (StringUtils.isEmpty(payLine.getCell(j).toString().trim()) && "15 年交".equals(payLine.getCell(j - 1).toString().trim())) {
                            sqlbuff.append("year_15/");
                        } else if ("20 年交".equals(payLine.getCell(j).toString().trim())) {
                            sqlbuff.append("year_20/");
                        } else if (StringUtils.isEmpty(payLine.getCell(j).toString().trim()) && "20 年交".equals(payLine.getCell(j - 1).toString().trim())) {
                            sqlbuff.append("year_20/");
                        } else if ("30 年交".equals(payLine.getCell(j).toString().trim())) {
                            sqlbuff.append("year_30/");
                        } else if (StringUtils.isEmpty(payLine.getCell(j).toString().trim()) && "30 年交".equals(payLine.getCell(j - 1).toString().trim())) {
                            sqlbuff.append("year_30/");
                        }
                        if ("Sheet1".equals(sheet.getSheetName())) {
                            sqlbuff.append("full/0/0/0/0/0");
                        } else if ("Sheet2".equals(sheet.getSheetName())) {
                            sqlbuff.append("to_70/0/0/0/0/0");
                        } else if ("Sheet3".equals(sheet.getSheetName())) {
                            sqlbuff.append("to_60/0/0/0/0/0");
                        } else if ("Sheet4".equals(sheet.getSheetName())) {
                            sqlbuff.append("full/1/0/0/0/0");
                        } else if ("Sheet5".equals(sheet.getSheetName())) {
                            sqlbuff.append("to_70/1/0/0/0/0");
                        } else if ("Sheet6".equals(sheet.getSheetName())) {
                            sqlbuff.append("to_60/1/0/0/0/0");
                        } else if ("Sheet7".equals(sheet.getSheetName())) {
                            sqlbuff.append("full/0/1/0/0/0");
                        } else if ("Sheet8".equals(sheet.getSheetName())) {
                            sqlbuff.append("to_70/0/1/0/0/0");
                        } else if ("Sheet9".equals(sheet.getSheetName())) {
                            sqlbuff.append("to_60/0/1/0/0/0");
                        } else if ("Sheet10".equals(sheet.getSheetName())) {
                            sqlbuff.append("full/1/1/0/0/0");
                        } else if ("Sheet11".equals(sheet.getSheetName())) {
                            sqlbuff.append("to_70/1/1/0/0/0");
                        } else if ("Sheet12".equals(sheet.getSheetName())) {
                            sqlbuff.append("to_60/1/1/0/0/0");
                        } else if ("Sheet13".equals(sheet.getSheetName())) {
                            sqlbuff.append("full/0/1/1/0/0");
                        } else if ("Sheet14".equals(sheet.getSheetName())) {
                            sqlbuff.append("full/1/1/1/0/0");
                        } else if ("Sheet15".equals(sheet.getSheetName())) {
                            sqlbuff.append("full/0/0/1/0/0");
                        } else if ("Sheet16".equals(sheet.getSheetName())) {
                            sqlbuff.append("to_70/0/0/1/0/0");
                        } else if ("Sheet17".equals(sheet.getSheetName())) {
                            sqlbuff.append("to_60/0/0/1/0/0");
                        } else if ("Sheet18".equals(sheet.getSheetName())) {
                            sqlbuff.append("full/1/0/1/0/0");
                        } else if ("Sheet19".equals(sheet.getSheetName())) {
                            sqlbuff.append("to_70/1/0/1/0/0");
                        } else if ("Sheet20".equals(sheet.getSheetName())) {
                            sqlbuff.append("to_60/1/0/1/0/0");
                        } else if ("Sheet21".equals(sheet.getSheetName())) {
                            sqlbuff.append("full/1/0/0/0/1");
                        } else if ("Sheet22".equals(sheet.getSheetName())) {
                            sqlbuff.append("full/1/0/0/1/1");
                        }
                        sqlbuff.append("'");
                        sqlbuff.append(");");
                        System.out.println(sqlbuff.toString());
                        sqlbuff.append("\n");
                        writer.write(sqlbuff.toString());
                        lines++;
                    }
                }
            }
            writer.close();
            log.info("执行结束" + lines);
        }
    }

//    /**
//     * excel to sql 附加险
//     */
//    private static void excelToSql1() throws IOException {
//        try {
//            File xlsFile = new File("C:\\Users\\PC\\Desktop\\pdf\\费率表.xlsx");
//            // 获得工作簿
//            XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(xlsFile));
//            int sheetNum = workbook.getNumberOfSheets();
//            // 获得工作表
//            XSSFSheet sheet = workbook.getSheetAt(22);
//            File file = new File("split/" + sheet.getSheetName() + ".sql");
//            if (file.exists()) {
//                file.delete();
//            }
//            Writer writer = null;
//            writer = new FileWriter(file, true);
//            int rows = sheet.getPhysicalNumberOfRows();
//            int lines = 0;
//            for (int j = 1; j < 11; j++) {
//                for (int t = 2; t < rows; t++) {
//                    Row row = sheet.getRow(t);
//                    Row payLine = sheet.getRow(0);
//                    Row sexLine = sheet.getRow(1);
//                    if (!StringUtils.isEmpty(row.getCell(j).toString())) {
//                        StringBuilder sqlbuff = new StringBuilder("INSERT INTO t_rate_extend (risk_code, rule, fee, rule_value) VALUES (");
//                        sqlbuff.append("'I195000003',");
//                        sqlbuff.append("'age/sex/paymentCode',");
//                        sqlbuff.append("'" + double2String(Double.valueOf(row.getCell(j).toString())).toString()+ "'");
//                        sqlbuff.append(",'");
//                        sqlbuff.append(row.getCell(0).toString().replace("周岁","").trim() + "/");
//                        if ("男".equals(sexLine.getCell(j).toString().trim())) {
//                            sqlbuff.append("M/");
//                        } else if ("女".equals(sexLine.getCell(j).toString().trim())) {
//                            sqlbuff.append("F/");
//                        }
//                        if ("4 年交".equals(payLine.getCell(j).toString().trim())) {
//                            sqlbuff.append("year_5");
//                        } else if (StringUtils.isEmpty(payLine.getCell(j).toString().trim()) && "4 年交".equals(payLine.getCell(j - 1).toString().trim())) {
//                            sqlbuff.append("year_5");
//                        } else if ("9 年交".equals(payLine.getCell(j).toString().trim())) {
//                            sqlbuff.append("year_10");
//                        } else if (StringUtils.isEmpty(payLine.getCell(j).toString().trim()) && "9 年交".equals(payLine.getCell(j - 1).toString().trim())) {
//                            sqlbuff.append("year_10");
//                        } else if ("14 年交".equals(payLine.getCell(j).toString().trim())) {
//                            sqlbuff.append("year_15");
//                        } else if (StringUtils.isEmpty(payLine.getCell(j).toString().trim()) && "14 年交".equals(payLine.getCell(j - 1).toString().trim())) {
//                            sqlbuff.append("year_15");
//                        } else if ("19 年交".equals(payLine.getCell(j).toString().trim())) {
//                            sqlbuff.append("year_20");
//                        } else if (StringUtils.isEmpty(payLine.getCell(j).toString().trim()) && "19 年交".equals(payLine.getCell(j - 1).toString().trim())) {
//                            sqlbuff.append("year_20");
//                        } else if ("29 年交".equals(payLine.getCell(j).toString().trim())) {
//                            sqlbuff.append("year_30");
//                        } else if (StringUtils.isEmpty(payLine.getCell(j).toString().trim()) && "29 年交".equals(payLine.getCell(j - 1).toString().trim())) {
//                            sqlbuff.append("year_30");
//                        }
//                        sqlbuff.append("');");
//                        System.out.println(sqlbuff.toString());
//                        sqlbuff.append("\n");
//                        writer.write(sqlbuff.toString());
//                        lines++;
//                    }
//                }
//            }
//            writer.close();
//            log.info("执行结束" + lines);
//        }catch (Exception e){
//            log.error("管你是什么错误跑出来"+e.getMessage());
//            e.printStackTrace();
//        }
//    }

    public static void main(String[] args) {
        try {
            ExcelUtils.excelToSql();
        } catch (Exception e) {
            log.error("excel del fail");
            log.error(e.getMessage());
        }
    }

    /**
     * double 乘以100转成字符串格式
     * */
    private static String double2String(double d){
        BigDecimal bg = new BigDecimal(d * 100);
        double doubleValue = bg.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
        return  String.valueOf((int)doubleValue);
    }
}

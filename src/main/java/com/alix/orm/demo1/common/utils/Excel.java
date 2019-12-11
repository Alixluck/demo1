package com.alix.orm.demo1.common.utils;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;

/**
 * @author 杨安星(Alix)
 * @create 2019-12-11 17:45
 */
public class Excel {
    public static void main(String[] args) throws Exception {
        File baodan = new File("C:\\Users\\PC\\Desktop\\report\\1.xlsx");
        XSSFWorkbook workbook1 = new XSSFWorkbook(new FileInputStream(baodan));
        XSSFSheet sheet1 = workbook1.getSheetAt(1); //首次上传保单时间

        XSSFWorkbook newXSSFWorkbook = new XSSFWorkbook();//创建新的Excel
        XSSFSheet sheet2 = newXSSFWorkbook.createSheet();//创建显得sheet

        int rowNumber = sheet1.getPhysicalNumberOfRows();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY-MM-DD HH:mm:ss");
        sheet2.createRow(0);
        for(int i=0;i<3;i++){
            Cell cell = sheet2.getRow(0).createCell(i);
            cell.setCellValue(sheet1.getRow(0).getCell(i).getStringCellValue());
        }



//        for(int i=1;i<rowNumber;i++){
//            sheet2.createRow(i);
//            for(int t=0;t<4;t++){
//                Cell cell = sheet2.getRow(i).createCell(t);
//                if (sheet1.getRow(i).getCell(t).getCellType().equals(CellType.NUMERIC)){
//                    cell.setCellValue(sheet1.getRow(i).getCell(t).getNumericCellValue());
//                }else {
//                    cell.setCellValue(sheet1.getRow(i).getCell(t).getStringCellValue());
//                }
//            }
//
//            Row row = sheet1.getRow(i);
//            if("\\N".equals(row.getCell(2).toString())){
//                row.createCell(6);
//                Cell cell = row.getCell(6);
//                cell.setCellType(CellType.STRING);
//                cell.setCellValue("未挂号");
//
//                sheet2.getRow(i).getCell(3).setCellValue("未挂号");
//            }else {
//                System.out.println(i);
//                if(row.getCell(1).getDateCellValue().getTime()<row.getCell(2).getDateCellValue().getTime()){ //先上传保单
//                    row.createCell(6);
//                    Cell cell = row.getCell(6);
//                    cell.setCellType(CellType.STRING);
//                    cell.setCellValue("后挂号");
//                    sheet2.getRow(i).getCell(3).setCellValue("后挂号");
//                }else {
//                    row.createCell(6);
//                    Cell cell = row.getCell(6);
//                    cell.setCellType(CellType.STRING);
//                    cell.setCellValue("先挂号");
//                    sheet2.getRow(i).getCell(3).setCellValue("先挂号");
//                }
//            }
//
//            System.out.println("========================="+i+"==============================");
//        }
        OutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream("C:\\Users\\PC\\Desktop\\report\\2.xlsx");
            newXSSFWorkbook.write(outputStream);
        } finally {
            if (outputStream != null) {
                outputStream.close();
            }
            if (newXSSFWorkbook != null) {
                newXSSFWorkbook.close();
            }
        }

    }
}

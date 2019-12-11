package com.alix.orm.demo1.common.utils;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author 杨安星(Alix)
 * @create 2019-12-11 21:59
 */
public class LC_negotiation {

    public static final String TEST_FILE = "tests/1.xls";

    public LC_negotiation(){
        try {
            // Create Excel-95 spreadsheet
            HSSFWorkbook workbook = new HSSFWorkbook();
            HSSFSheet sheet = workbook.createSheet();

            HSSFRow row = sheet.createRow(1);
            Cell cell = row.createCell(2);
            cell.setCellValue("Name");

            row = sheet.createRow(2);
            cell = row.createCell(2);
            cell.setCellValue("Address");

            FileOutputStream outFile =
                    new FileOutputStream(new File(TEST_FILE));
            workbook.write(outFile);
            workbook.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        LC_negotiation lc_one = new LC_negotiation();
    }

}

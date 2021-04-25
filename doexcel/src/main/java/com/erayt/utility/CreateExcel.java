package com.erayt.utility;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * @Auther: Z151
 * 练习鼓捣Excel  5.0.0
 *  demo地址：https://poi.apache.org/components/spreadsheet/quick-guide.html#NewWorkbook
 * @Date: 2021/4/25 16:12
 */
public class CreateExcel {

    public void createExcel(){
        Workbook wb = new HSSFWorkbook();
        try  (OutputStream fileOut = new FileOutputStream("workbook.xls")) {
            Sheet first = wb.createSheet("first");
            Row row = first.createRow(0);
            Cell cell = row.createCell(0);
            cell.setCellValue("1");
            Cell cell2 = row.createCell(1);
            cell2.setCellValue(2);
            wb.write(fileOut);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Workbook wb1 = new XSSFWorkbook();

        try (OutputStream fileOut = new FileOutputStream("workbook.xlsx")) {
            wb1.write(fileOut);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

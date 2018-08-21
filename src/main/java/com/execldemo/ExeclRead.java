package com.execldemo;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;

public class ExeclRead {
    public static void main(String[] args) {
        XSSFWorkbook xssfWorkbook;
        XSSFSheet xssfSheet;
        XSSFCell xssfCell;

        String path = "./src/main/java/com/execldemo.xlsx";
        String sheetNmae = "LoginTests";
        try {
            FileInputStream fileInputStream = new FileInputStream(path);
            xssfWorkbook = new XSSFWorkbook(fileInputStream);
            xssfSheet = xssfWorkbook.getSheet(sheetNmae);
            xssfCell = xssfSheet.getRow(1).getCell(2);
            String cellData = xssfCell.getStringCellValue();
            System.out.println("单元格数据是：" + cellData);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

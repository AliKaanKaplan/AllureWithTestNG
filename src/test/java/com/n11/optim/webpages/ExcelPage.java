package com.n11.optim.webpages;

import com.n11.optim.model.ExcelUser;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import com.n11.optim.tests.AddingProductControl;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ExcelPage {
    public static XSSFCell username;
    public static XSSFCell password;
    //////////////// ---- EXCEL PAGE

    public static List<ExcelUser> excelDataRead() throws IOException {
        AddingProductControl addingProductControl = new AddingProductControl();
        XSSFWorkbook workbook;
        XSSFSheet sheet;

        {
            File src=new File("/Users/testinium/allure-testng-example/src/test/resources/Excel.xlsx");
            FileInputStream finput = new FileInputStream(src);
            workbook = new XSSFWorkbook(finput);
            sheet= workbook.getSheetAt(0);
            List<ExcelUser> myList = new ArrayList<>();
            username = sheet.getRow(0).getCell(0);
            username.setCellType(Cell.CELL_TYPE_STRING);
            password = sheet.getRow(0).getCell(1);
            password.setCellType(Cell.CELL_TYPE_STRING);
            return myList;

            /*
            // Write data in the excel.
            FileOutputStream foutput=new FileOutputStream(src);

            // Specify the message needs to be written.
            String message = "Data Imported Successfully.";

            // Create cell where data needs to be written.
            sheet.getRow(i).createCell(3).setCellValue(message);

            // Specify the file in which data needs to be written.
            FileOutputStream fileOutput = new FileOutputStream(src);

            // finally write content
            workbook.write(fileOutput);

            // close the file
            fileOutput.close();
             */

        }

    }


}

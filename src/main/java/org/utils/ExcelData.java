package org.utils;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import java.io.IOException;

public class ExcelData {

    /**
     * This code will read the data from the Excel file.
     *
     * @return data
     */
    @DataProvider(name = "data")
    public static Object[][] getExcel(String fileName) throws IOException {

        XSSFWorkbook workbook = new XSSFWorkbook(fileName);
        XSSFSheet sheet = workbook.getSheetAt(0);
        int rownumber = sheet.getLastRowNum();
        System.out.println("No. of Rows:" + rownumber);
        int cellnumber = sheet.getRow(0).getLastCellNum();
        System.out.println("No. of Columns:" + cellnumber);
        String[][] data = new String[rownumber][cellnumber];
        for (int i = 1; i <= rownumber; i++) {
            XSSFRow row = sheet.getRow(i);
            for (int j = 0; j < cellnumber; j++) {
                XSSFCell cell = row.getCell(j);
                DataFormatter dataFormatter = new DataFormatter();
                String value = dataFormatter.formatCellValue(cell);
                System.out.println(value);
                data[i - 1][j] = value;
            }
        }
        workbook.close();
        return data;
    }
}


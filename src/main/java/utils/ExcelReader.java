package utils;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class ExcelReader {

    @DataProvider
    public static Iterator<Object[]> exceldata() throws IOException {

        List<Map<String, String>> data = new ArrayList<>();

        String filepath = System.getProperty("user.dir") + "/src/test/resources/TestCase.xlsx";
        FileInputStream fileInputStream = new FileInputStream(filepath);
        Workbook workbook = WorkbookFactory.create(fileInputStream);
        Sheet sheet = workbook.getSheet("Sheet1");
        int row = sheet.getLastRowNum();
        int column = sheet.getRow(0).getLastCellNum();
        for (int i = 1; i <= row; i++) {
            Map<String, String> val = new HashMap<>();
            for (int j = 0; j < column; j++) {
                val.put(sheet.getRow(0).getCell(j).toString(),
                        sheet.getRow(i).getCell(j).toString());
            }
            data.add(val);
        }
        List<Object[]> iterator = new ArrayList<>();
        for (Map<String, String> list : data) {
            iterator.add(new Object[]{list});
        }
        return iterator.iterator();
    }
}



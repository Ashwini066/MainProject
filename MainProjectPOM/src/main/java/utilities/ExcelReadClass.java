package utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReadClass {
    static FileInputStream file;
    static XSSFWorkbook book;
    static XSSFSheet sheet;
    static DataFormatter formatter = new DataFormatter();

    public static String readStringData(int row, int col) throws IOException {
        file = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\TestData.xlsx");
        book = new XSSFWorkbook(file);
        sheet = book.getSheet("Sheet1");
        Row r = sheet.getRow(row);
        Cell c = r.getCell(col);
        return formatter.formatCellValue(c);
    }

    public static String readIntegerData(int row, int col) throws IOException {
        file = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\TestData.xlsx");
        book = new XSSFWorkbook(file);
        sheet = book.getSheet("Sheet1");
        Row r = sheet.getRow(row);
        Cell c = r.getCell(col);
        if (c.getCellType() == CellType.NUMERIC) {
            return String.valueOf((int) c.getNumericCellValue());
        } else if (c.getCellType() == CellType.STRING) {
            return c.getStringCellValue();
        } else {
            throw new IllegalStateException("Unexpected cell type: " + c.getCellType());
        }
    }
}

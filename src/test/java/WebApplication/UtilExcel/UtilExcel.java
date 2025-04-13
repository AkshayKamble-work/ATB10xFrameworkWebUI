package WebApplication.UtilExcel;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.IOException;
public class UtilExcel {

    // Apache POI
    // Read the File - TestData.xlsX
    //  Workbook Create
    // Sheet
    // Row and Cell
    // 2D Object  - getData()

    // File -> Workbook -> Sheet-> Row -> cell -> [][]



    static Workbook book;
    static Sheet sheet;

    public static String SHEET_PATH = System.getProperty("user.dir") + "/src/main/resources/TestData.xlsx";

    public static Object[][] getTestDataFromExcel(String sheetName) {
        FileInputStream file = null;

        try {
            file = new FileInputStream(SHEET_PATH);
            book = WorkbookFactory.create(file);
            sheet = book.getSheet(sheetName);

            // 🔴 Handle null sheet error
            if (sheet == null) {
                throw new RuntimeException("❌ Sheet '" + sheetName + "' not found in Excel file: " + SHEET_PATH);
            }

        } catch (IOException e) {
            throw new RuntimeException("❌ Either file not found or workbook couldn't be created: " + SHEET_PATH, e);
        }

        int rowCount = sheet.getLastRowNum();
        int colCount = sheet.getRow(0).getLastCellNum();

        Object[][] data = new Object[rowCount][colCount];

        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                data[i][j] = sheet.getRow(i + 1).getCell(j).toString();
            }
        }
        return data;
    }
}

package com.yourcompany.automation.utils;

import org.apache.poi.ss.usermodel.*;
import java.io.FileInputStream;
import java.io.IOException;

public class ExcelUtils {

    private Workbook workbook;
    private Sheet sheet;

    /**
     * Loads the Excel file and selects the required sheet.
     *
     * @param filePath  path of the Excel file
     * @param sheetName name of the Excel sheet
     */
    public ExcelUtils(String filePath, String sheetName) {

        try {
            FileInputStream fis = new FileInputStream(filePath);

            workbook = WorkbookFactory.create(fis);
            sheet = workbook.getSheet(sheetName);

            if (sheet == null) {
                throw new RuntimeException(
                        "Sheet not found: " + sheetName
                );
            }

        } catch (IOException e) {
            throw new RuntimeException(
                    "Unable to read Excel file: " + filePath, e
            );
        }
    }

    /**
     * Returns the data from a particular cell as String.
     *
     * @param rowNum    row number (0-based)
     * @param columnNum column number (0-based)
     */
    public String getCellData(int rowNum, int columnNum) {

        Cell cell = sheet.getRow(rowNum).getCell(columnNum);

        DataFormatter formatter = new DataFormatter();

        return formatter.formatCellValue(cell);
    }

    /**
     * Returns the number of rows containing data.
     */
    public int getRowCount() {
        return sheet.getPhysicalNumberOfRows();
    }

    /**
     * Returns the number of columns in the first row.
     */
    public int getColumnCount() {

        return sheet.getRow(0).getPhysicalNumberOfCells();
    }

    /**
     * Returns the complete Excel data as a 2D String array.
     */
    public String[][] getExcelData() {

        int rowCount = getRowCount();
        int columnCount = getColumnCount();

        String[][] data = new String[rowCount][columnCount];

        for (int i = 0; i < rowCount; i++) {

            for (int j = 0; j < columnCount; j++) {

                data[i][j] = getCellData(i, j);
            }
        }

        return data;
    }

    /**
     * Closes the workbook.
     */
    public void closeWorkbook() {

        try {

            if (workbook != null) {
                workbook.close();
            }

        } catch (IOException e) {
            throw new RuntimeException(
                    "Unable to close Excel workbook", e
            );
        }
    }
}
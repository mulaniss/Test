package com.utilities;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataConfig {
	XSSFWorkbook wb;
	XSSFSheet sheet;

	public ExcelDataConfig() {
		try {
			File src = new File("./TestData/TestDataSheet.xlsx");
			FileInputStream fis = new FileInputStream(src);
			wb = new XSSFWorkbook(fis);

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	public String getData(String sheetName, int row, int col) {

		sheet = wb.getSheet(sheetName);
		String data = sheet.getRow(row).getCell(col).getStringCellValue();

		return data;
	}

	public int rowCount(String SName) {

		int row = wb.getSheet(SName).getLastRowNum();
		row = row + 1;

		return row;

	}

}

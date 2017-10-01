package com.test;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {

	public static void main(String[] args) throws Exception {

		File src = new File("D:\\Selenium-Appium\\TestData.xlsx");
		FileInputStream fis = new FileInputStream(src);

		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet1 = wb.getSheet("Test");

		/*
		 * String data0 = sheet1.getRow(0).getCell(0).getStringCellValue();
		 * System.out.println(data0);
		 * 
		 * String data1 = sheet1.getRow(0).getCell(1).getStringCellValue();
		 * System.out.println(data1);
		 */

		int rowcount = sheet1.getLastRowNum();

		for (int i = 0; i < rowcount; i++) {

			String data = sheet1.getRow(i).getCell(0).getStringCellValue();
			System.out.println(data);

		}

		int a = 5, b = 4;

		if (a > b) {

			sheet1.getRow(0).createCell(2).setCellValue("Pass");

			FileOutputStream fout = new FileOutputStream(src);
			wb.write(fout);
			System.out.println("Pass");
		}

		else {

			sheet1.getRow(0).createCell(2).setCellValue("Fail");

			FileOutputStream fout = new FileOutputStream(src);
			wb.write(fout);
			System.out.println("Fail");
		}
		wb.close();
	}

}

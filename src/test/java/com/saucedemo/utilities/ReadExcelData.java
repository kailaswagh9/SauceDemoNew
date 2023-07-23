package com.saucedemo.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.collections4.bag.SynchronizedSortedBag;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ReadExcelData {

	public static File file;
	public static XSSFWorkbook workBook;
	public static XSSFSheet sheet;
	public static XSSFCell cell;
	public static XSSFRow row;
	public static String filePath = "C:/Users/Admin/eclipse-workspace/Saucedemo/TestData/saucedemo.xlsx";
	@DataProvider(name="ExcelData")
	public String[][] getLoginData(Method method) throws IOException, InvalidFormatException {

		file = new File(filePath);
		String[][] data = null;
		if (file.exists()) {
			workBook = new XSSFWorkbook(file);
			
			if(method.getName().equalsIgnoreCase("verifyLogin")) {
				sheet = workBook.getSheet("LoginTestData");
			}
			else if(method.getName().equalsIgnoreCase("fillPracticeForm")){
				sheet = workBook.getSheet("KWPracticeForm");
			}
			
			int lastRow = sheet.getPhysicalNumberOfRows();
			int lastCol = sheet.getRow(0).getLastCellNum();
//		System.out.println(sheet.getRow(2).getCell(2).getStringCellValue());
			data = new String[lastRow - 1][lastCol];
			for (int i = 0; i < lastRow - 1; i++) {
				for (int j = 0; j < lastCol; j++) {
					DataFormatter df = new DataFormatter();
					data[i][j] = df.formatCellValue(sheet.getRow(i + 1).getCell(j));
//							sheet.getRow(i + 1).getCell(j).getStringCellValue();
				}
			}
			/*
			 * for(String[] s:data) { System.out.println(Arrays.toString(s)); }
			 */

		} else {
			System.out.println("File not exists");
		}
		return data;

	}
	
	
}

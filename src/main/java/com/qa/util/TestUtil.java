package com.qa.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class TestUtil {
	static long PAGE_LOAD_TIMEOUT = 30;
	static long PAGE_IMOLICIT_WAIT = 10;
	
	static Workbook book;
	static Sheet sheet;

	public static Object[][] getTestData(String sheetName){
		FileInputStream file = null;
		
		try {
			file = new FileInputStream("/Users/admin/eclipse-workspace/Assignment/src/main/java/com/qa/testdata/testData.xlsx");
		}catch (FileNotFoundException e){
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(file);
		}catch (InvalidFormatException e) {
			// TODO: handle exception
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		sheet = (Sheet) book.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		
		for(int i=0; i < sheet.getLastRowNum(); i++) {
			for(int k=0; k < sheet.getRow(0).getLastCellNum(); k++) {
				data[i][k] = sheet.getRow(i+1).getCell(k).toString();
			}
		}
		
		return data;
	}
}

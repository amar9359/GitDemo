package com.technocredits.orghrm.testscripts;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TestExcelExample {
	
	public static void main(String[] args) throws IOException {
		String filepath = "./testdata/logindata.xlsx";
		File file = new File(filepath);
		FileInputStream inputStream = new FileInputStream(file);
		
		Workbook myWorkbook = new XSSFWorkbook(inputStream);
		Sheet sheet = myWorkbook.getSheet("data");
		
		int totalRows = sheet.getLastRowNum();
		
		int totalCols = sheet.getRow(0).getLastCellNum();
		
		Object[][] data = new Object[totalRows][totalCols];
		for(int rowIndex=1; rowIndex<=totalRows; rowIndex++) {
			for(int colIndex=0; colIndex<totalCols; colIndex++) {
				Cell cell = sheet.getRow(rowIndex).getCell(colIndex);
				if(cell.getCellType() == CellType.BOOLEAN) {
					data[rowIndex-1][colIndex] = cell.getBooleanCellValue();
				}else if(cell.getCellType() == CellType.STRING) {
					data[rowIndex-1][colIndex] = cell.getStringCellValue();
				}else if(cell.getCellType() == CellType.NUMERIC) {
					data[rowIndex-1][colIndex] = cell.getStringCellValue();
				}
			}
		}
	}
}

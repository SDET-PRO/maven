package com.project.maven;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class Utility {

	private static int[] tcNums;

	public static String excelUtil(String tc, String colName, String sheetname)
			throws EncryptedDocumentException, IOException {
		int count = 0;
		int cellField = 0;
		int rowCount = 0;
		int tstCseCount = 0;
		Sheet sh = null;
		try {
			FileInputStream fis = new FileInputStream(
					"C:\\Users\\Soumya\\eclipse-workspace\\maven\\data\\ExcelUtil.xlsx");
			Workbook wb = new XSSFWorkbook(fis);

			sh = wb.getSheet(sheetname);
			Iterator<Row> rows = sh.rowIterator();
			Row row = rows.next();
			Iterator<Cell> cell = row.cellIterator();

			while (cell.hasNext()) {
				Cell c = cell.next();
				if (c.getStringCellValue().equalsIgnoreCase("TestCaseID")) {
					tstCseCount = count;
				} else if (c.getStringCellValue().equalsIgnoreCase(colName)) {
					cellField = count;
					break;
				}
				count++;
			}

			count = 1;
			while (rows.hasNext()) {

				Row r = rows.next();
				if (r.getCell(tstCseCount).getStringCellValue().equals(tc)) {
					rowCount = count;
					break;
				}
				count++;
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return sh.getRow(rowCount).getCell(cellField).getStringCellValue().toString();
	}

	public static String[][] excelUtilForDataprovider(String tc, String sheetname)
	 {
		int count = 0;
		int cellField = 0;
		int tstCseCount = 0;
		int rowCount=0;
		Sheet sheet = null;
		String[][] arrayExcelData = null;
		tcNums=null;
		try {
			FileInputStream fis = new FileInputStream(
					"C:\\Users\\Soumya\\eclipse-workspace\\maven\\data\\ExcelUtil.xlsx");
			Workbook wb = new XSSFWorkbook(fis);

			sheet = wb.getSheet(sheetname);
			Iterator<Row> rows = sheet.rowIterator();
			Row row = rows.next();
            cellField=row.getPhysicalNumberOfCells();
			Iterator<Cell> cell = row.cellIterator();

			while (cell.hasNext()) {
				Cell c = cell.next();
				if (c.getStringCellValue().equalsIgnoreCase("TestCaseID")) {
					tstCseCount = count;
					break;
				}
				count++;
			}
			count = 1;
			for (int i = 1; i < sheet.getPhysicalNumberOfRows(); i++) {

                if(sheet.getRow(i).getCell(tstCseCount).getStringCellValue().equalsIgnoreCase(tc))
                {
                	rowCount=count;
    				count++;

                }
			}
			tcNums = new int[rowCount];
			count=0;
			for (int i = 1; i < sheet.getPhysicalNumberOfRows(); i++) {
				if (sheet.getRow(i).getCell(tstCseCount).getStringCellValue().toString().equalsIgnoreCase(tc)) {
					tcNums[count] = i;   //[4,5]
					count++;
				}
			}

			arrayExcelData = new String[tcNums.length][cellField-1];

			for (int i = 0; i < tcNums.length; i++) {
				for (int j = 0; j < cellField-1; j++) {
                  arrayExcelData[i][j]=sheet.getRow(tcNums[i]).getCell(tstCseCount+j+1).getStringCellValue();
				}
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
			e.printStackTrace();
		} catch (EncryptedDocumentException e) {
			e.printStackTrace();
		}
		
		return arrayExcelData;

	
	}

}

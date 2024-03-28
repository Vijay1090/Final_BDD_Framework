package com.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

  private FileInputStream fis;
  private String path;
  private XSSFWorkbook workbook;
  private XSSFSheet sheet;
  private Row headerRow;
  private Row testDataRow;

  // This Excel Utility helps us to read the values from excel and store it in a Map i.e. in <Key>
  // <Value> Pair.
  public Map<String, String> getTestDataFromExcel() throws FileNotFoundException {
    FileInputStream file = new FileInputStream(
        System.getProperty("user.dir") + "\\src\\main\\java\\TestData\\Domino's Pizza Order.xlsx");

    Map<String, String> map = new HashMap<String, String>();

    // Created object of Workbook
    XSSFWorkbook workbook = null;
    try {
      workbook = new XSSFWorkbook(file);
    } catch (IOException e1) {
      e1.printStackTrace();
    }

    // Created object Sheet
    XSSFSheet worksheet = workbook.getSheet("Sheet2");

    for (int row = 1; row <= worksheet.getLastRowNum(); row++) {

      String key = worksheet.getRow(row).getCell(0).getStringCellValue();
      DataFormatter df = new DataFormatter();
      String value = df.formatCellValue(worksheet.getRow(row).getCell(1));

      map.put(key, value);
    }
    return map;
  }
  
  public Map<String, String> getTestDataForNonVegFromExcel() throws FileNotFoundException {
	  FileInputStream file = new FileInputStream(
		        System.getProperty("user.dir") + "\\src\\main\\java\\TestData\\Domino's Pizza Order.xlsx");

		    Map<String, String> map = new HashMap<String, String>();

		    // Created object of Workbook
		    XSSFWorkbook workbook = null;
		    try {
		      workbook = new XSSFWorkbook(file);
		    } catch (IOException e1) {
		      e1.printStackTrace();
		    }

		    // Created object Sheet
		    XSSFSheet worksheet = workbook.getSheet("NonVegPizza");

		    for (int row = 1; row <= worksheet.getLastRowNum(); row++) {

		      String key = worksheet.getRow(row).getCell(0).getStringCellValue();
		      DataFormatter df = new DataFormatter();
		      String value = df.formatCellValue(worksheet.getRow(row).getCell(1));

		      map.put(key, value);
		    }
		    return map;  
  }
  public Map<String, String> getTestDataForNonVegWithBeverageFromExcel() throws FileNotFoundException {
	  FileInputStream file = new FileInputStream(
		        System.getProperty("user.dir") + "\\src\\main\\java\\TestData\\Domino's Pizza Order.xlsx");

		    Map<String, String> map = new HashMap<String, String>();

		    // Created object of Workbook
		    XSSFWorkbook workbook = null;
		    try {
		      workbook = new XSSFWorkbook(file);
		    } catch (IOException e1) {
		      e1.printStackTrace();
		    }

		    // Created object Sheet
		    XSSFSheet worksheet = workbook.getSheet("NonVeg_WithBeverage");

		    for (int row = 1; row <= worksheet.getLastRowNum(); row++) {

		      String key = worksheet.getRow(row).getCell(0).getStringCellValue();
		      DataFormatter df = new DataFormatter();
		      String value = df.formatCellValue(worksheet.getRow(row).getCell(1));

		      map.put(key, value);
		    }
		    return map;  
  }
  
  public Map<String, String> getTestDataFromExcelSheet(String sheet) throws Throwable  {
	    FileInputStream file = new FileInputStream(
	        System.getProperty("user.dir") + "\\src\\main\\java\\TestData\\Domino's Pizza Order.xlsx");

	    Map<String, String> map = new HashMap<String, String>();

	    // Created object of Workbook
	    XSSFWorkbook workbook = null;
	    try {
	      workbook = new XSSFWorkbook(file);
	    } catch (IOException e1) {
	      e1.printStackTrace();
	    }

	    // Created object Sheet
	    XSSFSheet worksheet = workbook.getSheet(sheet);

	    for (int row = 1; row <= worksheet.getLastRowNum(); row++) {

	      String key = worksheet.getRow(row).getCell(0).getStringCellValue();
	      DataFormatter df = new DataFormatter();
	      String value = df.formatCellValue(worksheet.getRow(row).getCell(1));

	      map.put(key, value);
	    }
	    return map;
	  }
 
  
  
  
  

  public Map<String, String> getTestDataFromExcel(String sheetName) {
    HashMap<String, String> objDataProvider = null;
    try {
      sheet = workbook.getSheet(sheetName);
      headerRow = sheet.getRow(0);
      testDataRow = sheet.getRow(0);
      int rowIndex = 0;
      objDataProvider = new HashMap<>();
      headerRow = sheet.getRow(rowIndex);
      testDataRow = sheet.getRow(rowIndex + 1);
      int clmNo = 0;
      do {
        String header = "";
        String testData = "";
        header = headerRow.getCell(clmNo).toString().trim();
        if (testDataRow.getCell(clmNo) == null || testDataRow.getCell(clmNo).toString().isEmpty()) {
          testData = "";
        } else {
          testData = testDataRow.getCell(clmNo).toString().trim();
        }
        if (!header.equals("")) {
          objDataProvider.put(header, testData);
        }
        clmNo++;
      } while (clmNo < headerRow.getLastCellNum());
      fis.close();
    } catch (Exception exception) {
      System.out.print(exception.getMessage());
    }
    return objDataProvider;
  }

  public Map<String, Map<String, String>> getTestDataFromExcel(String sheetName, int rowNum) {
    HashMap<String, String> objDataProvider = null;
    Map<String, Map<String, String>> listOfProducts = new HashMap<>();
    try {
      sheet = workbook.getSheet(sheetName);
      headerRow = sheet.getRow(0);
      testDataRow = sheet.getRow(0);
      int rowIndex = 0;
      headerRow = sheet.getRow(rowIndex);
      for (int i = 1; i <= rowNum; i++) {
        objDataProvider = new HashMap<>();
        testDataRow = sheet.getRow(i);
        int clmNo = 0;
        do {
          String header = "";
          String testData = "";
          header = headerRow.getCell(clmNo).toString().trim();
          if (testDataRow.getCell(clmNo) == null
              || testDataRow.getCell(clmNo).toString().isEmpty()) {
            testData = "";
          } else {
            testData = testDataRow.getCell(clmNo).toString().trim();
          }
          if (!header.equals("")) {
            objDataProvider.put(header, testData);
          }
          clmNo++;
        } while (clmNo < headerRow.getLastCellNum());
        if (objDataProvider != null) {
          listOfProducts.put(Integer.toString(i), objDataProvider);
        }
      }
    } catch (Exception e) {
      System.out.print(e.getMessage());
    } finally {
      try {
        fis.close();
      } catch (IOException e) {
        System.out.print(e.getMessage());
      }
    }
    return listOfProducts;
  }
}

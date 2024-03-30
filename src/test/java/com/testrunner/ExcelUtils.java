package com.testrunner;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.collections4.map.HashedMap;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtils {


	Map<String, String> excelTestData;
	String productName, quantity = "";

	public static void main(String [] args) throws Throwable {
		
		
		String PRODUCT_ADDTOCART_PLACEHOLDER =
			      "//span[text()='%s']/parent::div/following-sibling::div/descendant::button[@data-label='addTocart']";

//		String data = ExcelUtils.testDataPercellPerRow(1, 1);
//		String[] allPizzaType = data.split(",");
//
//		for(String pizza:allPizzaType) {
//			System.out.println(pizza);
		System.out.println("changes made by github repository");
//
//		}


		ExcelUtils excelutil=new ExcelUtils();
		Map<String, String> excelTestData = new HashedMap<>();
		
		String productName, quantity = "";

		// putting the values in Map 
		excelTestData = excelutil.getTestDataAsPerRow();
		
		
		for (var entry : excelTestData.entrySet()) {
			//System.out.println(entry.getKey() + " : " + entry.getValue());
			productName = entry.getKey();
			quantity = entry.getValue();

			System.out.println(productName);
			System.out.println(quantity);

			System.out.println(String.format(PRODUCT_ADDTOCART_PLACEHOLDER, productName));
			
			//		      menuPage.addProductToTheCart(productName, Integer.parseInt(quantity));
			//		      menuPage.verifyTotalAmountOfProductInTheCart(productName);
		}







	}
	public static String testDataPercellPerRow(int rowIndex, int cellIndex) throws Throwable {
		FileInputStream file=new FileInputStream("C:\\java Vijay\\QE-Project\\QEA-Integration-Tests\\src\\main\\java\\TestData\\Domino's Pizza Order.xlsx");
		Sheet worksheet = WorkbookFactory.create(file).getSheet("Domino's");
		String testData = worksheet.getRow(rowIndex).getCell(cellIndex).getStringCellValue();
		return testData;

	}

	
	
	
	
	
	
		
public Map<String, String> getTestDataAsPerRow() throws Throwable {
	
	    Map<String, String> map = new HashMap<String, String>();
		FileInputStream file=new FileInputStream("C:\\java Vijay\\QE-Project\\QEA-Integration-Tests\\src\\main\\java\\TestData\\Domino's Pizza Order.xlsx");
		Sheet worksheet = WorkbookFactory.create(file).getSheet("Domino's");
		//String testData = worksheet.getRow(rowIndex).getCell(cellIndex).getStringCellValue();

		for (int row = 1; row <= worksheet.getLastRowNum(); row++) {

		      String key = worksheet.getRow(row).getCell(0).getStringCellValue();

		      DataFormatter df = new DataFormatter();
		      String value = df.formatCellValue(worksheet.getRow(row).getCell(1));

		      map.put(key, value);
		    }
		    return map;
		  }

}

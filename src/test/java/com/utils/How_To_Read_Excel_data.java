package com.utils;

import java.util.Map;

import com.testrunner.ExcelUtils;





public class How_To_Read_Excel_data {
	 public Map<String, String> testdata1;
	 
	  public static void main(String[] args) throws Throwable {
      ExcelReader excel=new ExcelReader();
		    String productName;
		    String productQuantity;
		    Map<String, String> testdata1;
		    
		     testdata1 = excel.getTestDataFromExcel();
		     
		   for(var data:testdata1.entrySet()) {
		     
		     productName=data.getKey();
		     productQuantity=data.getValue();
		     System.out.println(productName);
		    System.out.println(productQuantity);
		   }

	   
}
}
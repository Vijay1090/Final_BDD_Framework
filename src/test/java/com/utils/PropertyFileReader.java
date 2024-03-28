package com.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileReader {

	Properties properties = new Properties();
	FileInputStream fileInputStream = null;

	public PropertyFileReader(String fileName) {
		try {
			// Provide the path to your properties file
			fileInputStream = new FileInputStream(fileName);
			// Load properties file
			properties.load(fileInputStream);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fileInputStream != null) {
				try {
					fileInputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public PropertyFileReader() {
		try {
			// Provide the path to your properties file
			fileInputStream = new FileInputStream(
					"IntegrationTests.properties");
			// Load properties file
			properties.load(fileInputStream);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fileInputStream != null) {
				try {
					fileInputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public String getProperty(String key) {
		return properties.getProperty(key);
	}

//	public static void main(String[] args) {
//
//		PropertyFileReader fileReader = new PropertyFileReader();
//		String myValue = fileReader.getProperty("user.name");
//		System.out.println(myValue);
//
//		PropertyFileReader fileReader2 = new PropertyFileReader(
//				"Test.properties");
//		String myValue2 = fileReader2.getProperty("my.key");
//		System.out.println(myValue2);
//	}

}

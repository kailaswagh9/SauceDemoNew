package com.saucedemo.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ReadConfig {

	Properties prop;

	String path = "C:\\Users\\Admin\\eclipse-workspace\\Saucedemo\\Configuration\\config.properties";
	//construction
	public ReadConfig() { 

		try {
			prop = new Properties();
			FileInputStream fis = new FileInputStream(path);
			prop.load(fis);
		} catch (Exception e) {
			
			e.printStackTrace();
		}

	}
	public String getBaseUrl() {
		String value = prop.getProperty("baseUrl");		
		if(value!=null) {
			return  value;
		}else {
			throw new RuntimeException("url not specied in config file");
		}
	}
	public String getKWUrl() {
		String value = prop.getProperty("kwurl");
		if(value!=null)
			return value;
		else {
			throw new RuntimeException("kwurl is not specified in config file");
		}
	}
	
	public String getBrowser() {
		String value = prop.getProperty("browser");
		if(value!=null)
			return value;
		else {
			throw new RuntimeException("brower is not specified in config file");
		}
	}
	
	public static void main(String[] args) {
		System.out.println(System.getProperty("os.name"));
		 System.out.println(System.getProperty("java.version")); 
		
	}
}

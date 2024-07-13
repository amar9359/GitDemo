package com.technocredits.orghrm.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropOperations {
	
	private Properties prop;
	
	public PropOperations(String filePath) throws IOException {
		File file = new File(filePath);
		FileInputStream inputStream = new FileInputStream(file);
		prop = new Properties();
		prop.load(inputStream);  
	}
	
	public String getValue(String key) {
		return prop.getProperty(key);
	}

}

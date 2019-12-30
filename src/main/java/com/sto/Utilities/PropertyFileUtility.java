package com.sto.Utilities;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;

import java.util.Properties;

public class PropertyFileUtility {
	
	
	public static String getValueForKey(String key) throws IOException {
	
	Properties prop=new Properties();

	prop.load(new FileInputStream(new File(".\\Properties File\\Environment.properties")));
	
		return prop.getProperty(key);
	}
	
	}
	
	
		
	
	


	


package com.config;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.testng.annotations.Test;



public class ConfigTest {
	
	@Test
	public void testconfig() throws Exception{
		
		File src=new File("./Configuration/config.property");
		FileInputStream fis=new FileInputStream(src);
		
		Properties pro=new Properties();
		pro.load(fis);
		
		String url=pro.getProperty("url");
		System.out.println(url);
		
	}

}

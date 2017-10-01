package com.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	Properties pro;

	public ReadConfig() {

		try {
			File src = new File("./Configuration/config.property");
			FileInputStream fis = new FileInputStream(src);

			pro = new Properties();
			pro.load(fis);
		} catch (Exception e) {

			e.printStackTrace();

		}
	}

	public String getChromedriver() {

		String chromedrivePath = pro.getProperty("chromedriver");
		return chromedrivePath;

	}

	public String applicationurl() {

		return pro.getProperty("url");

	}

	public String getIEdriver() {
		return pro.getProperty("IEdriver");
	}
}

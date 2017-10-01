package com.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

import com.utilities.ReadConfig;

public class LaunchIE {

	@Test
	public void LaunchingIE() {

		ReadConfig config = new ReadConfig();

		System.setProperty("webdriver.ie.driver", config.getIEdriver());
		WebDriver driver = new InternetExplorerDriver();
		driver.manage().window().maximize();
		driver.get(config.applicationurl());
		driver.quit();

	}

}

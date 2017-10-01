package com.test;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.utilities.ReadConfig;

public class LaunchChromewithLogFile {
	ReadConfig config;

	Logger log = Logger.getLogger("LaunchChromewithLogFile");

	@BeforeTest
	public void setup() {

		config = new ReadConfig();

		System.setProperty("webdriver.chrome.driver", config.getChromedriver());

	}

	@Test
	public void LaunchingChrome() {

		PropertyConfigurator.configure("Log4j.properties");

		WebDriver driver = new ChromeDriver();

		log.info("Webdriver instance is created");

		driver.manage().window().maximize();

		log.info("Browser is maximized");

		driver.get(config.applicationurl());

		log.info("Application is launched");

		driver.quit();
		
		log.info("Webdriver is quited");
	}

}

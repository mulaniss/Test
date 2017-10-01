package com.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.utilities.ReadConfig;

public class LaunchChrome {
	ReadConfig config;

	@BeforeTest
	public void setup() {

		config = new ReadConfig();

		System.setProperty("webdriver.chrome.driver", config.getChromedriver());

	}

	@Test
	public void LaunchingChrome() {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(config.applicationurl());
		driver.quit();

	}

}

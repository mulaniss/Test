package com.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.utilities.ExcelDataConfig;

public class DataDriven {

	@Test(dataProvider = "Wordpress")
	public void Login(String username, String password) {

		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://wordpress.com/wp-login.php");

		driver.findElement(By.id("user_login")).sendKeys(username);
		driver.findElement(By.id("user_pass")).sendKeys(password);
		driver.findElement(By.id("wp-submit")).click();
		
		driver.quit();
	}

	@DataProvider(name = "Wordpress")
	public Object[][] passData() {
		ExcelDataConfig config = new ExcelDataConfig();
		int rows = config.rowCount("Test");

		Object[][] data = new Object[rows][2];

		for (int i = 0; i < rows; i++) {

			data[i][0]=config.getData("Test", i, 0);
			data[i][1]=config.getData("Test", i, 1);
		}

		return data;

	}

}

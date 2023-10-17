package com.qa.appiumproject;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public class MobileBrowserTest extends BrowserBaseClass{
	
	@Test
	private void browseTest() throws MalformedURLException {
		configureAppium();
		driver.get("https://www.google.co.in/");
		System.out.println(driver.getTitle());
		driver.findElement(By.name("q")).sendKeys("Sujai Sekar");
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
	}

}

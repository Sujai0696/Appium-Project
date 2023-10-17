package com.qa.appiumproject;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class eCommerce_tc_3 extends BaseClass{


	@Test
	public void fillForm() throws MalformedURLException, InterruptedException {

		configureAppium();

		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Sujai Sekar");

		driver.hideKeyboard();

		driver.findElement(By.id("com.androidsample.generalstore:id/radioFemale")).click();

		driver.findElement(By.id("android:id/text1")).click();

		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));"));

		driver.findElement(By.xpath("//android.widget.TextView[@text='Argentina']")).click();

		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();

		//		Thread.sleep(5000);
		driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click();

		driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click();

		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();

		Thread.sleep(3000);

		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.attributeContains(driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")), "text", "Cart"));


		List<WebElement> productPrice = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice"));
		int count = productPrice.size();
		double totalsum = 0;




		for (int i = 0; i < count; i++) {

			String amountString = productPrice.get(i).getText();

			Double price = Double.parseDouble(amountString.substring(1));

			totalsum = totalsum + price;

		}

		String displaySum = driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
		Double formattedAmount = Double.parseDouble(displaySum.substring(1));
		Assert.assertEquals(totalsum, formattedAmount);

		WebElement ele = driver.findElement(By.id("com.androidsample.generalstore:id/termsButton"));

		longPressAction(ele);

		driver.findElement(By.id("android:id/button1")).click();

		driver.findElement(AppiumBy.className("android.widget.CheckBox")).click();

		driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();

	}



}

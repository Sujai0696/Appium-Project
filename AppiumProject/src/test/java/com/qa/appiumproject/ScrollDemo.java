package com.qa.appiumproject;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class ScrollDemo {
	
	@Test
	private void scrollDemoTest() throws MalformedURLException, InterruptedException{
		
		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName("Sujaiemulator");
		options.setApp("\\Users\\sujsekar\\eclipse-workspace\\AppiumProject\\src\\test\\java\\resources\\ApiDemos-debug.apk");
		
		AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		
		//1st method of scrolling using google engine. Where to scroll in prior
//		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"));"));
		
		
		
//		WebElement ele = driver.findElement(By.xpath("//android.widget.TextView[@content-desc='WebView']"));
//		
//		((JavascriptExecutor)driver).executeScript("mobile: scrollGesture", 
//				ImmutableMap.of("elementId",((RemoteWebElement)ele).getId(),
//						"duration",2000));
		
		
		
		
		
		// No Prior Idea
		boolean canScrollMore;
		do
		{
		
		 canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
		    "left", 100, "top", 100, "width", 200, "height", 200,
		    "direction", "down",
		    "percent", 3.0
		));
		 
		}while(canScrollMore);
		
		
		
//		 WebElement ele = driver.findElement(By.xpath("//android.widget.TextView[@content-desc='WebView']"));
//		 
//		
//		
//		 ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", ele);
//		
		
		
		
		
	}

}

package com.qa.appiumproject;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import com.google.common.collect.ImmutableMap;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class BaseClass {
	
	public static AndroidDriver driver;
	
	public static WebDriver dri;
	
	public static void configureAppium() throws MalformedURLException {
		
		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName("Sujaiemulator");
		options.setChromedriverExecutable("C:\\Users\\sujsekar\\git\\Appium-Project\\AppiumProject\\Drivers\\chromedriver.exe");
		options.setApp("C:\\Users\\sujsekar\\git\\Appium-Project\\AppiumProject\\src\\test\\java\\resources\\General-Store.apk");
		

		 driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

	}
	
	
	public static Double getFormattedAmount(String amount) {
		Double price = Double.parseDouble(amount.substring(1));
		return price;
	}
	
	public static void longPressAction(WebElement ele) {
		try {
			((JavascriptExecutor)driver).executeScript("mobile: longClickGesture", 
					ImmutableMap.of("elementId",((RemoteWebElement)ele).getId(),
							"duration",2000));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

}

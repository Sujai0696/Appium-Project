package com.qa.appiumproject;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class BrowserBaseClass {
	
	public static AndroidDriver driver;
	
	
	public static void configureAppium() throws MalformedURLException {
		
		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName("Pixel2Emulator");
		options.setChromedriverExecutable("C:\\Users\\sujsekar\\git\\Appium-Project\\AppiumProject\\Drivers\\chromedriver.exe");
		options.setCapability("browserName", "Chrome");
		 driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

	}
	
	
	public static Double getFormattedAmount(String amount) {
		Double price = Double.parseDouble(amount.substring(1));
		return price;
	}
	
	
	

}

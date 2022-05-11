package com.ba.guru.factory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Driverfactory {

	public WebDriver driver;
	
	/**
	 * this method used to initialize the driver
	 * @param browserName
	 * @return
	 */
	
	public WebDriver initDriver(Properties prop) {
		
		String browserName = prop.getProperty("browser"); 
		System.out.println("browser name is :" + browserName);
		
		if(browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver =new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver =new FirefoxDriver();
		}
		else {
			System.out.println("please pass the right browser name"+browserName);
		}
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url")); 

		
		return driver;
	}
	
	public Properties intiProperties() {  
		Properties prop =null; 
		
		try {
			FileInputStream ip =new FileInputStream("./src/test/resources/config/config.properties");
			prop =new Properties();
			prop.load(ip); 
		} 
		
		
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
		
 catch (IOException e) {
			e.printStackTrace();
		}
		
		return prop;
	}
}

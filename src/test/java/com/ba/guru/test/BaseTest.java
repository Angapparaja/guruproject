package com.ba.guru.test;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;


import com.ba.guru.factory.Driverfactory;
import com.ba.guru.pages.Loginpage;
import com.ba.guru.pages.Quotationpage;
import com.ba.guru.pages.Registerpage;
import com.ba.guru.pages.RetriveQuotationpage;



public class BaseTest {
	WebDriver driver;
	Driverfactory df;
	Properties prop;
	Registerpage register;
	Loginpage login;
	Quotationpage quotation;
	RetriveQuotationpage retrive;
	
	@BeforeTest
	public void setUp() { 
		df = new Driverfactory();
		prop = df.intiProperties(); 
		
		driver = df.initDriver(prop); 
		register = new Registerpage(driver);
		
	}
	
	@AfterTest
	public void tearDown() {
		//driver.quit(); 
	}
}

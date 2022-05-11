package com.ba.guru.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


import com.ba.guru.Utils.ElementUtil;



public class Loginpage {
	private WebDriver driver;
	private ElementUtil elementutil;
	
	private By enterEmailId=By.id("email");
	private By enterPassword=By.id("password");
	
	private By enterLoginbtn=By.xpath("//input[@name='submit'][@value='Log in']");
	
	public Loginpage(WebDriver driver) {
		this.driver=driver;
		elementutil=new ElementUtil(driver);
	}
	
	
	public Quotationpage enterEmailid(String email,String password) {
		elementutil.doSendkeys(enterEmailId, email);
		elementutil.doSendkeys(enterPassword, password);
		return new Quotationpage(driver); 
	}
	
	public Quotationpage enterSubmitbtn() {
		elementutil.doClick(enterLoginbtn);
		return new Quotationpage(driver); 
	}
}

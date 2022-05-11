package com.ba.guru.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ba.guru.Utils.ElementUtil;

public class RetriveQuotationpage {

private WebDriver driver;
	private ElementUtil elementutil;
	
//	private By  clickQuotation = By.id("retrieve");
	
	public RetriveQuotationpage(WebDriver driver) {
		this.driver=driver;
		elementutil =new ElementUtil(driver);
	}
	
	
	
}

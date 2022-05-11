package com.ba.guru.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;


import com.ba.guru.Utils.ElementUtil;

public class Registerpage {

private WebDriver driver;
	
	private ElementUtil elementutil;
	
	private By  enterRegisterName = By.xpath("//a[text()='Register']");
	private By  enterTitle = By.xpath("//select[@id='user_title']");
	private By  enterFirstName = By.id("user_firstname");
	private By  enterSurName = By.id("user_surname");
	private By  enterPhoneName = By.id("user_phone");
	private By  enteryear = By.id("user_dateofbirth_1i");
	private By  enterMonth = By.id("user_dateofbirth_2i");
	private By  enterDate = By.id("user_dateofbirth_3i");
	private By  enterRadiobutton =By.xpath("//input[@id='licencetype_f']");
	private By enterLicenese =By.xpath("//select[@id='user_licenceperiod']");
	private By enterOccupation=By.xpath("//select[@id='user_occupation_id']");
	private By enterAddress=By.id("user_address_attributes_street");
	private By enterCity =By.id("user_address_attributes_city");
	private By enterCountry=By.id("user_address_attributes_county");
	private By enterPasscode=By.id("user_address_attributes_postcode");
	private By enterEmail =By.id("user_user_detail_attributes_email");
	private By enterPassword =By.id("user_user_detail_attributes_password");
	private By enterconfirmspassword =By.id("user_user_detail_attributes_password_confirmation");
	private By enterSubmitbtn =By.xpath("//input[@name='submit']");
	
	public Registerpage(WebDriver driver) {
		this.driver=driver;
		elementutil =new ElementUtil(driver);
	}
	
	public Loginpage doRegister() {
		elementutil.doClick(enterRegisterName);	
		return new Loginpage(driver); 
	}
	public Loginpage doEnterTitle(String firstname,String Surname) {
		Select dropdown = new Select(elementutil.getElement(enterTitle));
		dropdown.selectByVisibleText("Captain");
		elementutil.doSendkeys(enterFirstName, firstname);
		elementutil.doSendkeys(enterSurName, Surname);
		return new Loginpage(driver); 
	}
	
	public Loginpage doPhoneno(String phoneno) {
		elementutil.doSendkeys(enterPhoneName,phoneno);
		return new Loginpage(driver);
	}
	
	public Loginpage dodateofbirth() {
		Select year = new Select(elementutil.getElement(enteryear));
		year.selectByVisibleText("1995");
		Select Month = new Select(elementutil.getElement(enterMonth));
		Month.selectByVisibleText("May");
		Select Date = new Select(elementutil.getElement(enterDate));
		Date.selectByVisibleText("25");
		return new Loginpage(driver);
	}
	public Loginpage doRadiobtn() {
		Boolean doDisplay=elementutil.isSelected(enterRadiobutton);
		if(doDisplay == false) {
		elementutil.doClick(enterRadiobutton);
		
		}
		return new Loginpage(driver);
	}
	public Loginpage doEnterLicense() {
		Select licenceyear = new Select(elementutil.getElement(enterLicenese));
		licenceyear.selectByVisibleText("3");
		return new Loginpage(driver);
	}
	public Loginpage doEnterOccupation() {
		Select Occupation = new Select(elementutil.getElement(enterOccupation));
		Occupation.selectByVisibleText("Writer");
		return new Loginpage(driver);
}
	
	public Loginpage doEnterDetails(String Address,String City,String country,String passcode) {
		elementutil.doSendkeys(enterAddress, Address);
		elementutil.doSendkeys(enterCity, City);
		elementutil.doSendkeys(enterCountry, country);
		elementutil.doSendkeys(enterPasscode, passcode);
		return new Loginpage(driver);
	}
	
	public Loginpage doEnterEmaildetails(String email,String password,String enterconfirmpassword) {
		elementutil.doSendkeys(enterEmail, email);
		elementutil.doSendkeys(enterPassword, password);
		elementutil.doSendkeys(enterconfirmspassword, enterconfirmpassword);	
		return new Loginpage(driver);
	}
	public Loginpage doSubmit() {
		elementutil.doClick(enterSubmitbtn);
		return new Loginpage(driver); 
	}
}

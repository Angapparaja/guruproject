package com.ba.guru.test;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginpageTest extends BaseTest{

	@BeforeClass
	public void Loginpagesetup() {
		login = register.doRegister();
		login=register.doEnterTitle(prop.getProperty("FirstName").trim(),prop.getProperty("SurName").trim());
		login=register.doPhoneno(prop.getProperty("Phoneno").trim());
		login=register.dodateofbirth();
		login=register.doRadiobtn();
		login=register.doEnterLicense();
		login=register.doEnterOccupation();
		login=register.doEnterDetails(prop.getProperty("Address").trim(), prop.getProperty("city").trim(), prop.getProperty("country").trim(), prop.getProperty("passcode").trim());
		login=register.doEnterEmaildetails(prop.getProperty("email").trim(),prop.getProperty("password").trim(), prop.getProperty("Confrimpassword").trim());
		login=register.doSubmit();
		
	}
	@Test(priority=1)
	public void loginDetails() {
		login.enterEmailid(prop.getProperty("email").trim(), prop.getProperty("password").trim());
	}
	
	@Test(priority=2)
	public void LoginSumbit() {
		login.enterSubmitbtn();
	}
	
}

package com.ba.guru.test;

import org.testng.annotations.Test;

public class RegisterpageTest extends BaseTest {

	@Test(priority=1)
    public void registerpagebtn() {
		register.doRegister();
	}
	
	@Test(priority=2)
	public void EnterTilte() {
		register.doEnterTitle(prop.getProperty("FirstName").trim(),prop.getProperty("SurName").trim());
	}
	@Test(priority=3)
	public void EnterPhoneno() {
		register.doPhoneno(prop.getProperty("Phoneno").trim());
	}
	
	@Test(priority=4)
	public void EnterDateofBirth() {
		register.dodateofbirth();
	}
	
	@Test(priority=5)
	public void EnterRadiobtn() {
		register.doRadiobtn();
	}
	
	@Test(priority=6)
	public void EnterLicense() {
		register.doEnterLicense();
	}
	@Test(priority=7)
	public void EnterOccupation() {
		register.doEnterOccupation();
	}
	
	@Test(priority=8)
	public void EnterDetails() {
		register.doEnterDetails(prop.getProperty("Address").trim(), prop.getProperty("city").trim(), prop.getProperty("country").trim(), prop.getProperty("passcode").trim());
	}
	@Test(priority=9)
	public void EnterEmailAdress() {
		register.doEnterEmaildetails(prop.getProperty("email").trim(),prop.getProperty("password").trim(), prop.getProperty("Confrimpassword").trim());
	}
	@Test(priority=10)
	public void Entersubmitbtn() {
		register.doSubmit();
	}
}

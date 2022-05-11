package com.ba.guru.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.ba.guru.Utils.Constants;
import com.ba.guru.Utils.ErrorUtil;

public class QuotationpageTest extends BaseTest{

	@BeforeClass
	public void Quationpagesetup() {
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
		quotation=login.enterEmailid(prop.getProperty("email").trim(), prop.getProperty("password").trim());
		quotation=login.enterSubmitbtn();
		
	}
	
	@Test(priority=1)
	public void clickQuationtion() {
		quotation.doQuotationpage();
	}
	@Test(priority=2)
	public void enterBreakCover() {
		quotation.entertheBreakCover();
	}
	@Test(priority=3)
	public void enterWindScreenCover() {
		quotation.enterWindScreenrepair();
	}
	
	@Test(priority=4)
	public void entervehicledetail() {
		quotation.enterVehicleDetails(prop.getProperty("incidents").trim(), prop.getProperty("vehicleRegistration").trim(), prop.getProperty("mileage").trim(), prop.getProperty("estimatevalue").trim());
	}
	
	@Test(priority=5)
	public void enterParkingLocation() {
		quotation.enterTheParkingLocation();
	}
	
	@Test(priority=6)
	public void enterStartofpolicy() {
		quotation.enterStartofPolicy();
	}

	
	@Test(priority=7)
	public void checkamount() {
		quotation.checkAmount(prop.getProperty("amountcheck").trim());
		String amount=prop.getProperty("amountcheck").trim();
		Assert.assertEquals(amount, Constants.Amount_Title,ErrorUtil.Error_amount_display_Message);
	}
	
	@Test(priority=8)
	public void ClickSaveQuotation() {
		quotation.ClickSaveQuotation();
		
	}
	
	@Test(priority=9)
	public void getQuationpageUrl() throws InterruptedException {
		quotation.getQuotationpage();
//		quotation.Quatationnumber();
		quotation.navigateback();
	}
	
	@Test(priority=10)
	public void getRetrivebtn() throws InterruptedException {
		quotation.doQuotationpageRetrive();
	}
	@Test(priority=11)
	public void ClickRetrivebtn() throws InterruptedException {
		quotation.ClickQuotationpageRetrive();
	}
}

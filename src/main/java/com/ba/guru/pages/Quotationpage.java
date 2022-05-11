package com.ba.guru.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ba.guru.Utils.Constants;
import com.ba.guru.Utils.ElementUtil;

public class Quotationpage {

private WebDriver driver;
	
	private ElementUtil elementutil;
	
	private By  enterQuotation = By.xpath("//a[text()='Request Quotation']");
	private By enterBreakdownCover=By.xpath("//select[@id='quotation_breakdowncover']");
	private By enterWindScreenRepair=By.xpath("//input[@id='quotation_windscreenrepair_t']");
	private By enterIncedent =By.id("quotation_incidents");
	private By entervehicleRegistration=By.id("quotation_vehicle_attributes_registration");
	private By entermileage=By.id("quotation_vehicle_attributes_mileage");
	private By enterEstimatevalue=By.id("quotation_vehicle_attributes_value");
	private By enterParkingLocation=By.xpath("//select[@id='quotation_vehicle_attributes_parkinglocation']");
	private By enterYear =By.xpath("//select[@id='quotation_vehicle_attributes_policystart_1i']");
	private By enterMonth =By.xpath("//select[@id='quotation_vehicle_attributes_policystart_2i']");
	private By enterDate =By.xpath("//select[@id='quotation_vehicle_attributes_policystart_3i']");
	private By clickCalculate=By.xpath("//input[@value='Calculate Premium']");
	private By checkcondition=By.xpath("//p[@id='calculatedpremium'][text()]");
	private By clickSaveBtn =By.xpath("//input[@Type='submit'][@value='Save Quotation']");
	private By quotationNo=By.xpath("/html/body/text()");
	private By  clickQuotation = By.id("retrieve");
	private By ClickQuotationpageRetrive =By.id("getquote");
	private By enterId=By.xpath("//input[@placeholder='identification number']");
	
	
	public Quotationpage(WebDriver driver) {
		this.driver=driver;
		elementutil =new ElementUtil(driver);
	}
	
	public void doQuotationpage() {
		elementutil.doClick(enterQuotation);		 
	}
	public void entertheBreakCover() {
		Select selectvalue = new Select(elementutil.getElement(enterBreakdownCover));
		selectvalue.selectByVisibleText("At home");
	}
	public void enterWindScreenrepair() {
		Boolean doDisplay=elementutil.isSelected(enterWindScreenRepair);
		if(doDisplay == false) {
		elementutil.doClick(enterWindScreenRepair);
		}
	}
	
	public void enterVehicleDetails(String incidents,String vehicleRegistration,String mileage,String estimatevalue) {
		elementutil.doSendkeys(enterIncedent, incidents);
		elementutil.doSendkeys(entervehicleRegistration, vehicleRegistration);
		elementutil.doSendkeys(entermileage, mileage);
		elementutil.doSendkeys(enterEstimatevalue, estimatevalue);
		
	}
	public void enterTheParkingLocation() {
		Select selectvalue = new Select(elementutil.getElement(enterParkingLocation));
		selectvalue.selectByVisibleText("Public Place");
	}
	public void enterStartofPolicy() {
		Select selectYear = new Select(elementutil.getElement(enterYear));
		selectYear.selectByVisibleText("2022");
		Select selectMonth = new Select(elementutil.getElement(enterMonth));
		selectMonth.selectByVisibleText("May");
		Select selectDate = new Select(elementutil.getElement(enterDate));
		selectDate.selectByVisibleText("22");
		elementutil.doClick(clickCalculate);
	}
//	public String waitForPremiumamountIs(String Amount,int timeOut) { 
//		WebDriverWait wait =new WebDriverWait(driver,timeOut); 
//		if(wait.until(ExpectedConditions.textToBe(checkcondition,"No discount Premium: £48"))) { 
////			String value= driver.findElement(checkcondition).getText();	
////			System.out.println("value"+value);
//		}
//		return null;
//	}
	
	public void checkAmount(String amount) {
		String amounts = elementutil.doGettext(checkcondition);
		System.out.println("amount is"+amounts);
		
	}
	
	public void ClickSaveQuotation() {
		elementutil.doClick(clickSaveBtn);
	}
	
	public String getQuotationpage() {
		String QuatationpageUrl= elementutil.waitForUrlContains(Constants.Quotation_Page_Url, 5);
		System.out.println("Quatation page Url is :"+QuatationpageUrl);
		return QuatationpageUrl;
	}

	
	
//	public void Quatationnumber() {
//     	String number = elementutil.doGettext(quotationNo);
//		System.out.println("Quatation number is"+number);
//	}
	
	
	public void navigateback() throws InterruptedException {
		Thread.sleep(100);
		driver.navigate().back();
	}
	public void doQuotationpageRetrive() throws InterruptedException {
		elementutil.doClick(clickQuotation);
		Thread.sleep(1000);
		String[] values = {"10025", "10026"};
		for (int i = 0; i == values.length-2; i++) {
			
			elementutil.doSendkeys(enterId, values[i]);
			
			}
//		 int index = 0;
//	        while (index < values.length) {
//	            System.out.println(values[index]);
//	            break;
//	            
//	        }
//	        index++;
		Thread.sleep(3000);
		
	}
	
	public void ClickQuotationpageRetrive() throws InterruptedException {
		elementutil.doClick(ClickQuotationpageRetrive);
		System.out.println("currentpage Title is :" +driver.getTitle());
		
	}
	
	
	
	
	
}

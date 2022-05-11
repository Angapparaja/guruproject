package com.ba.guru.Utils;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtil {

private WebDriver driver;
	
	public ElementUtil(WebDriver driver) { 
		this.driver=driver; 
	}
	
	public WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	public WebElement getElemented(WebElement locator) {
		return driver.findElement((By) locator);
	}
	public  List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}
	public void doSendkeys(By locator,String value) {
		WebElement ele= getElement(locator);
		ele.clear();
		ele.sendKeys(value);
	}

	
	public void doSendkeyss(By locator,String value1,String value2,String value3) {
		WebElement ele= getElement(locator);
		ele.clear();
		ele.sendKeys(value1+value2+value3);
	}
	public void doSendkey(By locator) {
		getElement(locator).sendKeys(Keys.ENTER);
	}
	
	public  String doGettext(By locator) {
		return getElement(locator).getText(); 
	}
	
	public  void doClick(By locator) {
		getElement(locator).click();
	}
	public  String doGetAttribute(By locator,String attrname) { 
		return getElement(locator).getAttribute(attrname);
		}
	public boolean doDisplayed(By locator) {
		return getElement(locator).isDisplayed();
	}
	
	public boolean isSelected(By locator) {
		return getElement(locator).isSelected();
	}
	public boolean doEnable(By locator) {
		return getElement(locator).isEnabled();
	}
	public void clickOnElement(By locator,String value) {
		List<WebElement>eleList=getElements(locator);
		System.out.println(eleList.size());
		for(WebElement e:eleList) {
			if(e.getText().equals(value)) {
				e.click();
				break;
			}
		}
	}
	
	public  List<String> getLinksTextList(By locator) {
		List<String> eleTextList =new ArrayList<String>();
		List<WebElement> elelist= getElements(locator);
		System.out.println("element count :"+elelist.size());
		
		for(WebElement e:elelist) {
			String text =e.getText();
			if(!text.isEmpty()) {
				eleTextList.add(text);
			}
		}
		return eleTextList;
	}

	
	public  boolean isElementsExits(By locator) {
		List<WebElement>listEle =getElements(locator);
		if(listEle.size()>0) {
			System.out.println("elements is present");
			return true;
		}
		
		System.out.println("element is not present");
		return false;
	}
	
	public void getDropdownOptionsList(By locator, int value) {
		Select select = new Select(getElement(locator));
		List<WebElement> optionsList = select.getOptions();
		System.out.println(optionsList.size());

		for (WebElement e : optionsList) {
			String text = e.getText();
			System.out.println(text);
			if (value == 5) {
				e.click();
				break;
			}
		}

	}
	
	public String waitForTitleContains(String titleValue,int timeOut) {
		WebDriverWait wait =new WebDriverWait(driver,timeOut);
		if(wait.until(ExpectedConditions.titleContains(titleValue))) {
			return driver.getTitle();
		}
		return null;
	}
	
	public String waitForTitleIs(String fullTitle,int timeOut) { 
		WebDriverWait wait =new WebDriverWait(driver,timeOut); 
		if(wait.until(ExpectedConditions.titleIs(fullTitle))) { 
			return driver.getTitle();	
		}
		return null;
	}

	public String waitForUrlContains(String urlFraction,int timeOut) {
		WebDriverWait wait =new WebDriverWait(driver,timeOut);
		if(wait.until(ExpectedConditions.urlContains(urlFraction))) {
			return driver.getCurrentUrl();
		}
		return null;
	}
	
	public String waitForFullUrl(String urlValue,int timeOut) {
		WebDriverWait wait =new WebDriverWait(driver,timeOut);
		if(wait.until(ExpectedConditions.urlToBe(urlValue))) {
			return driver.getCurrentUrl();
		}
		return null;
	}
	
}

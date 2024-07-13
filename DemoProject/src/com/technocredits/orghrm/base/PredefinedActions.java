package com.technocredits.orghrm.base;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PredefinedActions {
	protected static WebDriver driver;
	private static WebDriverWait wait;
	
	static public void setup(String url) {
		System.out.println("STEP - Launch Chrome brower");
		System.setProperty("webdriver.chrome.driver", "./resources/chromedriver.exe");
		driver = new ChromeDriver();
		
		System.out.println("STEP - Load URL");
		driver.get(url);
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, 30);
	}
	
	static public void setup() {
		setup("https://creditamar-trials76.orangehrmlive.com/");
	}
	
	public enum Locator {
		ID,
		NAME,
		PARTIALLINKTEXT,
		LINKTEXT,
		XPATH,
		CSS,
		CLASSNAME,
		TAGNAME
	}
	
	protected WebElement getElement(String locator, boolean isWaitRequired) {
		String locatorType = locator.split("]:-")[0].replace("[", "");
		String locatorValue = locator.split("]:-")[1];
		
		WebElement e = null;
		
		switch(locatorType) {
			case "xpath" :
				if(isWaitRequired)
					e = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locatorValue)));
				else
					e = driver.findElement(By.xpath(locatorValue));
			break;
			
			case "id" :
				if(isWaitRequired)
					e = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(locatorValue)));
				else
					e = driver.findElement(By.id(locatorValue));
			break;
			
			case "partiallinktext" :
				if(isWaitRequired)
					e = wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText(locatorValue)));
				else
					e = driver.findElement(By.partialLinkText(locatorValue));
			break;
			
			case "linktext" :
				if(isWaitRequired)
					e = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(locatorValue)));
				else
					e = driver.findElement(By.linkText(locatorValue));
			break;
			
			case "name" :
				if(isWaitRequired)
					e = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(locatorValue)));
				else
					e = driver.findElement(By.name(locatorValue));
			break;
			
			case "classname" :
				if(isWaitRequired)
					e = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(locatorValue)));
				else
					e = driver.findElement(By.className(locatorValue));
			break;
			
			case "contains" :
				if(isWaitRequired)
					e = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(locatorValue)));
				else
					e = driver.findElement(By.className(locatorValue));
			break;
		}		
		return e;
	}
	
	/*
	 * protected void mouseHover(String locatorType, String locatorValue, boolean
	 * isWaitRequired) { WebElement e = getElement(locatorType, locatorValue,
	 * isWaitRequired); if(e.isDisplayed()) { scrollToElement(e). } Actions action =
	 * new Actions(driver); action.moveToElement(e).biuld().perform(); }
	 */
	
	protected List<WebElement> getAllElement(String locator, boolean isWaitRequired){
		String locatorType = locator.split("]:-")[0].replace("[", "");
		String locatorValue = locator.split("]:-")[1];
		
		List<WebElement> listOfElements = null;
		
		switch(locatorType) {
			case "xpath" :
				if(isWaitRequired)
					listOfElements = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(locatorValue)));
				else
					listOfElements = driver.findElements(By.xpath(locatorValue));
			break;
			
			case "id" :
				if(isWaitRequired)
					listOfElements = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id(locatorValue)));
				else
					listOfElements = driver.findElements(By.id(locatorValue));
			break;
			
			case "partiallinktext" :
				if(isWaitRequired)
					listOfElements = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.partialLinkText(locatorValue)));
				else
					listOfElements = driver.findElements(By.partialLinkText(locatorValue));
			break;
			
			case "linktext" :
				if(isWaitRequired)
					listOfElements = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.linkText(locatorValue)));
				else
					listOfElements = driver.findElements(By.linkText(locatorValue));
			break;
			
			case "name" :
				if(isWaitRequired)
					listOfElements = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.name(locatorValue)));
				else
					listOfElements = driver.findElements(By.name(locatorValue));
			break;
			
			case "classname" :
				if(isWaitRequired)
					listOfElements = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className(locatorValue)));
				else
					listOfElements = driver.findElements(By.className(locatorValue));
			break;
		}		
		return listOfElements;
	}
	
	protected String getElementText(String locator, boolean isWaitRequired) {
		WebElement e = getElement(locator, isWaitRequired);
		return e.getText();
	}
	
	protected List<String> getAllElementText(String locator, boolean isWaitRequired){
		List<WebElement> listOfElements = getAllElement(locator, isWaitRequired);
		
		List<String> listOfElementText = new ArrayList<String>();
		for(WebElement element : listOfElements) {
			listOfElementText.add(element.getText());
		}
		return listOfElementText;
	}
	
	protected List<String > getAllElementText(List<WebElement> listOfElements){
		List<String> listOfElementText = new ArrayList<String>();
		for(WebElement element : listOfElements) {
			listOfElementText.add(element.getText());
		}
		return listOfElementText;
	}
	
	protected boolean isElementDisplayed(String locator, boolean isWaitRequired) {
		try {
			WebElement e = getElement(locator, isWaitRequired);
			return e.isDisplayed();			
		}catch(NoSuchElementException ne) {
			return false;
		}
	}
	
	protected boolean isElementEnabled(String locator, boolean isWaitRequired) {
		try {
			WebElement e = getElement(locator, isWaitRequired);
			return e.isEnabled();			
		}catch(NoSuchElementException ne) {
			return false;
		}
	}
	
	protected void scrollToElement(WebElement e ) {
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].scrollIntoView(true)", e);
	}
	
	protected void setText(String locator, boolean isWaitRequired, String textToBeEntered) {
		WebElement e = getElement(locator, isWaitRequired);
		if(!e.isDisplayed()){
			scrollToElement(e);
		}
		e.sendKeys(textToBeEntered);
	}
	
	protected String getElementAttribute(String locator, boolean isWaitRequired, String attribute) {
		WebElement e = getElement(locator, isWaitRequired);
		return e.getAttribute(attribute);
	}
	
	protected String getElementAttribute(WebElement e, String attribute) {
		return e.getAttribute(attribute);
	}
	
	protected void mouseHover(WebElement e) {
		Actions action = new Actions(driver);
		action.moveToElement(e).build().perform();
	}
	
	protected void mouseHover( String locator, boolean isWaitRequired) {
		WebElement e = getElement(locator, isWaitRequired);
		mouseHover(e);
	}
	
	static public void getRefresh() {
		driver.navigate().refresh();
		wait = new WebDriverWait(driver, 30);
	}
	
	
	protected void clickOnElement(WebElement e) {
		wait.until(ExpectedConditions.elementToBeClickable(e));
		e.click();
	}
	
	protected void clickOnElement(String locator, boolean isWaitRequired) {
		WebElement e = getElement(locator, isWaitRequired);
		if(!e.isDisplayed())
			scrollToElement(e);
		clickOnElement(e);
	}
	
	public String getTitle() {
		return driver.getTitle();
	}
	
	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}
	
	public static void closeBrowser() {

		 driver.close();
	}
}

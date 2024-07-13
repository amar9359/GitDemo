package com.technocredits.orghrm.testscripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


public class ExampleTest {
	
	@Test
	public void dryTest() {
		System.setProperty("webdriver.chrome.driver", "./resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://automationbykrishna.com/");
	}
}

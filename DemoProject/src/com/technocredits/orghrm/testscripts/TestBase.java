package com.technocredits.orghrm.testscripts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.technocredits.orghrm.base.PredefinedActions;
import com.technocredits.orghrm.pages.LoginPage;

public class TestBase {
	
	@BeforeClass
	public void setup() {
		System.out.println("Step - Login with valid credential");
		PredefinedActions.setup();
		LoginPage loginPage = new LoginPage();
		loginPage.login("admin", "9@mKP5XaEc");
	}
	
	@AfterClass
	public void closeDriver() {
		System.out.println("Clean up - close browser");
		PredefinedActions.closeBrowser();;
	}

}

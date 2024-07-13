package com.technocredits.orghrm.testscripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.technocredits.orghrm.base.PredefinedActions;
import com.technocredits.orghrm.pages.DashboardPage;
import com.technocredits.orghrm.pages.LoginPage;

public class LoginTest {
	

	@Test
	public void loginTest() {
		PredefinedActions.setup();
		
		LoginPage loginPage = new LoginPage();
		System.out.println("VERIFY - Logo displayed on Login Page");
		boolean isLogoDisplayedFlag = loginPage.isLogoDisplayed();
		Assert.assertTrue(isLogoDisplayedFlag);

		System.out.println("VERIFY - Login Panel displayed on Login Page");
		boolean isLoginFormDisplayFlag = loginPage.isLoginPanelDisplayed();				
		Assert.assertTrue(isLoginFormDisplayFlag);
		
		final String username = "admin";
		final String password = "9@mKP5XaEc";

		System.out.println("STEP - Enter username");
		loginPage.enterUsername(username);
		
		System.out.println("VERIFY - User able to enter username");
		String actualUsername = loginPage.getUsername();
		Assert.assertEquals(actualUsername, username);

		System.out.println("STEP - Enter password");
		loginPage.enterPassword(password);

		System.out.println("VERIFY - User able to enter username");
		String actualPassword = loginPage.getPassword();
		Assert.assertEquals(actualPassword, password);

		System.out.println("STEP - User click on Login button on Login Page");
		loginPage.clickOnLoginButton();

		System.out.println("VERIFY - URL endsWith dashboard");
		Assert.assertTrue(loginPage.getCurrentUrl().endsWith("dashboard"));
		
		System.out.println("VERIFY - URL endsWith Management");
		Assert.assertTrue(loginPage.getTitle().endsWith("Management"));
		
		DashboardPage dashboardPage = new DashboardPage();
		boolean isEmpManagementDisplayed = dashboardPage.isTopBarTitleDisplayed();
		Assert.assertTrue(isEmpManagementDisplayed);	
		
		System.out.println("Clean up - close browser");
		PredefinedActions.closeBrowser();
	}
}

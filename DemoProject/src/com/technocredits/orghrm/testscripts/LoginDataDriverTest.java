package com.technocredits.orghrm.testscripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.technocredits.orghrm.base.PredefinedActions;
import com.technocredits.orghrm.pages.DashboardPage;
import com.technocredits.orghrm.pages.LoginPage;
import com.technocredits.orghrm.pages.RetryLoginPage;
import com.technocredits.orghrm.util.ExcelOperations;

public class LoginDataDriverTest {
	
	@Test(enabled = false)
	public void loginTest() {
		PredefinedActions.setup();
		
		LoginPage loginPage = new LoginPage();
		System.out.println("VERIFY - Logo displayed on Login Page");
		boolean isLogoDisplayedFlag = loginPage.isLogoDisplayed();
		Assert.assertTrue(isLogoDisplayedFlag);

		System.out.println("VERIFY - Login Panel displayed on Login Page");
		boolean isLoginFormDisplayFlag = loginPage.isLoginPanelDisplayed();				
		Assert.assertTrue(isLoginFormDisplayFlag);
		
		final String username = "Admin";
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
	
	@Test(dataProvider="loginData", enabled = false)
	public void loginInvalidDataTest(String username, String password, boolean loginFlag) {
		PredefinedActions.setup();
		
		LoginPage loginPage = new LoginPage();
		System.out.println("VERIFY - Logo displayed on Login Page");
		boolean isLogoDisplayedFlag = loginPage.isLogoDisplayed();
		Assert.assertTrue(isLogoDisplayedFlag);

		System.out.println("VERIFY - Login Panel displayed on Login Page");
		boolean isLoginFormDisplayFlag = loginPage.isLoginPanelDisplayed();				
		Assert.assertTrue(isLoginFormDisplayFlag);
		
		//final String username = "admin";
		//final String password = "9@mKP5XaEc-Amar";

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
	
		RetryLoginPage retryLoginPage = new RetryLoginPage();
		String actualUrl = retryLoginPage.getCurrentUrl();
		Assert.assertTrue(actualUrl.endsWith("/securityAuthentication/retryLogin"));
	
		boolean isErrorMessageDisplayedFlag = retryLoginPage.isErrorMessageDisplayed();
		Assert.assertEquals(isErrorMessageDisplayedFlag, true);
		
		String actualErrorMessage = retryLoginPage.getErrorMessage().trim();
		String expectedErrorMessage = "Invalid Credentials";
		Assert.assertEquals(actualErrorMessage, expectedErrorMessage);
		
		boolean isDashboardCardTitleDisplayedFlag = retryLoginPage.isDashboardCardTitleDisplayed();
        Assert.assertTrue(isDashboardCardTitleDisplayedFlag, "DashboardCard was not displayed on RetryLoginPage");
	}
	
	@BeforeMethod
	public void setUp() {
		PredefinedActions.setup();
	}
	
	@Test(dataProvider="loginData")
	public void loginDataProviderTest(String username, String password, boolean loginFlag) {
		
		LoginPage loginPage = new LoginPage();
		System.out.println("VERIFY - Logo displayed on Login Page");
		boolean isLogoDisplayedFlag = loginPage.isLogoDisplayed();
		Assert.assertTrue(isLogoDisplayedFlag);

		System.out.println("VERIFY - Login Panel displayed on Login Page");
		boolean isLoginFormDisplayFlag = loginPage.isLoginPanelDisplayed();				
		Assert.assertTrue(isLoginFormDisplayFlag);
		
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
		
		if(loginFlag) {
			System.out.println("VERIFY - URL endsWith dashboard");
			Assert.assertTrue(loginPage.getCurrentUrl().endsWith("dashboard"));
			
			System.out.println("VERIFY - URL endsWith Management");
			Assert.assertTrue(loginPage.getTitle().endsWith("Management"));
			
			DashboardPage dashboardPage = new DashboardPage();
			boolean isEmpManagementDisplayed = dashboardPage.isTopBarTitleDisplayed();
			Assert.assertTrue(isEmpManagementDisplayed);	
			
			
		}else {
			RetryLoginPage retryLoginPage = new RetryLoginPage();
			String actualUrl = retryLoginPage.getCurrentUrl();
			Assert.assertTrue(actualUrl.endsWith("/securityAuthentication/retryLogin"));
		
			boolean isErrorMessageDisplayedFlag = retryLoginPage.isErrorMessageDisplayed();
			Assert.assertEquals(isErrorMessageDisplayedFlag, true);
			
			String actualErrorMessage = retryLoginPage.getErrorMessage().trim();
			String expectedErrorMessage = "Invalid Credentials";
			Assert.assertEquals(actualErrorMessage, expectedErrorMessage);
			
			boolean isDashboardCardTitleDisplayedFlag = retryLoginPage.isDashboardCardTitleDisplayed();
	        Assert.assertTrue(isDashboardCardTitleDisplayedFlag, "DashboardCard was not displayed on RetryLoginPage");
	        
		}
	}
	
    @DataProvider(name="loginData")
    public Object[][] loginDataProvider() throws IOException{
    	
    	Object[][] data = ExcelOperations.getData("./testdata/logindata.xlsx", "data");
    	
    	return data;
    }
    
    @AfterMethod
	public void tearDown() {
		System.out.println("Clean up - close browser");
		PredefinedActions.closeBrowser();
	}
}

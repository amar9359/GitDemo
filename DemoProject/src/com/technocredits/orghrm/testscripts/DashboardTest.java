package com.technocredits.orghrm.testscripts;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.technocredits.orghrm.pages.DashboardPage;
import com.technocredits.orghrm.pages.LoginPage;

public class DashboardTest extends TestBase{
	
	
	@Test
	public void widgetsTest() {
		
		LoginPage loginPage = new LoginPage();
		System.out.println("VERIFY - user landed to dashboard");
		Assert.assertTrue(loginPage.getCurrentUrl().endsWith("dashboard"));
		
		DashboardPage dashboardPage = new DashboardPage();
		
		System.out.println("Step : count total widgets displayed on dashboard");
		int actualWidgetsCount = dashboardPage.getTotalWidgets();
		int expectedWidgetsCount = 9;
		
		System.out.println("Verify : Total Widgets");
		Assert.assertEquals(actualWidgetsCount, expectedWidgetsCount);
		
		System.out.println("Step : get widget text");
		List<String> actualWidgetsHeaderText = dashboardPage.getWidgetsHeaderText();
		
		List<String> expectedWidgetsHeaderText = getExpectedWidgetsText();
		System.out.println("Verify : all widget text");
		Assert.assertEquals(actualWidgetsHeaderText, expectedWidgetsHeaderText);
	}
	
	private List<String> getExpectedWidgetsText(){
		List<String> expectedWidgetsHeaderText = new ArrayList<String>();
		expectedWidgetsHeaderText.add("Quick Access");
		expectedWidgetsHeaderText.add("Buzz Latest Posts");
		expectedWidgetsHeaderText.add("My Actions");
		expectedWidgetsHeaderText.add("Headcount by Location");
		expectedWidgetsHeaderText.add("Employees on Leave Today");
		expectedWidgetsHeaderText.add("Time At Work");
		expectedWidgetsHeaderText.add("Latest Documents");
		expectedWidgetsHeaderText.add("Latest News");
		expectedWidgetsHeaderText.add("COVID-19 Report");
		
		return expectedWidgetsHeaderText;
		
	}

}

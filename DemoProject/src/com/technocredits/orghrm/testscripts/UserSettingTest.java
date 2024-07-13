package com.technocredits.orghrm.testscripts;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.technocredits.orghrm.pages.DashboardPage;

public class UserSettingTest extends TestBase{

	@Test
	public void tc3() {
		
		DashboardPage dashboardPage = new DashboardPage();
		System.out.println("STEP:  user profile is display on UI");
		Assert.assertTrue(dashboardPage.isUserProfileDisplayed());
		
		System.out.println("Step : Mouse hover to user profile and click on user settings");
		dashboardPage.clickOnUserSettings();
		
		System.out.println("Step: Verify 2 element is display");
		List<String> listOfSubMenuEelement = dashboardPage.getUserSubMenu();
		Assert.assertEquals(listOfSubMenuEelement.size(), 2);
		Assert.assertEquals(listOfSubMenuEelement.get(0), "Change Password");
		Assert.assertEquals(listOfSubMenuEelement.get(1), "About");
		
		System.out.println("Step : Click on about button");
		dashboardPage.clickOnAboutSubMenu();

		System.out.println(" Verify : Employees ar non-zero");
		int empCount = dashboardPage.getEmployeesCount();
		Assert.assertTrue(empCount > 0, "Employee count is zero");
		
		Map<String, String> mapOfAboutText = dashboardPage.getAboutText();
		Set<String> actualCompanyInfo = mapOfAboutText.keySet();
		Set<String> expectedCompanyInfo = new LinkedHashSet<String>();
		
		expectedCompanyInfo.add("Company Name");
		expectedCompanyInfo.add("Version");
		expectedCompanyInfo.add("Employees");
		expectedCompanyInfo.add("Users");
		expectedCompanyInfo.add("Renewal on");

		Assert.assertEquals(actualCompanyInfo, expectedCompanyInfo);
		System.out.println("Verify : Company information getting display");

		System.out.println("STEP: Click on OK button on popup");
		dashboardPage.clickOnOkButton();		
	}
}



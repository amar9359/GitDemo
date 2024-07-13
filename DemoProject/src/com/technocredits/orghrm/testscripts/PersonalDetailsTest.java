package com.technocredits.orghrm.testscripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.technocredits.orghrm.pages.DashboardPage;
import com.technocredits.orghrm.pages.myinfo.MyInfoPage;
import com.technocredits.orghrm.pages.myinfo.PersonalDetailsPage;
import com.technocredits.orghrm.pages.myinfo.SalaryPage;

public class PersonalDetailsTest extends TestBase{
	
	@Test
	public void testCase4() {
		
		System.out.println("STEP: Click on My Info tab");
		DashboardPage dashboardPage = new DashboardPage();
		PersonalDetailsPage personalDetailsPage = dashboardPage.clickOnMyInfoPage();
		
		System.out.println("STEP: Verify user Personal info displayed");
		boolean isPersonalDetailVisibleFlag = personalDetailsPage.isPageLoaded();
		Assert.assertTrue(isPersonalDetailVisibleFlag);

		System.out.println("STEP: Click on Salary");
		MyInfoPage myInfoPage =  new MyInfoPage();
		SalaryPage salaryPage = myInfoPage.clickOnSalary();
		
		System.out.println("STEP: Check the payable (CTC) amount is non-zero");
		double costToComapny = salaryPage.getCostToCompany();
				
		Assert.assertTrue(costToComapny > 0, "current salary is non - zero");		
	}
}

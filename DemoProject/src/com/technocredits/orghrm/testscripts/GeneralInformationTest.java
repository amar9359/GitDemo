package com.technocredits.orghrm.testscripts;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.technocredits.orghrm.pages.GeneralInformationPage;

public class GeneralInformationTest extends TestBase{
	
	
	String newOrganizationName = "WNS";
	// Actual Organization Name- OrangeHRM (Pvt) Ltd(Parallel Demo)

	@Test
	public void tc7() {
		GeneralInformationPage generalInformationPage = new GeneralInformationPage();
		System.out.println("STEP: Click on HR Administration tab");
		generalInformationPage.clickOnHRAdministrationTab();

		System.out.println("STEP: Click on Organization menu tab");
		generalInformationPage.clickOnOrganizationMenuTab();

		System.out.println("STEP: Click on General Information option");
		generalInformationPage.clickOnGeneralInformation();

		System.out.println("STEP: Change Organization Name");
		WebElement orgNameElement = generalInformationPage.getchangeOrganizationName();
		orgNameElement.clear();
		orgNameElement.sendKeys(newOrganizationName);

		String currentOrgName = orgNameElement.getAttribute("value");
		Assert.assertTrue(currentOrgName.equals(newOrganizationName));
		System.out.println("VERIFY: Organization Name changed as '" + newOrganizationName + "'");

		System.out.println("STEP: Verify 'Number of Employees' field is disabled");
		boolean isNumOfEmpFieldEnabled = generalInformationPage.isNunmberOfEmployeeFieldDisabled();
		Assert.assertFalse(isNumOfEmpFieldEnabled);
		System.out.println("VERIFY: Field 'Number of Employees' is disabled");

		System.out.println("STEP: Save the information");
		generalInformationPage.clickOnSaveButton();

		System.out.println("STEP: Mouse hover on user profile and click on Setting icon");
		generalInformationPage.clickOnUserSettings();

		System.out.println("STEP: Click on about section");
		generalInformationPage.clickOnAboutSubMenu();

		System.out.println("STEP: Verify that updated Organization name displayed as '" + newOrganizationName + "'");
		String updatedOrgName = generalInformationPage.getCompanyName();
		Assert.assertEquals(updatedOrgName, newOrganizationName);
		System.out.println("VERIFY: Updated Organization name is '" + newOrganizationName + "'");
	}
}

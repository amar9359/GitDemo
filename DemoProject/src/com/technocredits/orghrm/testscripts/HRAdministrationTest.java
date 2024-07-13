package com.technocredits.orghrm.testscripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.technocredits.orghrm.pages.HRAdministrationPage;

public class HRAdministrationTest extends TestBase{

	@Test
	public void tc5() {
		HRAdministrationPage hrAdministrationPage = new HRAdministrationPage();
		
		System.out.println("STEP: Click on HR Administration tab from left panel");
		hrAdministrationPage.clickOnHrAdminstrationTab();

		System.out.println("STEP: Click on Manage User Roles tab from top panel");
		hrAdministrationPage.clickOnManageUserRoles();

		System.out.println("STEP: Verify by default 50 record per page should get display in table");
		String str = hrAdministrationPage.getDefault50Record();
		int defaultRecordCount =Integer.parseInt(str);
		Assert.assertTrue(defaultRecordCount == 50);

		System.out.println("STEP: Verify total record and showing count of record in right corner of page");
		int recordCountUnderManageUserRoles = hrAdministrationPage.getTotalRecord();
		String str1 = hrAdministrationPage.getCountOfRecord();
		int pagination =Integer.parseInt(str1);
		Assert.assertEquals(recordCountUnderManageUserRoles, pagination);
		System.out.println("VERIFY: Current record count in table: " + pagination);

	}
}

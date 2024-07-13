package com.technocredits.orghrm.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;

import com.technocredits.orghrm.base.PredefinedActions;
import com.technocredits.orghrm.constant.Constant;
import com.technocredits.orghrm.util.PropOperations;

public class HRAdministrationPage extends PredefinedActions{
	
	private PropOperations propOperations;
	
	public HRAdministrationPage() {
		try {
			propOperations = new PropOperations(Constant.hrAdministrationLocator);
		} catch (IOException e) {
			System.out.println("HRAdministration Locator file is not available, file hrAdministrationLocator.properties");
			e.printStackTrace();
		}		
	}
	
	public void clickOnHrAdminstrationTab() {
		clickOnElement(propOperations.getValue("hrAdministration"), false);
	}
	
	public void clickOnManageUserRoles() {
		clickOnElement(propOperations.getValue("manageUserRoles"), false);
	}
	
	public String getDefault50Record() {
		WebElement e = getElement(propOperations.getValue("defaultValue50"), true);
		String str = e.getAttribute("value");
		return str;
	}
	
	public int getTotalRecord() {
		int e = getAllElement(propOperations.getValue("totalRecord"), false).size();
		return e;
	}
	
	public String getCountOfRecord() {
		WebElement e = getElement(propOperations.getValue("countOfRecord"), false);
		String str = e.getText().split(" ")[4];
		return str;
	}
}

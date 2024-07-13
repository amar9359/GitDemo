package com.technocredits.orghrm.pages.myinfo;

import java.io.IOException;

import com.technocredits.orghrm.base.PredefinedActions;
import com.technocredits.orghrm.constant.Constant;
import com.technocredits.orghrm.util.PropOperations;

public class MyInfoPage extends PredefinedActions{
	private PropOperations propOperations;
	
	public MyInfoPage() {
		try {
			propOperations = new PropOperations(Constant.myInfoPageLocator);
		} catch (IOException e) {
			System.out.println("MyInfoPage Locator file is not available, file myInfoPageLocator.properties");
			e.printStackTrace();
		}
	}
	public SalaryPage clickOnSalary() {
		clickOnElement(propOperations.getValue("salary"), true);
		return new SalaryPage();
	}
	
	public PersonalDetailsPage clickOnPersonalDetails() {
		clickOnElement(propOperations.getValue("personalDetails"), true);
		return new PersonalDetailsPage();
	}

}

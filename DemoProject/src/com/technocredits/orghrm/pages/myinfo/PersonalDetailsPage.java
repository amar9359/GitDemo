package com.technocredits.orghrm.pages.myinfo;

import java.io.IOException;

import com.technocredits.orghrm.base.PredefinedActions;
import com.technocredits.orghrm.constant.Constant;
import com.technocredits.orghrm.util.PropOperations;

public class PersonalDetailsPage extends PredefinedActions{
	private PropOperations propOperations;
	
	public PersonalDetailsPage() {
		try {
			propOperations = new PropOperations(Constant.myInfoPageLocator);
		} catch (IOException e) {
			System.out.println("MyInfoPage Locator file is not available, file myInfoPageLocator.properties");
			e.printStackTrace();
		}
	}
	
	public boolean isPageLoaded() {
		return isElementDisplayed(propOperations.getValue("firstName"), true);
	}
}

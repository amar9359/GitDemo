package com.technocredits.orghrm.pages;

import java.io.IOException;

import com.technocredits.orghrm.base.PredefinedActions;
import com.technocredits.orghrm.constant.Constant;
import com.technocredits.orghrm.util.PropOperations;

public class RetryLoginPage extends PredefinedActions{
	private PropOperations propOperations;
	
	public RetryLoginPage() {
		try {
			propOperations = new PropOperations(Constant.retryLoginLocator);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public boolean isPageLoaded() {
		return isElementDisplayed(propOperations.getValue("orangehrm-form"), true);
	}
	
	public boolean isErrorMessageDisplayed() {
		return isElementDisplayed(propOperations.getValue("errorToastMessage"), true);
	}
	
	public String getErrorMessage() {
		return getElementText(propOperations.getValue("errorToastMessage"), true);
	}
	
	public boolean isDashboardCardTitleDisplayed() {
		return isElementDisplayed(propOperations.getValue("dashboardCardTitle"), false);
	}

}

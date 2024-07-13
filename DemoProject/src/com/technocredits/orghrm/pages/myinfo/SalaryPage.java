package com.technocredits.orghrm.pages.myinfo;

import java.io.IOException;

import org.openqa.selenium.WebElement;

import com.technocredits.orghrm.base.PredefinedActions;
import com.technocredits.orghrm.constant.Constant;
import com.technocredits.orghrm.util.PropOperations;

public class SalaryPage extends PredefinedActions{
	private PropOperations propOperations;
	
	public SalaryPage() {
		try {
			propOperations = new PropOperations(Constant.myInfoPageLocator);
		} catch (IOException e) {
			System.out.println("MyInfoPage Locator file is not available, file myInfoPageLocator.properties");
			e.printStackTrace();
		}	
	}
	
	public double getCostToCompany() {
		WebElement ctcElement = getElement(propOperations.getValue("costToCompany"), true);
		String ctcText = ctcElement.getText().replace("$", "").replace(",", "");
		return Double.parseDouble(ctcText);
	}

}

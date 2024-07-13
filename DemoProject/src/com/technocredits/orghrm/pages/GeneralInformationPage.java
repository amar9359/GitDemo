package com.technocredits.orghrm.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;

import com.technocredits.orghrm.base.PredefinedActions;
import com.technocredits.orghrm.constant.Constant;
import com.technocredits.orghrm.util.PropOperations;

public class GeneralInformationPage extends PredefinedActions{
	private PropOperations propOperations;
	
	public GeneralInformationPage() {
		try {
			propOperations = new PropOperations(Constant.generalInformationPageLocator);
		} catch (IOException e) {
			System.out.println("GeneralInformationPage Locator file is not available, file generalInformationPageLocator.properties");
			e.printStackTrace();
		}
	}
	
	public void clickOnHRAdministrationTab() {
		clickOnElement(propOperations.getValue("hrAdministration"), true);
	}
	
	public void clickOnOrganizationMenuTab() {
		clickOnElement(propOperations.getValue("organizationMenuTab"), false);
	}
	
	public void clickOnGeneralInformation() {
		clickOnElement(propOperations.getValue("generalInformation"), true);
	}
	
	public WebElement getchangeOrganizationName() {
		WebElement e =getElement(propOperations.getValue("changeName"), true);
		return e;
	}
	
	public boolean isNunmberOfEmployeeFieldDisabled() {
		return isElementEnabled(propOperations.getValue("numEmpDisabled"), false);
	}
	
	public void clickOnSaveButton() {
		clickOnElement(propOperations.getValue("savebtn"), true);
	}
	
	private WebElement getUserProfileElement() {
		WebElement userProfileElement = getElement(propOperations.getValue("userProfileElement"), false);
		return userProfileElement;
	}
	
	public void clickOnUserSettings() {
		WebElement userProfileElement = this.getUserProfileElement();
		mouseHover(userProfileElement);
		clickOnElement(propOperations.getValue("userSettings"), false);
	}
	
	public void clickOnAboutSubMenu() {
		clickOnElement(propOperations.getValue("aboutSubMenu"), false);
	}
	
	public String getCompanyName() {
		String text = getElementText(propOperations.getValue("companyName"), true);
		return text.split(":")[1].trim();
	}

}

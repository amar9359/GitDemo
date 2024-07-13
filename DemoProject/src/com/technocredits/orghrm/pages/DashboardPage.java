package com.technocredits.orghrm.pages;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebElement;

import com.technocredits.orghrm.base.PredefinedActions;
import com.technocredits.orghrm.constant.Constant;
import com.technocredits.orghrm.pages.myinfo.PersonalDetailsPage;
import com.technocredits.orghrm.util.PropOperations;

public class DashboardPage extends PredefinedActions {
	private PropOperations propOperations;
	
	public DashboardPage() {
		try {
			propOperations = new PropOperations(Constant.dashboardLocator);
		} catch (IOException e) {
			System.out.println("Dashboard Locator file is not available, file dashboardLocator.properties");
			e.printStackTrace();
		}
	}
	public boolean isTopBarTitleDisplayed() {
		return isElementDisplayed(propOperations.getValue("topBarTitle"), false);
	}
	
	public int getTotalWidgets() {
		List<WebElement> listOfWidgets = getAllElement(propOperations.getValue("listOfWidgets"), false);
		return listOfWidgets.size();
	}
	
	public List<String> getWidgetsHeaderText(){
		List<String> listOfWidgetsText = getAllElementText(propOperations.getValue("listOfHeaderText"), false);
		return listOfWidgetsText;
	}
	
	private WebElement getUserProfileElement() {
		WebElement userProfileElement = getElement(propOperations.getValue("userProfileElement"), false);
		return userProfileElement;
	}
	
	public boolean isUserProfileDisplayed() {
		WebElement userProfileElement = this.getUserProfileElement();
		return userProfileElement.isDisplayed();
	}
	
	public void clickOnUserSettings() {
		WebElement userProfileElement = this.getUserProfileElement();
		mouseHover(userProfileElement);
		clickOnElement(propOperations.getValue("userSettings"), false);
	}
	
	public List<String> getUserSubMenu(){
		List<WebElement> listOfSubMenuElement = getAllElement(propOperations.getValue("userSubMenu"), false);
		
		List<String> listOfSubMenuElementText = new ArrayList<String>();
		for(WebElement e : listOfSubMenuElement) {
			listOfSubMenuElementText.add(e.getText());			
		}
		return listOfSubMenuElementText;
	}
	
	public void clickOnAboutSubMenu() {
		clickOnElement(propOperations.getValue("aboutSubMenu"), false);
	}
	
	public Map<String, String> getAboutText(){
		List<String> listOfAboutContent = getAllElementText(propOperations.getValue("companyInfo"), true);
		Map<String, String> aboutTextMap = new LinkedHashMap<String, String>();
		for(String text : listOfAboutContent) {
			aboutTextMap.put(text.split(":")[0].trim(), text.split(":")[1].trim());
		}
		return aboutTextMap;
	}
	
	public int getTotalAttributes() {
		return getAboutText().size();
	}

	public String getCompanyName() {
		String text = getElementText(propOperations.getValue("companyName"), false);
		return text.split(":")[1].trim();
	}
	
	public String getVersion() {
		return getAboutText().get("Version");
	}
	
	public int getEmployeesCount() {
		String empCount =  getAboutText().get("Employees").split(" ")[0];
		return Integer.parseInt(empCount);
	}
	
	public int getEmployeesRemainingCount() {
		String getRemainingCountText =  getAboutText().get("Employees").split("(")[1];
		return Integer.parseInt(getRemainingCountText.split(" ")[0]);
	}
	
	public int getUserCount() {
		String uesrText = getAboutText().get("Users");
		return Integer.parseInt(uesrText.split(" ")[0]);
	}
	
	public String getRenewalOn() {
		return getAboutText().get("Renewal on");
	}
	
	public void clickOnOkButton() {
		clickOnElement(propOperations.getValue("okButton"), false);
	}
	
	public PersonalDetailsPage clickOnMyInfoPage() {
		clickOnElement(propOperations.getValue("myInfoPage"), false);
		return new PersonalDetailsPage();
	}
}

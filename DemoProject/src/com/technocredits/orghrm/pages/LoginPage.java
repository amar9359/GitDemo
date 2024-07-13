package com.technocredits.orghrm.pages;

import java.io.IOException;

import com.technocredits.orghrm.base.PredefinedActions;
import com.technocredits.orghrm.constant.Constant;
import com.technocredits.orghrm.util.PropOperations;

public class LoginPage extends PredefinedActions{
	private PropOperations propOperations;
	
	public LoginPage() {
		try {
			propOperations = new PropOperations(Constant.loginPageLocator);
		} catch (IOException e) {
			System.out.println("Login Locator file is not available, file LoginPageLocator.properties");
			e.printStackTrace();
		}
	}
	
	public boolean isLogoDisplayed() {
		return isElementDisplayed(propOperations.getValue("logo"), false);
		
	}
	
	public boolean isLoginPanelDisplayed() {
		return isElementDisplayed(propOperations.getValue("loginPanel"), false);
	}
	
	public void login(String username, String password) {
		enterUsername(username);
		enterPassword(password);
		clickOnLoginButton();
	}
	
	public void enterUsername(String username) {
		setText(propOperations.getValue("username"), false, username);
	}
	
	public void enterPassword(String password) {
		setText(propOperations.getValue("password"), false, password);
	}
	
	public void clickOnLoginButton() {
		clickOnElement(propOperations.getValue("loginbtn"), false);
	}
	
	public String getUsername() {
		return getElementAttribute(propOperations.getValue("username"), false, "value");
	}
	
	public String getPassword() {
		return getElementAttribute(propOperations.getValue("password"), false, "value");
	}
}

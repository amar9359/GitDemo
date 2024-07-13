package com.technocredits.orghrm.pages;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebElement;

import com.technocredits.orghrm.base.PredefinedActions;
import com.technocredits.orghrm.constant.Constant;
import com.technocredits.orghrm.util.PropOperations;

public class QualificationsPage extends PredefinedActions{
	private PropOperations propOperations;
	
	public QualificationsPage() {
		try {
			propOperations = new PropOperations(Constant.qualificationsPageLocator);
		} catch (IOException e) {
			System.out.println("QualificationsPage Locator file is not available, file qualificationsPageLocator.properties");
			e.printStackTrace();
		}
	}
	
	public void clickOnMoreMenu() {
		clickOnElement(propOperations.getValue("moreMenu"), false);
	}
	
	public void mouseHoveredOnQualificationsTab() {
		mouseHover(propOperations.getValue("qualificationsTab"), false);
	}
	
	public void clickOnSkillsOption() {
		clickOnElement(propOperations.getValue("skillsOption"), true);
	}	
	
	public int getCurrentSkillTableCount1() {
	int e = getAllElement(propOperations.getValue("skillTableCount"), true).size();
	return e;
	}
	
	private Map<String, String> skillTableText(){
		List<String> listOfSkillTable = getAllElementText(propOperations.getValue("skills"), true);
		List<String> listOfDescriptionTable = getAllElementText(propOperations.getValue("description"), true);
		Map<String, String> skillTableMap = new LinkedHashMap<String, String>();
		for (int index=0; index<listOfSkillTable.size();index++) {
			skillTableMap.put(listOfSkillTable.get(index), listOfDescriptionTable.get(index));
		}
		return skillTableMap;
	}
	
	public Map<String, String> skillTableText1(){
	
		Map<String, String> skillTableMap = skillTableText();
		return skillTableMap;
	}
	
	public void clickOnAddSkill() {
		clickOnElement(propOperations.getValue("addSkill"), true);
	}
	
	public String getAddSkillText() {
	String skill = getElementText(propOperations.getValue("addSkillText"), false);
	return skill;
	}
	
	public WebElement addSkillName() {
		WebElement e =getElement(propOperations.getValue("addSkillName"), true);
		return e;
	}
	
	public WebElement addSkillDescription() {
		WebElement e =getElement(propOperations.getValue("addSkillDescription"), false);
		return e;
	}
	
	public void clickOnSaveButton() {
		clickOnElement(propOperations.getValue("savebtn"), true);
	}	
	
	public int getCurrentSkillTableCount2() {
		int e = getAllElement(propOperations.getValue("skillTableCount"), true).size();
		return e;
	}
	
	public Map<String, String> skillTableText2(){
		Map<String, String> skillTableMap = skillTableText();
		return skillTableMap;
	}
}

	

package com.technocredits.orghrm.testscripts;

import java.util.Map;
import java.util.Set;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.technocredits.orghrm.base.PredefinedActions;
import com.technocredits.orghrm.pages.QualificationsPage;

public class QualificationsTest extends TestBase{
	
	
	static String skillToBeAdded = "Automation Test 1";
	static String descriptionToBeAdded = "Random Text";

	@Test
	public void tc6() {
		
		QualificationsPage qualificationsPage = new QualificationsPage();
		System.out.println("STEP: Mouse hover on Qualifications tab");
		qualificationsPage.clickOnMoreMenu();
		
		System.out.println("VERIFY: Mouse hovered on Qualifications tab");
		qualificationsPage.mouseHoveredOnQualificationsTab();

		System.out.println("STEP: Click on Skills option under Qualifications");
		qualificationsPage.clickOnSkillsOption();
		
		Map<String, String> skillTableMap = qualificationsPage.skillTableText1();
		Set<String> skillSetBeforeNewSkill = skillTableMap.keySet();

		System.out.println("STEP: click on '+' icon on top right corner");
		qualificationsPage.clickOnAddSkill();

		System.out.println("STEP: Display popup header as 'Add Skill'");
		String newSkillPopupHeader = qualificationsPage.getAddSkillText();
		Assert.assertEquals(newSkillPopupHeader, "Add Skill");

		System.out.println("STEP: Enter Skill as '" + skillToBeAdded + "'");
		qualificationsPage.addSkillName().sendKeys(skillToBeAdded);
		String newSkillNameProvided = qualificationsPage.addSkillName().getAttribute("value");
		Assert.assertEquals(skillToBeAdded, newSkillNameProvided);
		System.out.println("VERIFY: New Skill name added as '" + skillToBeAdded + "'");

		System.out.println("STEP: Enter any randon text in description");
		qualificationsPage.addSkillDescription().sendKeys(descriptionToBeAdded);
		String newSkillDescriptionProvided = qualificationsPage.addSkillDescription().getAttribute("value");
		Assert.assertEquals(descriptionToBeAdded, newSkillDescriptionProvided);
		System.out.println("VERIFY: New Skill description added as '" + descriptionToBeAdded + "'");

		System.out.println("STEP: Click on 'Save' button");
		qualificationsPage.clickOnSaveButton();

		PredefinedActions.getRefresh();
		System.out.println("***Current URL refreshed***");

		System.out.println("STEP: Verify that new skill getting display on Skill List");

		Map<String, String> skillTableMap2 = qualificationsPage.skillTableText2();
		Set<String> skillSetAfterNewSkill = skillTableMap2.keySet();
		skillSetAfterNewSkill.removeAll(skillSetBeforeNewSkill);
		Assert.assertEquals(skillToBeAdded, String.join(" ", skillSetAfterNewSkill));
		System.out.println("VERIFY: Newly added skill displayed on Skill List");
	}
}

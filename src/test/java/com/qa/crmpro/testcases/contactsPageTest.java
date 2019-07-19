package com.qa.crmpro.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.qa.crmpro.pages.contactsPage;
import com.qa.crmpro.pages.homePage;
import com.qa.crmpro.pages.loginPage;
import com.qa.crmpro.testbase.testBase;
import com.qa.crmpro.util.testUtil;

public class contactsPageTest extends testBase{
	
	contactsPage cp;
	loginPage lp;
	homePage hp;
	testUtil util;
	
	//create a constructor to access the testBase class properties
	public contactsPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		initialization();
		lp= new loginPage();
		hp= new homePage();
		cp= new contactsPage();
		hp= lp.validateLoginToCRMPROApp(prop.getProperty("username"), prop.getProperty("password"));
		util.switchToFrame();
		cp= hp.clickOnContactsLink();
	}
	
	@Test
	public void validateContactsPageHeaderNameDisplayed() {
		Assert.assertTrue(cp.isContactsHeaderNameDisplayed(), "Contacts Header Name is not displayed");
	}
	
	@Test
	public void getContactsPageTitle(){
		String contactsPageTitle= cp.getContactsPageTitle();
		Assert.assertEquals(contactsPageTitle, "CRMPRO", "Contacts page title is not the same");
	}
	
	@Test
	public void selectContactsTest(){
		try{
			cp.selectContactsByName("Vikram Sarabhai");
		}catch(Exception e){
			System.out.println("Name not available in Contacts");
		}
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
}

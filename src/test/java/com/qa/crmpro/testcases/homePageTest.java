package com.qa.crmpro.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.qa.crmpro.pages.contactsPage;
import com.qa.crmpro.pages.homePage;
import com.qa.crmpro.pages.loginPage;
import com.qa.crmpro.pages.newContactPage;
import com.qa.crmpro.testbase.testBase;
import com.qa.crmpro.util.testUtil;

public class homePageTest extends testBase{
	
	//create reference variables for the class
	public loginPage lp;
	public homePage hp;
	public newContactPage ncp;
	public contactsPage cp;
	public static testUtil utils;
	boolean flag= true;
	
	//create a constructor to access the properties from base class
	public homePageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		initialization();
		lp= new loginPage();
		cp= new contactsPage();
		hp= new homePage();
		hp= lp.validateLoginToCRMPROApp(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
	@Test
	public void validateHomePageTitleTest(){
		String homePageTitle= hp.getHomePageTitle();
		Assert.assertEquals(homePageTitle, "CRMPRO", "Homepage title not matched");
	}
	
	@Test
	public void validateCRMPROHomePageLogoTest(){
		utils.switchToFrame();
		Assert.assertTrue(hp.isCRMPROLogoInHomePageDisplayed(),"CRMPRO logo in Homepage is not displayed");
	}
	
	@Test
	public void verifyUserNameTest(){
		utils.switchToFrame();
		Assert.assertTrue(hp.isLoggedInUserNameInHomePageDisplayed(), "User name is not displayed");
	}
	
	@Test
	public void verifyContactsLinkTest(){
		utils.switchToFrame();
		cp= hp.clickOnContactsLink();
		Assert.assertTrue(cp.isContactsHeaderNameDisplayed(), "Contact header is not displayed in the Contacts page");
	}
	
	@Test
	public void clickOnNewContactsLinkInHomePageTest(){
		utils.switchToFrame();
		ncp= hp.clickOnNewContactsLink();
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
}

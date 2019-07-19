package com.qa.crmpro.testcases;

import org.apache.log4j.PropertyConfigurator;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import com.qa.crmpro.pages.homePage;
import com.qa.crmpro.pages.loginPage;
import com.qa.crmpro.testbase.testBase;
import com.qa.crmpro.util.testUtil;

public class loginPageTest extends testBase {
	
	//create the class references
	loginPage lp;
	homePage hp;
	testUtil util;
	boolean flag= true;
	Logger log= Logger.getLogger(loginPageTest.class);
	
	
	//create a constructor to access the base class properties
	public loginPageTest(){
		super(); 
	}
	
	@BeforeMethod
	public void setUp(){
		PropertyConfigurator.configure("log4j.properties");
		initialization();
		log.info("launched the browser");
		lp= new loginPage();
		util= new testUtil();
	}
	
	@Test
	public void loginToCRMPROApplicationTest(){
		log.info("**********************starting test case****************************************");
		log.info("**********************login to crmpro app****************************************");
		hp= lp.validateLoginToCRMPROApp(prop.getProperty("username"), prop.getProperty("password"));
		util.switchToFrame();
		flag= hp.isLoggedInUserNameInHomePageDisplayed();
		Assert.assertTrue(flag, "Logged in user is not displayed");
		log.warn("This is just a warning message");
		log.debug("This is debug message");
		log.info("**********************ending test case****************************************");
		log.info("**********************login to crmpro app****************************************");
	}
	
	@Test
	public void validateCRMPROWebPageTitleTest(){
		log.info("**********************starting test case****************************************");
		log.info("**********************crmpro title test****************************************");
		String loginPageTitle= lp.validateLoginPageTitle();
		Assert.assertEquals(loginPageTitle, "CRMPRO - CRM software for customer relationship management, sales, and support.");
		log.info("**********************ending test case****************************************");
		log.info("**********************crmpro title test****************************************");
	}
	
	@Test
	public void validateCRMPROLogoTest(){
		log.info("**********************starting test case****************************************");
		log.info("**********************crmpro logo test****************************************");
		flag= lp.validateIsCRMPROLogoDisplayed();
		Assert.assertTrue(flag, "CRMPRO logo on Login Page is not displayed");
		log.info("**********************ending test case****************************************");
		log.info("**********************crmpro logo test****************************************");
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
}

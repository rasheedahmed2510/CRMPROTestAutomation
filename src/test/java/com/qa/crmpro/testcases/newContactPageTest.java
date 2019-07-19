package com.qa.crmpro.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.qa.crmpro.pages.homePage;
import com.qa.crmpro.pages.loginPage;
import com.qa.crmpro.pages.newContactPage;
import com.qa.crmpro.testbase.testBase;
import com.qa.crmpro.util.testUtil;

public class newContactPageTest extends testBase{
	
	//create the page class references
	newContactPage ncp;
	homePage hp;
	loginPage lp;
	testUtil util;
	
	String sheetName="contactDetails";
	
	//create a constructor to access the testBase class properties
	public newContactPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		initialization();
		hp= new homePage();
		lp= new loginPage();
		ncp= new newContactPage();
		util= new testUtil();
		hp=lp.validateLoginToCRMPROApp(prop.getProperty("username"), prop.getProperty("password"));
		util.switchToFrame();
		//Thread.sleep(3000);
		WebElement contactsLink= driver.findElement(By.xpath("//a[contains(text(),'Contacts')]"));
		util.moveCursorToElement(contactsLink);
		WebDriverWait wait= new WebDriverWait(driver, 30);
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Contacts')]")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'New Contact')]")));
		ncp= hp.clickOnNewContactsLink();
	}
	
	/*@Test
	public void validateIsContactsInfoHeaderNameIsDisplayed(){
		boolean flag= ncp.isContactInfoHeaderNameDisplayed();
		Assert.assertTrue(flag, "Contacts Info Header Name is not displayed");
	}
	
	@Test
	public void getNewContactPageTitle(){
		String newContactPageTitle= ncp.getNewContactsPageTitle();
		Assert.assertEquals(newContactPageTitle, "CRMPRO");
	}*/
	
	@DataProvider
	public Object[][] getCRMContactDetailsTestData(){
		Object[][] data= util.getContactDetailsTestData(sheetName);
		return data;
	}
	
	@Test(dataProvider="getCRMContactDetailsTestData")
	public void validateCreateNewContact(String title, String firstName, String lastName, String company) throws InterruptedException{
		ncp.addANewContact(title, firstName, lastName, company);
		Thread.sleep(1000);
	}
	
	
	@AfterMethod
	public void tearDown(){
		util.logoutOfApp();
		driver.quit();
	}
	
}

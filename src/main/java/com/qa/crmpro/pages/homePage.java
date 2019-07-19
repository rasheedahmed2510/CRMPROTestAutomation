package com.qa.crmpro.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.crmpro.testbase.testBase;

public class homePage extends testBase{
	
	//Object Repository
	@FindBy(xpath="//td[contains(text(),'User:')]")
	WebElement loggedInUserName;
	
	@FindBy(xpath="//td[@class='logo_text']")
	WebElement crmproLogo;
	
	@FindBy(xpath="//a[contains(text(),'Contacts')]")
	WebElement contactsLink;
	
	@FindBy(xpath="//a[contains(text(),'Deals')]")
	WebElement dealsLink;
	
	@FindBy(xpath="//a[contains(text(),'Tasks')]")
	WebElement tasksLink;
	
	@FindBy(xpath="//a[contains(text(),'New Contact')]")
	WebElement newContactLink;
	
	//Create the constructor to load the properties from the base class
	public homePage(){
		PageFactory.initElements(driver, this);
	}
	
	//Action methods
	public String getHomePageTitle(){
		return driver.getTitle();
	}
	
	public boolean isCRMPROLogoInHomePageDisplayed(){
		return crmproLogo.isDisplayed();
	}
	
	public boolean isLoggedInUserNameInHomePageDisplayed(){
		return loggedInUserName.isDisplayed();
	}
	
	public String getLoggedInUserNameFromHomePage(){
		return loggedInUserName.getText();
	}
	
	public contactsPage clickOnContactsLink(){
		contactsLink.click();
		return new contactsPage();
	}
	
	public dealsPage clickOnDealsLink(){
		dealsLink.click();
		return new dealsPage();
	}
	
	public tasksPage clickOnTasksLink(){
		tasksLink.click();
		return new tasksPage();
	}
	
	public newContactPage clickOnNewContactsLink(){
		Actions act= new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("//a[contains(text(),'Contacts')]"))).build().perform();
		newContactLink.click();
		return new newContactPage();
	}
	
	
}

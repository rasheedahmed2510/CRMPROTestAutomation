package com.qa.crmpro.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qa.crmpro.testbase.testBase;
import com.qa.crmpro.util.testUtil;

public class newContactPage extends testBase{
	
	//Object Repositories
	@FindBy(xpath="//legend[contains(text(),'Contact Information')]")
	WebElement contactInfoHeaderName;
	
	@FindBy(xpath="//select[@name='title']")
	WebElement selectTitle;
	
	@FindBy(xpath="//input[@id='first_name']")
	WebElement firstName;
	
	@FindBy(xpath="//input[@id='surname']")
	WebElement lastName;
	
	@FindBy(xpath="//input[@name='client_lookup']")
	WebElement companyName;
	
	@FindBy(xpath="(//input[contains(@value, 'Save')])[1]")
	WebElement saveBtn;
	
	@FindBy(xpath="//a[contains(text(),'Logout')]")
	WebElement logoutBtn;
	
	//Create a constructor to define the current class object members
	public newContactPage(){
		PageFactory.initElements(driver, this);
	}
	
	//Define the actions
	public boolean isContactInfoHeaderNameDisplayed(){
		return contactInfoHeaderName.isDisplayed();
	}
	
	public String getNewContactsPageTitle(){
		return driver.getTitle();
	}
	
	public contactDetailsPage addANewContact(String title,String fn, String ln, String comp){
		Select sel= new Select(selectTitle);
		sel.selectByVisibleText(title);
		firstName.sendKeys(fn);
		lastName.sendKeys(ln);
		companyName.sendKeys(comp);
		saveBtn.click();
		return new contactDetailsPage();
	}
	
	
	
}

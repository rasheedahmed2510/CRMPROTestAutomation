package com.qa.crmpro.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.crmpro.testbase.testBase;

public class loginPage extends testBase{
	
	//Capture all the Object Repositories or Page Objects
	@FindBy(name="usernam")
	WebElement un;
	
	@FindBy(name="password")
	WebElement pwd;
	
	@FindBy(xpath="//input[@value='Login']")
	WebElement loginButton;
	
	@FindBy(xpath="//a[@class='navbar-brand']/img[@class='img-responsive']")
	WebElement crmproLogo;
	
	@FindBy(xpath="//a[contains(text(),'Sign Up')]")
	WebElement signUpLink;
	
	//Create a PageFactory to access the driver and current class object members
	public loginPage(){
		PageFactory.initElements(driver, this);
	}
	
	//Create the action methods
	public homePage validateLoginToCRMPROApp(String username, String password){
		un.clear();
		un.sendKeys(username);
		pwd.clear();
		pwd.sendKeys(password);
		loginButton.submit();
		return new homePage();
	}
	
	public String validateLoginPageTitle(){
		return driver.getTitle();
	}
	
	public boolean validateIsCRMPROLogoDisplayed(){
		return crmproLogo.isDisplayed();
	}
	
	
}

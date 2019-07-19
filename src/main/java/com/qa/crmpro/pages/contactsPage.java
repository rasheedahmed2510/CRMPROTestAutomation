package com.qa.crmpro.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.crmpro.testbase.testBase;

public class contactsPage extends testBase{
	
		//Object Repository
		@FindBy(xpath="//td[contains(text(),'Contacts')]")
		WebElement contactsHeaderName;
		
		//create a constructor to access the current class object members
		public contactsPage(){
			PageFactory.initElements(driver, this);
		}
		
		//Define the actions
		public boolean isContactsHeaderNameDisplayed(){
			return contactsHeaderName.isDisplayed();
		}
		
		public String getContactsPageTitle(){
			return driver.getTitle();
		}
		
		public void selectContactsByName(String name){
			driver.findElement(By.xpath("//a[text()='"+name+"']//parent::td[@class='datalistrow']//preceding-sibling::td[@class='datalistrow']"
					+ "//following-sibling::input[@name='contact_id']")).click();
		}
	
}

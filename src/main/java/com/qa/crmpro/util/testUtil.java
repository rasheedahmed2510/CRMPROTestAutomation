package com.qa.crmpro.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.qa.crmpro.testbase.testBase;

public class testUtil extends testBase {
	
	public static long IMPLICIT_WAIT=20;
	public static long PAGELOAD_TIMEOUT=20;
	
	public static String SHEET_PATH="D:\\BookMyShow Project\\CRMPROTestAuto\\src\\main\\java\\com\\qa\\crmpro\\testdata\\ContactDetailsData.xlsx";
	static Workbook book;
	static Sheet sheet;
	
	public static void switchToFrame(){
		driver.switchTo().frame(driver.findElement(By.name("mainpanel")));
	}
	
	public void moveCursorToElement(WebElement element){
		Actions act= new Actions(driver);
		act.moveToElement(element).build().perform();
	}
	
	public void logoutOfApp(){
		driver.findElement(By.xpath("//a[contains(text(),'Logout')]")).click();
	}
	
	public Object[][] getContactDetailsTestData(String sheetPath){
		try {
			FileInputStream file= new FileInputStream(SHEET_PATH);
			book= WorkbookFactory.create(file);
			sheet= book.getSheet("contactDetails");
			Object[][] data= new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
			for(int i=0; i< sheet.getLastRowNum(); i++){
				for(int k=0; k< sheet.getRow(0).getLastCellNum(); k++){
					data[i][k]= sheet.getRow(i+1).getCell(k).toString();
				}
			}
			return data;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (EncryptedDocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void takeScreenShot() throws IOException{
		TakesScreenshot t= (TakesScreenshot)driver;
		File src= t.getScreenshotAs(OutputType.FILE);
		String curentDir= System.getProperty("user.dir");
		FileUtils.copyFile(src, new File(curentDir+"/screenshots/"+System.currentTimeMillis()+".png"));
	}
	
}

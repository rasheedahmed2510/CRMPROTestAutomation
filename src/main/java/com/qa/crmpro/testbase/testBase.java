package com.qa.crmpro.testbase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.qa.crmpro.util.WebEventListener;
import com.qa.crmpro.util.testUtil;

public class testBase {
	
	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	
	//create a constructor and define to fetch the properties file data
	public testBase(){
		//Read the properties file
		try {
			prop= new Properties();
			FileInputStream ip= new FileInputStream(System.getProperty("user.dir")+"/src/main/java/com/qa/crmpro/config/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			//Exception when file not found
			e.printStackTrace();
		} catch (IOException e) {
			// IO Exception when not able to load the properties file
			e.printStackTrace();
		}
	}
	
	//Initialize the browser details
	public static void initialization(){
		String browserName= prop.getProperty("browser");
		if(browserName.equals("firefox")){
			System.setProperty("webdriver.gecko.driver", "D:\\Selenium Softwares\\Selenium jars\\New folder\\geckodriver-v0.24.0-win64\\geckodriver.exe");
			driver= new FirefoxDriver();
		}else if(browserName.equals("chrome")){
			System.setProperty("webdriver.chrome.driver", "D:\\Selenium Softwares\\Selenium jars\\New folder\\chromedriver_win32\\chromedriver.exe");
			ChromeOptions options= new ChromeOptions();
			options.addArguments("–no-sandbox");
			options.addArguments("–disable-dev-shm-usage");
			options.setExperimentalOption("useAutomationExtension", false);
			driver= new ChromeDriver(options);
		}
		
		//create an object reference for EventFiringWebDriver
		e_driver= new EventFiringWebDriver(driver);
		//now create an object for EventListenerHandler to register it with EventFiringWebDriver
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver=e_driver;
		
		//initialize other details such as maximize the browser, delete cookies, timeouts and url
		//driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(testUtil.PAGELOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(testUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
	}
	
}

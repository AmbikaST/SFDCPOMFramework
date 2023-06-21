package com.automation.base;

import java.io.File;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.automation.utility.Log4JUtility;
import com.automation.utility.PropertiesUtility;

import io.github.bonigarcia.wdm.WebDriverManager;


public class BaseTest {
	public static WebDriver driver = null;
	protected static WebDriverWait wait = null;
	//protected Log4JUtility logObject =Log4JUtility.getInstance();
	protected static Logger log;
	protected PropertiesUtility propUtility = PropertiesUtility.getInstance();
	
	@BeforeTest
	public void setUpForBeforeTest() {
		log=LogManager.getLogger(BaseTest.class.getName());
	}
	
	@BeforeMethod
	@Parameters("browserName")
	public void setUpBeforeTestMethod(@Optional("Chrome") String browserName) {
		Properties application = propUtility.loadFile("applicationDataProperties");
		String url = application.getProperty("url");
		launchBrowser(browserName);//"Chrome"
		goToURL(url);
	}
	
	@AfterMethod
	public void tearDownAfterTestMethod() {
		closeBrowser();
	}
	
	public static void launchBrowser(String browserName) {
		switch(browserName) {
		case "Chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			break;
		}
		log.info(browserName+" browser is opened");
		
	}
	
	public static void goToURL(String url) {
		driver.get(url);
		log.info(url+" is entered");
		
	}
	
	public static void closeBrowser() {
		driver.close();
		log.info("current browser is closed");
	}
	
	

	public File getScreenshotOfThePage(WebDriver driver2) {
		// TODO Auto-generated method stub
		return null;
	}
}

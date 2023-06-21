package com.automation.tests;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.automation.base.BaseTest;
import com.automation.pages.login.LoginPage;
import com.automation.utility.Constants;
import com.automation.utility.PropertiesUtility;


public class LoginTest extends BaseTest{
	protected static  LoginPage page;
	protected static PropertiesUtility propUtility = PropertiesUtility.getInstance();
	
	//Test ID TC-01
	@Test
	public static void sfdcEmptyPassword() {
		log.info("Test script TC-01 is started");
		page = new LoginPage(driver);
		String userId = page.loginValidUsername();
		String password = propUtility.getPropertyValue("login.empty.password");
		
		Assert.assertEquals(Constants.LOGINTITLE, page.getTitleOfThePage());
		page.enterUserName(userId);
		page.enterPassWord(password);
		page.clickButton();
		
		String expectedMsg = Constants.LOGINERRORMSG;
		String actualMsg = page.loginErrMsg("error");
		assertEquals(expectedMsg, actualMsg);
		
		log.info("Testscript TC-01 execution completed");
	}
	
	//Test ID TC-02
	@Test
	public static void sfdcvalidLogin(){
		log.info("Test script TC-02 is started");
		page = new LoginPage(driver);
		String userId = page.loginValidUsername();
		String password = page.loginValidPassword();
		
		Assert.assertEquals(Constants.LOGINTITLE, page.getTitleOfThePage());
		page.enterUserName(userId);
		page.enterPassWord(password);
		page.clickButton();
		Assert.assertEquals(Constants.HOMEPAGE, page.getTitleOfThePage());
		
		log.info("Testscript TC-02 execution completed");
	}
	
	//Test ID TC-03
	@Test
	public static void sfdcRememberCheck() throws InterruptedException{
		log.info("Test script TC-03 is started");
		page = new LoginPage(driver);
		String userId = page.loginValidUsername();
		String password = page.loginValidPassword();
		
		Assert.assertEquals(Constants.LOGINTITLE, page.getTitleOfThePage());
		page.enterUserName(userId);
		page.enterPassWord(password);
		page.rememberButton();
		page.clickButton();
		page.usrNavButton();
		page.clickusrDropDown();
		Assert.assertEquals(userId, page.identityText());
		
		log.info("Testscript TC-03 execution completed");
	}
	
	//Test ID TC-04A
	@Test
	public static void sfdcForgotPwd() {
		log.info("Test script TC-04A is started");
		page = new LoginPage(driver);
		String userId = page.loginValidUsername();
		page.enterUserName(userId);
		page.forgotLink();
		page.enterUsrNameForgot(userId);
		page.clickContinue();
		
		Assert.assertEquals(Constants.FORGOTPWD,page.getTitleOfThePage());
		
		log.info("Testscript TC-04A execution completed");
	}
	
	// Test ID	Forgot Password- 4 B
	@Test
	public static void sfdcInvalidLogin() {
		log.info("Test script TC-04B is started");
		page = new LoginPage(driver);
		String userId = page.loginInValidUsername();
		String password = page.loginInValidPassword();
		page.enterUserName(userId);
		page.enterPassWord(password);
		page.clickButton();
		String expectedMsg = Constants.INVALIDLOGINMSG;
		String actualMsg = page.loginErrMsg("error");
		assertEquals(expectedMsg, actualMsg);
		
		log.info("testscript TC04B execution completed");
	}

}

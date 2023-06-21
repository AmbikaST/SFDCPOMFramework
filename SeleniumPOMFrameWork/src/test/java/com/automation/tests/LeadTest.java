package com.automation.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.automation.base.BaseTest;
import com.automation.pages.lead.LeadPage;
import com.automation.utility.Constants;

public class LeadTest extends BaseTest{
	public static LeadPage leadPage ; 
	
	//Test ID TC-20
	@Test
	public static void sfdcLead() throws InterruptedException{
		log.info("Test Script TC-20 is started successfully");
		leadPage = new LeadPage(driver);
		leadPage.loginCerdentials();
		leadPage.clickLeadTabElement();
		Assert.assertEquals(Constants.LEADHOME, leadPage.getPageTitle());
		Thread.sleep(8000);
		leadPage.popupPage();
		leadPage.logout();
		log.info("Test Script TC-20 is executed successfully");
	}
	
	//Test ID TC-21
	@Test
	public static void sfdcLeadHome() throws InterruptedException{
		log.info("Test Script TC-21 is started successfully");
		leadPage = new LeadPage(driver);
		leadPage.loginCerdentials();
		leadPage.clickLeadTabElement();
		Assert.assertEquals(Constants.LEADHOME, leadPage.getPageTitle());
		Thread.sleep(8000);
		leadPage.popupPage();
		Thread.sleep(4000);
		leadPage.clickLeaddrop();
		leadPage.logout();
		log.info("Test Script TC-21 is executed successfully");
	}
	
	//Test ID TC-22
	@Test
	public static void sfdcLeadGo() throws InterruptedException{
		log.info("Test Script TC-22 is started successfully");
		leadPage = new LeadPage(driver);
		leadPage.loginCerdentials();
		leadPage.clickLeadTabElement();
		Assert.assertEquals(Constants.LEADHOME, leadPage.getPageTitle());
		Thread.sleep(8000);
		leadPage.popupPage();
		Thread.sleep(4000);
		leadPage.selectedFromDropDown();
		leadPage.logout();
		Thread.sleep(3000);
		leadPage.loginCerdentials();
		leadPage.clickLeadTabElement();
		leadPage.clickGoButton();
		Assert.assertEquals(Constants.LEADGO,leadPage.getPageTitle());
		
		log.info("Test Script TC-22 is executed successfully");
	}
	
	//Test ID TC-23
	@Test
	public static void sfdcTodayLead() throws InterruptedException{
		log.info("Test Script TC-23 is started successfully");
		leadPage = new LeadPage(driver);
		leadPage.loginCerdentials();
		leadPage.clickLeadTabElement();
		Assert.assertEquals(Constants.LEADHOME, leadPage.getPageTitle());
		Thread.sleep(8000);
		leadPage.popupPage();
		Thread.sleep(4000);
		leadPage.selectedFromDropDown();
		leadPage.clickGoButton();
		Assert.assertEquals(Constants.LEADGO,leadPage.getPageTitle());
		leadPage.logout();											
		log.info("Test Script TC-23 is executed successfully");
	}
	
	//Test ID TC-24
	@Test
	public static void sfdcLeadNewButtonCheck() throws InterruptedException{
		log.info("Test Script TC-24 is started successfully");
		leadPage = new LeadPage(driver);
		leadPage.loginCerdentials();
		leadPage.clickLeadTabElement();
		Assert.assertEquals(Constants.LEADHOME, leadPage.getPageTitle());
		Thread.sleep(8000);
		leadPage.popupPage();
		Thread.sleep(4000);
		leadPage.clickNewButton();
		
		Assert.assertEquals(Constants.LEADEDIT, leadPage.getPageTitle());
		
		leadPage.enterLastName();		
		leadPage.enterCompanyName();
		leadPage.saveButton();
		Assert.assertEquals(Constants.LEADNAME,leadPage.getPageTitle());
		leadPage.logout();
		log.info("Test Script TC-24 is executed successfully");
	}

}

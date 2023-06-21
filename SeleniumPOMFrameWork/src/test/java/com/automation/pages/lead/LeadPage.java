package com.automation.pages.lead;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.automation.pages.base.BasePage;
import com.automation.pages.login.LoginPage;

public class LeadPage extends BasePage{
	
	@FindBy(xpath = "//*[@id=\"Lead_Tab\"]") WebElement leadelem;
	@FindBy(id = "userNavButton") WebElement userNavDropDown;
	@FindBy(xpath = "//*[@id=\"userNav-menuItems\"]/a[5]") WebElement logoutElement;
	@FindBy(id = "username") WebElement userNameElement;
	@FindBy(id = "password") WebElement passwordElement;
	@FindBy(id = "Login") WebElement button;
	@FindBy(id = "tryLexDialogX") WebElement popupElement;
	@FindBy(xpath = "//*[@id=\"fcf\"]") WebElement leadHome;
	@FindBy(xpath = "//*[@id=\"filter_element\"]/div/span/span[1]/input")WebElement goElement;
	@FindBy(xpath = "//*[@id=\"hotlist\"]/table/tbody/tr/td[2]/input") WebElement newElement;
	@FindBy(id = "name_lastlea2") WebElement lastNameElement;
	@FindBy(id = "lea3") WebElement companyElement;
	@FindBy(xpath = "//*[@id=\"bottomButtonRow\"]/input[1]") WebElement saveElement;
	protected LoginPage page;
	
	public LeadPage (WebDriver driver) {
		super(driver);
		System.out.println("enter into leadpage");
	}
	
	public WebDriver loginCerdentials() {
		page = new LoginPage(driver);
		String userId = loginValidUsername();
		String password = loginValidPassword();
		page.enterUserName(userId);
		page.enterPassWord(password);
		return page.clickButton();
	}
	
	public void clickLeadTabElement(){
		System.out.println("clicking the lead tab");
		clickElement(leadelem, "Lead tab ");
	}
	
	public void logout() throws InterruptedException{
		Thread.sleep(5000);
		clickElement(userNavDropDown, "userNav Drop down");
		clickElement(logoutElement, "Log out ");
	}
	
	public void popupPage() {
		advertisementPage(popupElement);
	}
	
	public void clickLeaddrop() {
		dropDownMenu(leadHome);
	}
	
	public void selectedFromDropDown() {
		selectFromDropDown(leadHome,"Today's Leads");
	}
	
	public void clickGoButton() {
		clickElement(goElement, "Go Button ");
	}
	
	public void clickNewButton() {
		clickElement(newElement, "New Button");
	}
	
	public void enterLastName() {
		enterText(lastNameElement,"ABCD" , "last name ");
	}
	
	public void enterCompanyName() {
		enterText(companyElement,"ABCD", "Company name ");
	}
	
	public void saveButton() {
		clickElement(saveElement, "Save Button");
	}

}

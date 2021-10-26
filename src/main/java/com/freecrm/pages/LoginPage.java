package com.freecrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.freecrm.base.BasePage;
import com.freecrm.util.AppConstants;
import com.freecrm.util.ElementActions;

public class LoginPage {
	WebDriver driver;
	BasePage basePage;
	ElementActions elementActions;


	public LoginPage(WebDriver driver) {
		this.driver = driver;
		elementActions = new ElementActions(this.driver);
	}

	By freeCRMlogo = By.xpath("(//a[@class='brand-name'])[1]");
	By loginBtn = By.xpath("//span[contains(text(), 'Log In')]");

	public String doGetLoginPageTitle() throws InterruptedException {
		//Thread.sleep(3000);
		return elementActions.doGetPageTitle(AppConstants.LOGIN_PAGE_TITLE);
	}

	public boolean doFreeCRMLogoIsDisplayed() throws Exception {
		Thread.sleep(3000);
		elementActions.waitForElementPresent(freeCRMlogo);
		return elementActions.doIsDisplayed(freeCRMlogo);
	}

	public boolean doLogInIsDisplayed() {
		elementActions.waitForElementPresent(loginBtn);
		return elementActions.doIsDisplayed(loginBtn);
	}

	public void clickOnLoginBtn() {
		elementActions.waitForElementPresent(loginBtn);
		elementActions.doClick(loginBtn);
		//return new LandingPage(driver);
	}
}

package com.freecrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.freecrm.base.BasePage;
import com.freecrm.util.AppConstants;
import com.freecrm.util.ElementActions;

public class LandingPage {
	WebDriver driver;
	BasePage basePage;
	ElementActions elementActions;


	public LandingPage(WebDriver driver) {
		this.driver = driver;
		elementActions = new ElementActions(this.driver);
	}


	By email = By.xpath("//input[@placeholder='E-mail address']");
	By password = By.xpath("//input[@name='password']");
	By submitBtn = By.xpath("(//div[contains(text(),'Login')])[1]");
	By forgotPwdLink = By.xpath("//a[contains(text(),'Forgot your password?')]");
	By signUpLink = By.xpath("//a[contains(text(), 'Sign Up')]");

	public String doGetLoginPageTitle() throws InterruptedException {
		//Thread.sleep(3000);
		return elementActions.doGetPageTitle(AppConstants.LANDING_PAGE_TITLE);
	}

	public void loginWithInvalidCredentails(String username, String pwd) throws Exception {
		//	Thread.sleep(5000);
		elementActions.waitForElementPresent(email);
		elementActions.doSendKeys(email, username);
		elementActions.doSendKeys(password, pwd );
		elementActions.doClick(submitBtn);
	}

	public boolean forgotPasswordLinkIsDisplayed() throws Exception {
		Thread.sleep(5000);
		//elementActions.waitForElementPresent(forgotPwdLink);
		return elementActions.doIsDisplayed(forgotPwdLink);
	}

	public boolean signUpLinkIsDisplayed() {
		elementActions.waitForElementPresent(signUpLink);
		return elementActions.doIsDisplayed(signUpLink);
	}

}

package com.freecrm.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.freecrm.base.BaseTest;
import com.freecrm.util.AppConstants;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class LoginPageTest extends BaseTest{


	@Description("verify Login Page Title")
	@Severity(SeverityLevel.NORMAL)
	@Test(priority = 1 )
	public void verifyLoginPageTitle() throws Exception {
		String title = loginPage.doGetLoginPageTitle();
		System.out.println("Login Page title is : " + title);
		Assert.assertEquals(title, AppConstants.LOGIN_PAGE_TITLE);
	}


	@Description("Verify Free CRM Logo is dispalyed")
	@Severity(SeverityLevel.NORMAL)
	@Test(priority =2 )
	public void verifyFreeCRMLogoIsDisplayed() throws Exception {
		Assert.assertTrue(loginPage.doFreeCRMLogoIsDisplayed());
	}

	@Description("Verify Log In button is dispalyed")
	@Severity(SeverityLevel.NORMAL)
	@Test(priority =3 )
	public void verifyLogInBtnIsDisplayed() {
		Assert.assertTrue(loginPage.doLogInIsDisplayed());
	}

	@Description("Verify the functionality of Log In button on click of it")
	@Severity(SeverityLevel.NORMAL)
	@Test(priority =4 )
	public void verifyLogInBtnlick() {
		loginPage.clickOnLoginBtn();
	}
	

}

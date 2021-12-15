package com.freecrm.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.freecrm.base.BaseTest;
import com.freecrm.util.AppConstants;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class LandingPageTest extends BaseTest{

	@Description("verify Landing Page Title")
	@Severity(SeverityLevel.CRITICAL)
	@Test(priority = 1 )
	public void verifyLandingPageTitle() throws Exception {
		loginPage.clickOnLoginBtn();
		Thread.sleep(5000);
		String title = landingPage.doGetLoginPageTitle();
		System.out.println("Landing Page title is : " + title);
		Assert.assertEquals(title, AppConstants.LANDING_PAGE_TITLE);
	}
	
	@Description("Verify Forgot Password Link is dispalyed")
	@Severity(SeverityLevel.CRITICAL)
	@Test(priority =2 )
	public void verifyForgotPasswordLinkIsDisplayed() throws Exception {
		Assert.assertTrue(landingPage.forgotPasswordLinkIsDisplayed());
	}

	@Description("Verify SignUp Link is dispalyed")
	@Severity(SeverityLevel.CRITICAL)
	@Test(priority =3 )
	public void verifySignUpLinkIsDisplayed() {
		Assert.assertTrue(landingPage.signUpLinkIsDisplayed());
	}
	
	@Description("verify login to app with Invalid Credentails")
	@Severity(SeverityLevel.NORMAL)
	@Test(priority = 4 )
	public void verifyLoginWithInvalidCredentails() throws Exception {
		landingPage.loginWithInvalidCredentails("test@gmail.com", "Test@1234" );
		Thread.sleep(5000);
	}

	
}

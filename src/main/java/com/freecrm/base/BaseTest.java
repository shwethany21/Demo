package com.freecrm.base;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;

import com.freecrm.pages.LandingPage;
import com.freecrm.pages.LoginPage;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

public class BaseTest extends BasePage{

	WebDriver driver;
	Properties prop;
	BasePage basePage;
	protected LoginPage loginPage;
	protected LandingPage landingPage;


	@BeforeTest
	public void setUp() throws Exception {
		basePage = new BasePage();
		prop = basePage.init_prop();
		driver =  basePage.init_driver(prop);
		loginPage = new LoginPage(driver);
		landingPage = new LandingPage(driver);
	}


	@AfterTest
	public void tearDown() {
		getDriver().quit();
	}

}
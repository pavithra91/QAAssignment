package com.qa.test;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{
	
	Logger log = Logger.getLogger(LoginPageTest.class);
	LoginPage login;
	HomePage home;
	
	public LoginPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialitation();
		login = new LoginPage();
		
	}
	
	@Test(priority = 1)
	public void LoginPageTitleTest() {
		log.info("****************************** Starting test cases execution  *****************************************");
		log.info("****************************** Starting Login Page Title Test  ****************************************");
		String title = login.ValidatePageTitles();
		Assert.assertEquals(title, "actiTIME - Login");
	}
	
	@Test(priority = 2)
	public void ValidateLoginTest() {
		log.info("****************************** Starting test cases execution  *****************************************");
		log.info("****************************** Starting Validate Login Test  ******************************************");
		home = login.ValidateLogin("admin", "manager");
	}
	
	@AfterMethod
	public void Dispose() {
		driver.quit();
	}

}

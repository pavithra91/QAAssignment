package com.qa.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.pages.ReportsPage;

public class ReportsPageTest extends TestBase{

	LoginPage login;
	HomePage home;
	ReportsPage reports;
	
	public ReportsPageTest() {
		super();
	}
	
	@BeforeMethod
	public void SetUp() {
		initialitation();
		reports = new ReportsPage();
		login = new LoginPage();
		home = login.ValidateLogin("admin", "manager");
		reports = home.ClickOnReportsLink();
	}
	
	@Test(priority =1)
	public void VerifyUserTitleLableTest() {
		Assert.assertTrue(reports.VerifyUserTitleLable(), "Users Page title is missing");
	}
	@Test(priority =2)
	public void GenerateLeaveReport() {
		Assert.assertTrue(reports.GenerateLeaveReport(), "Error Generating the Leave Report");
	}
	
	@AfterMethod
	public void Dispose() {
		driver.quit();
	}
}

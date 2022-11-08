package com.qa.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.ApproveTimePage;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.pages.UsersPage;
import com.qa.pages.ReportsPage;

public class HomePageTest extends TestBase{

	LoginPage login;
	HomePage homePage;
	UsersPage usersPage;
	ReportsPage reports;
	ApproveTimePage approveTimeTrack;

	
	public HomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void SetUp() {
		initialitation();
		login = new LoginPage();
		usersPage = new UsersPage();
		homePage = login.ValidateLogin("admin", "manager");
	}
	
	@Test(priority = 1)
	public void VerifyPageTitleTest() {
		String title = homePage.VerifyHomePageTitle();
		Assert.assertEquals(title, "actiTIME - Login","Home Page title not Matched");
	}
	
	@Test(priority = 2)
	public void ClickOnUsersLink() {
		usersPage = homePage.ClickOnUsersLink();
	}
	
	@Test(priority = 3)
	public void ClickOnApproveTimeTrackLink() {
		approveTimeTrack = homePage.ClickOnApproveTimeLink();
	}
	
	@Test(priority = 4)
	public void ClickOnReportLink() {
		reports = homePage.ClickOnReportsLink();
	}
	
	
	@AfterMethod
	public void Dispose() {
		driver.quit();
	}
}

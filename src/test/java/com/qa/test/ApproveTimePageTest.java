package com.qa.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.util.TestUtil;
import com.qa.pages.ApproveTimePage;

public class ApproveTimePageTest extends TestBase{

	LoginPage login;
	HomePage home;
	ApproveTimePage time;
	String sheetName = "ApproveTime";
	
	public ApproveTimePageTest() {
		super();
	}
	
	@BeforeMethod
	public void SetUp() {
		initialitation();
		time = new ApproveTimePage();
		login = new LoginPage();
		home = login.ValidateLogin("admin", "manager");
		time = home.ClickOnApproveTimeLink();
	}
	
	@DataProvider
	public Object[][] getTestDataFromExcel() {
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}
	
	@Test(priority =1)
	public void VerifyUserTitleLableTest() {
		Assert.assertTrue(time.VerifyApproveTimeTrackTitleLabel(), "Users Page title is missing");
	}
	
	@Test(priority =2, dataProvider="getTestDataFromExcel")
	public void ApproveTime(String name, String date) {
		boolean flag = time.ApproveTimeTrack(name, date);
		Assert.assertTrue(flag, "Test Failed");
	}
	
	@AfterMethod
	public void Dispose() {
		driver.quit();
	}
}

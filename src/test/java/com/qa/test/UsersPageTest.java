package com.qa.test;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.qa.base.TestBase;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.pages.UsersPage;

public class UsersPageTest extends TestBase {

	LoginPage login;
	HomePage home;
	UsersPage user;
	
	public UsersPageTest() {
		super();
	}
	
	@BeforeMethod
	public void SetUp() {
		initialitation();
		user = new UsersPage();
		login = new LoginPage();
		home = login.ValidateLogin("admin", "manager");
		user = home.ClickOnUsersLink();
	}
	
	@Test(priority =1)
	public void VerifyUserTitleLableTest() {
		Assert.assertTrue(user.VerifyUserTitleLable(), "Users Page title is missing");
	}
	
	@Test(priority =2)
	public boolean SelectUserByName(String fName, String lName) {
		String displayName = lName + ", " + fName;
		String fullName = fName + " " + lName;
		
		//driver.findElement(By.xpath("//span[text()='"+displayName+"']"));
		
		WebElement valueFromDropDown = driver.findElement(By.xpath("//span[text()='"+displayName+"']"));
		
		Actions action = new Actions(driver);
		action.moveToElement(valueFromDropDown).build().perform();
		valueFromDropDown.click();
		
		WebElement fullNameWebElement = driver.findElement(By.xpath("//div[text()='"+fullName+"']"));
		return fullNameWebElement.isDisplayed();
	}
	
	@AfterMethod
	public void Dispose() {
		driver.quit();
	}
}

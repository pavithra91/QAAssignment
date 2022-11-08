package com.qa.pages;

import com.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends TestBase{

		@FindBy(name="username")
		@CacheLookup
		WebElement username;
		
		@FindBy(name="pwd")
		@CacheLookup
		WebElement pwd;
		
		@FindBy(id="loginButton")
		@CacheLookup
		WebElement loginBtn;
		
		public LoginPage() {
			PageFactory.initElements(driver, this);
		}
		
		public String ValidatePageTitles() {
			return driver.getTitle();
		}
		public HomePage ValidateLogin(String userName, String Password) {
			username.sendKeys(userName);
			pwd.sendKeys(Password);
			loginBtn.click();
			
			return new HomePage();
		}
}

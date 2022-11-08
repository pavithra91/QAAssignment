package com.qa.pages;

import com.qa.base.TestBase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends TestBase{
	
	@FindBy(xpath="//a[contains(text(),'Approve Time-Track')]")
	@CacheLookup
	WebElement approveTimeLink;
	
	@FindBy(xpath="//a[contains(@class,'content users')]")
	@CacheLookup
	WebElement usersLink;
	
	@FindBy(xpath="//a[contains(@class,'content reports')]")
	@CacheLookup
	WebElement reportsLink;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String VerifyHomePageTitle() {
		return driver.getTitle();
	}
	
	public ApproveTimePage ClickOnApproveTimeLink() {
		
		WebElement element = driver.findElement(By.xpath("//a[contains(text(),'Approve Time-Track')]"));
		Actions action = new Actions(driver);
		action.moveToElement(element).click().build().perform();
		
		approveTimeLink.click();
		return new ApproveTimePage();
	}
	
	public UsersPage ClickOnUsersLink() {
		usersLink.click();
		return new UsersPage();
	}
	
	public ReportsPage ClickOnReportsLink() {
		reportsLink.click();
		return new ReportsPage();
	}
}

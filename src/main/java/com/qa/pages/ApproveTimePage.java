package com.qa.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class ApproveTimePage extends TestBase{
	
	@FindBy(xpath="//td[text()='Approve Time-Track']")
	@CacheLookup
	WebElement ApproveTimeTrackLabel;
	
	@FindBy(xpath="//input[@placeholder='Start typing name']")
	@CacheLookup
	WebElement searchUser;
	
	@FindBy(xpath="//div[contains(@class,'changeStatusButton approveButton')]")
	@CacheLookup
	WebElement approveTimebtn;
	
	public ApproveTimePage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean VerifyApproveTimeTrackTitleLabel() {
		return ApproveTimeTrackLabel.isDisplayed();
	}
	
	public boolean ApproveTimeTrack(String name, String date) {
	
		searchUser.sendKeys(name);
				
		WebElement valueFromDropDown = driver.findElement(By.xpath("//a[text()='"+date+"']"));
		Actions action = new Actions(driver);
		action.moveToElement(valueFromDropDown).click().build().perform();
				
		WebElement element = driver.findElement(By.xpath("(//td//div[@class='changeStatusButton approveButton'])[1]"));
		Actions actions = new Actions(driver);
		actions.moveToElement(element).click().build().perform();
		
		
		return true;
	}

}

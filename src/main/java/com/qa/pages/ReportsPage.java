package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class ReportsPage extends TestBase{
	
	@FindBy(xpath="//td[text()='Reports Dashboard']")
	@CacheLookup
	WebElement reportsPageLabel;
	
	@FindBy(xpath="//a[text()='Leave Time & Balances']")
	@CacheLookup
	WebElement leaveReportLink;
	
	
	@FindBy(xpath="//div[@class='dateRangeTitile']")
	@CacheLookup
	WebElement lbl;
	
	public ReportsPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean VerifyUserTitleLable() {
		return reportsPageLabel.isDisplayed();
	}
	
	public boolean GenerateLeaveReport() {
		
		
		driver.findElement(By.id("ext-gen25")).click();
		
		WebElement valueFromDropDown = driver.findElement(By.xpath("//div[@id='ext-gen30']"));
		Actions action = new Actions(driver);
		action.moveToElement(valueFromDropDown).click().build().perform();
		
		WebElement value = driver.findElement(By.xpath("//a[@id='ext-gen151']"));
		Actions action2 = new Actions(driver);
		action2.moveToElement(value).click().build().perform();
		
		return lbl.isDisplayed();
		
	}
}

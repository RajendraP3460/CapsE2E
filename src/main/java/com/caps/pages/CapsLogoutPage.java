package com.caps.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CapsLogoutPage {
	
	WebDriver driver;
	
	By logoutMessage = By.xpath("//p[contains(text(),'You have been logged out of the system!')]");
	By login = By.id("login");
	
	
	public CapsLogoutPage(WebDriver driver) {
		
		this.driver = driver;
	}
	
	// Click on Login button
	
	public void clickLogin() {
		
		driver.findElement(login).click();
	}
	
	public String getLogoutMessage(){

	     return    driver.findElement(logoutMessage).getText();

	}

}

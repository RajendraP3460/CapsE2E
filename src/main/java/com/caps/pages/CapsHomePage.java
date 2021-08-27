package com.caps.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CapsHomePage {
	
	WebDriver driver;
	
	By announcements = By.xpath("//h3[contains(text(),'Announcements')]");
	By logout = By.xpath("//*[@id=\"navbarsItems\"]/div[2]/div[2]/a");
	By userProfile = By.xpath("//*[@id=\"navbarsItems\"]/div[2]/div[1]/a");
	By userName = By.xpath("//wes-home[@class='ng-star-inserted']/div/h1");
	By capsMessage = By.xpath("//wes-home[@class='ng-star-inserted']/div/h2");

	public CapsHomePage(WebDriver driver) {
		
		this.driver = driver;
	}
	
	//Get the Announcement name from Home Page

    public String getHomePageAnnouncement(){

     return    driver.findElement(announcements).getText();

    }
    
    // click on Logout
    
    public void clickLogout() {
    	
    	driver.findElement(logout).click();
    }
	

}

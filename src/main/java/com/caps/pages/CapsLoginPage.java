package com.caps.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CapsLoginPage {
	
	WebDriver driver;
	
	By emailAddress = By.id("UserID");
	By password = By.id("Password");
	By signIn  = By.xpath("//*[@type='submit']");
	By forgotPWD = By.linkText("Forgot Password?");
	By createAccount = By.linkText("Create Account");
	By manageAccount = By.linkText("Manage Account");
	By totalLinks = By.tagName("a");
	
	
	public CapsLoginPage(WebDriver driver) {
		
		this.driver = driver;
	}
	
	//Set user name in textbox

    public void setEmailAddress(String strEmailAddress){

        driver.findElement(emailAddress).sendKeys(strEmailAddress);

    }
	
	// Set password in the textbox
    
    public void setPassword(String strPassword) {
    	
    	driver.findElement(password).sendKeys(strPassword);
    }
    
    
    // Click on SignIn button
    
    public void clickSignIn() {
    	
    	driver.findElement(signIn).click();
    }
    
    /**

     * This POM method will be exposed in test case to login in the application

     * @param strUserName

     * @param strPasword

     * @return

     */
    
    public void loginCaps(String strEmailAddress, String strPassword) {
    	
    	this.setEmailAddress(strEmailAddress);
    	this.setPassword(strPassword);
    	this.clickSignIn();
    }



}

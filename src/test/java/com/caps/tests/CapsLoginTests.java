package com.caps.tests;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

import com.caps.pages.CapsHomePage;
import com.caps.pages.CapsLoginPage;
import com.caps.pages.CapsLogoutPage;
import com.caps.utilities.BaseConfiguration;

public class CapsLoginTests extends BaseConfiguration {

	CapsLoginPage capsLogin;
	CapsHomePage capsHome;
	CapsLogoutPage capsLogout;
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(BaseConfiguration.class.getName());
	
	@BeforeTest
	public void invokeDriver() throws IOException {
		
		// launch Chrome and direct it to the Base URL
		driver = initializeDriver();
		//driver.get(prop.getProperty("url"));
		driver.get(prop.getProperty("produrl"));
		
	}

	@Test
	public void verifyCAPSLogin() {

	
		WebDriverWait wait = new WebDriverWait(driver, 20);

		/**
		 * 
		 * This test case will login in https://msswvw-acswesv1.csc.nycnet/caps/
		 * 
		 * Verify login page title
		 * 
		 * Login to application
		 * 
		 * Verify the home page using Dashboard message
		 * 
		 */

		//System.out.println("Title of CAPS: " + driver.getTitle());
		log.info("Title of CAPS: " + driver.getTitle());
		String title = driver.getTitle();

		try {

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Forgot Password?")));
		} catch (Exception e) {

			System.out.print(e.getMessage());
		}

		capsLogin = new CapsLoginPage(driver);

		//capsLogin.loginCaps(prop.getProperty("Email"), prop.getProperty("pwd"));
		capsLogin.loginCaps(prop.getProperty("ProdProgramEmail"), prop.getProperty("ProdProgrampwd"));

		try {

			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@id=\"spinnerId\"]/div/div[1]")));
		} catch (Exception e) {

			System.out.print(e.getMessage());
		}

		capsHome = new CapsHomePage(driver);

		if (capsHome.getHomePageAnnouncement().equalsIgnoreCase("Announcements")) {
			//System.out.println("Login success");
			log.info("Login success");
		} else {
			//System.out.println("Login is not success");
			log.error("Login is not success");
		}

		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			
			log.info(e);
		}

		// //wes-home[@class='ng-star-inserted']/div/h1

		/*
		 * capsHome.clickLogout();
		 * 
		 * try{
		 * 
		 * wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(
		 * "//*[@id=\"spinnerId\"]/div/div[1]"))); } catch (Exception e){
		 * 
		 * System.out.print(e.getMessage()); }
		 * 
		 * capsLogout =new CapsLogoutPage(driver);
		 * 
		 * if (capsLogout.getLogoutMessage().
		 * equalsIgnoreCase("You have been logged out of the system!")) {
		 * System.out.println("Logout success"); } else {
		 * System.out.println("Logout is not success"); }
		 * 
		 * capsLogout.clickLogin();
		 * 
		 * if(driver.getTitle().equals(title)) {
		 * System.out.println("Login screen is dislayed successfully"); }else {
		 * System.out.
		 * println("Login screen is not dislayed after clicking on Login button"); }
		 * 
		 * driver.close();
		 */

	}

	@AfterTest
	public void closeBrowser() {

		driver.close();
		log.info("Browser Instance is closed successfully");
	}

}

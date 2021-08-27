package com.caps.tests;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.AfterTest;

import com.caps.pages.CapsHomePage;
import com.caps.pages.CapsLoginPage;
import com.caps.pages.CapsLogoutPage;
import com.caps.utilities.BaseConfiguration;

public class CapsMultiLoginTests extends BaseConfiguration {

	CapsLoginPage capsLogin;
	CapsHomePage capsHome;
	CapsLogoutPage capsLogout;

	@Test(dataProvider="getData")

	public void verifyCAPSMultiLogin(String Username,String Password) throws IOException {

		// launch Chrome and direct it to the Base URL
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));

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

		System.out.println("Title of CAPS: " + driver.getTitle());
		String title = driver.getTitle();

		try {

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Forgot Password?")));
		} catch (Exception e) {

			System.out.print(e.getMessage());
		}

		capsLogin = new CapsLoginPage(driver);

		capsLogin.loginCaps(Username, Password);

		try {

			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@id=\"spinnerId\"]/div/div[1]")));
		} catch (Exception e) {

			System.out.print(e.getMessage());
		}

		capsHome = new CapsHomePage(driver);

		if (capsHome.getHomePageAnnouncement().equalsIgnoreCase("Announcements")) {
			System.out.println("Login success");
		} else {
			System.out.println("Login is not success");
		}

		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			System.out.println(e);
		}

		driver.close();

	}

	//@AfterTest
	public void afterTest() {

		driver.close();
	}
	
	@DataProvider
	public Object[][] getData()
	{
		
		Object[][] data=new Object[2][2];
		//0th row
		data[0][0]="rajendra.qtp9@gmail.com";
		data[0][1]="Test123$";
		
		//1st row
		data[1][0]="rajendra.palleti6@gmail.com";
		data[1][1]="Test123$";
		
		
		return data;
	}

}

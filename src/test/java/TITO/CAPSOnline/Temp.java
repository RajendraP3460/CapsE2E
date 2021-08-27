package TITO.CAPSOnline;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.log4j.*;

public class Temp {
	
	public String baseURL = "http://demo.guru99.com/test/newtours/";
	public WebDriver driver;
	String driverPath = "C:\\Automation\\Selenium\\Latest_Dirvers\\chromedriver.exe";
	private static Logger log =LogManager.getLogger(Temp.class.getName());
	
  @BeforeTest
  public void beforeTest() {
	  
	    System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	  }
  
  @Test
  public void verifyHomepageTitle() {
	  
	  //System.out.println("launching Application");
	  log.info("launching Application");
	  driver.get(baseURL);
	  
	  //System.out.println("After Capturing the Title");
	  log.info("launching Application");
	  String expectedTitle = "Welcome: Mercury Tours";
	  String actualTitle = driver.getTitle();
	  Assert.assertEquals(actualTitle, expectedTitle);
	  //System.out.println("Verified Title of Application");
	  log.info("Verified Title of Application");
	  log.debug("Test Debug Message");
	  log.error("Test Error MEssage");
	  
  }
  
  @Test
  public void secondTest(){
	  System.out.println("This is Second Test");
  }
 

  @AfterTest
  public void afterTest() {
	  
	  driver.close();
  }

}

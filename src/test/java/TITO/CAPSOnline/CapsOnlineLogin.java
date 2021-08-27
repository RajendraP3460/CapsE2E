package TITO.CAPSOnline;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
//import org.apache.commons.io.FileUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CapsOnlineLogin {
	
public static void main(String[] args) {
		
		
		System.setProperty("webdriver.chrome.driver","C:\\Automation\\Selenium\\Latest_Dirvers\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
        
        WebDriverWait wait=new WebDriverWait(driver, 20);
		
		String baseUrl = "https://msswvw-acswesv1.csc.nycnet/caps/";
		
		// launch Chrome and direct it to the Base URL 
        driver.get(baseUrl);
      /*  
        File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
			FileUtils.copyFile(src, new File("C:\\Automation\\abc.png"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}*/
        
        System.out.println("Title of CAPS: " + driver.getTitle());
        
        try{ 
			  
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Forgot Password?"))); 
		  } catch (Exception e){
			  
			  		System.out.print(e.getMessage()); 
		  }
		
		  driver.findElement(By.id("UserID")).sendKeys("rajendra.qtp9@gmail.com");
		  driver.findElement(By.id("Password")).sendKeys("Test123$");
		  driver.findElement(By.xpath("//*[@type='submit']")).click();
		 
        
        //driver.findElement(By.linkText("Forgot Password?")).click();
         
		
		  try{ 
			  
			  wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@id=\"spinnerId\"]/div/div[1]"))); 
		  } catch (Exception e){
			  
			  		System.out.print(e.getMessage()); 
		  }
		  
		  String announcement = driver.findElement(By.xpath("//h3[contains(text(),'Announcements')]")).getText();
		  System.out.println(announcement); 
		  
		  if (announcement.equalsIgnoreCase("Announcements")) {
			  System.out.println("Login success");
		  } else {
			  System.out.println("Login is not success");
		  }
		  
		  String userName = driver.findElement(By.xpath("//wes-home[@class='ng-star-inserted']/div/h1")).getText();
		  String capsMessage = driver.findElement(By.xpath("//wes-home[@class='ng-star-inserted']/div/h2")).getText();
		  
		  System.out.println("UserName: " + userName);
		  System.out.println("Home Screen Message: " + capsMessage);
		  
		  String[] userName1 = userName.split("\\s");
		  for(String s :userName1) {
			  System.out.println(s);
		  }
			
			/*
			 * WebElement logout =
			 * driver.findElement(By.xpath("//*[@id=\"navbarsItems\"]/div[2]/div[2]/a"));
			 * WebElement userprofile =
			 * driver.findElement(By.xpath("//*[@id=\"navbarsItems\"]/div[2]/div[1]/a"));
			 * 
			 * 
			 * try { Thread.sleep(2000); } catch (Exception e) { System.out.println(e); }
			 * 
			 * // User Profile Elements
			 * 
			 * userprofile.click();
			 * 
			 * String myprofile =
			 * driver.findElement(By.xpath("//button[contains(text(),'MY USER PROFILE')]")).
			 * getText(); System.out.println(myprofile);
			 * 
			 * try{
			 * 
			 * wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(
			 * "//*[@id=\"spinnerId\"]/div/div[1]"))); } catch (Exception e){
			 * 
			 * System.out.print(e.getMessage()); }
			 * 
			 * WebElement language = driver.findElement(By.id("UserLanguage")); Select
			 * languagedd = new Select(language); System.out.println("Default Option: " +
			 * languagedd.getFirstSelectedOption().getText()); languagedd.selectByIndex(2);
			 */
			 
		  
		  //driver.findElement(By.xpath("//button[contains(text(),'Save')]")).click();
		  
			/*
			 * if (myprofile.equalsIgnoreCase(" MY USER PROFILE ")) {
			 * System.out.println("User Profile Screen is displayed"); } else {
			 * System.out.println("User Profile Screen is not displayed"); }
			 */
		 
		  /*
		  logout.click();
		  
		  try{ 
			  
			  wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@id=\"spinnerId\"]/div/div[1]"))); 
		  } catch (Exception e){
			  
			  		System.out.print(e.getMessage()); 
		  }
		 
		  String logoutmsg = driver.findElement(By.xpath("//p[contains(text(),'You have been logged out of the system!')]")).getText();
		  
		  
		  if (logoutmsg.equalsIgnoreCase("You have been logged out of the system!")) {
			  System.out.println("Logout success");
		  } else {
			  System.out.println("Logout is not success");
		  }
		
          driver.close();
          */
		  
		/*
		 * System.out.println(logout.isDisplayed());
		 * System.out.println(logout.isEnabled());
		 */

	}

}

package com.caps.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BaseConfiguration {
	
	public static WebDriver driver;
	public Properties prop;
	
	public WebDriver initializeDriver() throws IOException
	{
		
	prop= new Properties();
	FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+ "\\resources\\info.properties");

	prop.load(fis);
	//String browserName=System.getProperty("browser");
	String browserName=prop.getProperty("browser");
	System.out.println(browserName);

	if(browserName.equals("chrome"))
	{
		 System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+ "\\resources\\chromedriver.exe");
		 ChromeOptions options = new ChromeOptions();
		 options.addArguments("--headless");
		driver= new ChromeDriver();
		//driver= new ChromeDriver(options);
			
		
	}
	else if (browserName.equals("firefox"))
	{
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+ "\\resources\\geckodriver.exe"); 
		driver= new FirefoxDriver();
		
	}
	else if (browserName.equals("ie"))
	{
   		
		System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+ "\\resources\\IEDriverServer.exe"); 
		driver= new InternetExplorerDriver();
	}
	else if (browserName.equals("edge"))
	{
		System.setProperty("webdriver.edge.driver", System.getProperty("user.dir")+ "\\resources\\msedgedriver.exe");
		driver = new EdgeDriver();
	}
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	return driver;
	
	}
	
	public String getScreenShotPath(String testCaseName,WebDriver driver) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot) driver;
		File source =ts.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";
		FileUtils.copyFile(source,new File(destinationFile));
		return destinationFile;


	}

}

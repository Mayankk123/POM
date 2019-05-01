package com.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;

import com.qa.util.TestUtil;
import com.qa.util.WebEventListener;

public class Base_Test {
	
	public static WebDriver driver;
	public static Properties prop;
	public static JavascriptExecutor jse;
	public static EventFiringWebDriver efire_driver;
	public static WebEventListener eventlistener;

	public Base_Test() 
	{
		try {
			  prop = new Properties();
			
			  FileInputStream ip = new FileInputStream("C:\\Users\\Concretio\\eclipse-workspace\\test_maven"
			 + "\\src\\main\\java\\com\\qa\\config\\config.properties");
			
			prop.load(ip);
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}
	
	public static void initilization()
	{
		String browsername = prop.getProperty("browser");
		
		if(browsername.equals("chrome"))
				{
			      System.setProperty("webdriver.chrome.driver", "C:\\Users\\Concretio\\Desktop\\eclipse\\chromedriver.exe");
			      driver=new ChromeDriver();
				}
		
		   else if(browsername.equals("FF"))
		      {
	             System.setProperty("webdriver.gecko.driver", "C:\\Users\\Concretio\\Desktop\\eclipse\\geckodriver.exe");
	             driver=new FirefoxDriver();
		      }
		
		 efire_driver = new EventFiringWebDriver(driver);
		 eventlistener =new WebEventListener();
		 efire_driver.register(eventlistener);
		 driver = efire_driver;
		
		 driver.manage().window().maximize();
		 driver.manage().deleteAllCookies();
		 driver.manage().timeouts().implicitlyWait(TestUtil.implicitwait,TimeUnit.SECONDS);
		 driver.get(prop.getProperty("url"));
		 driver.manage().timeouts().pageLoadTimeout(TestUtil.pageloadtime,TimeUnit.SECONDS);
	}	
	
	public static void scroll()
	{
		  try {
			jse=(JavascriptExecutor)driver;  
		    jse.executeScript("scroll(0,700)");
			  Thread.sleep(3000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
	 }
}
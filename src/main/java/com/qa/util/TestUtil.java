package com.qa.util;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.qa.base.Base_Test;

public class TestUtil extends Base_Test {

	public static long implicitwait = 20;
	public static long pageloadtime = 10;
	
	public void switch_to_frame()
	{
		driver.switchTo().frame(prop.getProperty("framename"));
	}
	
	public static void takescreenshots() throws IOException
	{
	 File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	  
     //String address = System.getProperty("C:\\Users\\Concretio\\Desktop\\Selenium Files"
     	//	           + "\\ScreenShot\\screenshot.png");
		
	 FileUtils.copyFile(src,new File("C:\\Users\\Concretio\\Desktop\\Selenium Files"
	           + "\\ScreenShot\\screenshot.png"));	        
	}
	
}

package com.qa.test;

import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.qa.base.Base_Test;
import com.qa.pages.Index_Page;
import com.qa.pages.Signin_Page;
import com.qa.util.TestData_Excel;

public class Signin_Page_Test extends Base_Test 
{
	Index_Page index;
	Signin_Page signin;
	String sheetname ="testdata";
	public Signin_Page_Test()
	{
		super();
	}
	@BeforeClass
	public void setup()
	{
		initilization();
		driver.findElement(By.xpath("//div[@class='header_user_info'and//a[@class='login']]")).click();
	}
	
	@DataProvider
	public Object[][] get_Signin_Data()
	{
		Object data[][] = TestData_Excel.getTestData(sheetname);
		return data;
	}
	
	@Test(dataProvider = "get_Signin_Data")
	public void validate_signin(String userid, String pasword)
	{	
		//signin.getTestData("userid", "pasword");
		
		signin.getTestData(userid,pasword);
	}
	@AfterClass
	public void exit()
	{
		driver.quit();
	}
}

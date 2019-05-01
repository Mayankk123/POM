package com.qa.pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.Base_Test;

public class Signin_Page extends Base_Test 
{
	@FindBy(xpath = "//input[@id='email']")
	WebElement userId;
	
	@FindBy(xpath = "//input[@id='passwd']")
	WebElement password;
	
	@FindBy(name = "Sign in")
	WebElement signin;
	
    public Signin_Page()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void getTestData(String userid,String pasword)
	{
		userId.sendKeys(userid);
		password.sendKeys(pasword);
		signin.click();
	}
	
}

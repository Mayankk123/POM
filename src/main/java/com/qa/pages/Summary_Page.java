package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.Base_Test;

public class Summary_Page extends Base_Test 
{
	
	@FindBy(xpath = "//a[@class='button btn btn-default standard-checkout button-medium'and"
			+ " @href='http://automationpractice.com/index.php?controller=order&step=1']")
	
	WebElement proceed_to_checkout;
	
	public Summary_Page()
	{
		PageFactory.initElements(driver, this);
	}
	
	 public String verifysummarytitle_test()
	{
		String summarytitle = driver.getTitle();
		return summarytitle;
	}	
	 
	 public Signin_Page proceed_checkout()
	 {
		 proceed_to_checkout.click();
		 return new Signin_Page();
	 }

}

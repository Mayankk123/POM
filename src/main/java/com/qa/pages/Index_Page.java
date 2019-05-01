package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.Base_Test;

public class Index_Page extends Base_Test 
{
	//Page Factory
	
	@FindBy(xpath = "//input[@id='search_query_top']")
	WebElement search;
	
	@FindBy(xpath = "//button[@type='submit' and @class='btn btn-default button-search']")
	WebElement searchbutton;
	
	@FindBy(xpath = "//div[@class='header_user_info'and//a[@class='login']]")
	WebElement signIn;
	
	public Index_Page()
	{
		//Initilizing the Page Factory objects
		
		PageFactory.initElements(driver, this);
	}
	//Actions
	public String validate_indexpage() 
	{
		return driver.getTitle();
		
	}
	
	public Search_Page enter_element(String ob)
	{
		search.sendKeys(ob);
		searchbutton.click();
		System.out.println("Searching done successfully");
		return new Search_Page();
	}
	
	public void signin()
	{
		signIn.click();
		System.out.println("Searching done successfully");
	}
	
}

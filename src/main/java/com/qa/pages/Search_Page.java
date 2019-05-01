package com.qa.pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.Base_Test;

public class Search_Page extends Base_Test
{	
	
	@FindBy(xpath = "//a[@href='http://automationpractice.com/index.php?id_product=7&controller=product']//img")
	WebElement product;
	
	@FindBy(xpath = "//p[@id='add_to_cart']")
	WebElement add;
	@FindBy(xpath = "//a[@class='btn btn-default button button-medium' and @href='http://automationpractice.com/index.php?controller=order']")
	WebElement checkout;
	
	public Search_Page()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String title()
	{
		String searchpagetitle = driver.getTitle();
		return searchpagetitle;
	}
	
	public void click_product()
	{
		product.click();
	}
	
	public void addtocart()
	{
		add.click();
	}
	
	public Summary_Page checkout_test()
	{
		checkout.click();
		return new Summary_Page();
	}
	
}



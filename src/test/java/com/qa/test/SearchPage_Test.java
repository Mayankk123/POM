package com.qa.test;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.qa.base.Base_Test;
import com.qa.pages.Index_Page;
import com.qa.pages.Search_Page;

public class SearchPage_Test extends Base_Test
{
	Index_Page ip ;
	Search_Page searchpage;
	
	public SearchPage_Test() 
	{
		super();                 
	}
	@BeforeClass
	public void setup()
	{
		initilization();
		ip=new Index_Page();
		searchpage = ip.enter_element(prop.getProperty("ob"));	
	}
	
	@Test(priority=1)
	public void verifytitletest()
	{
		String title= searchpage.title();
		Assert.assertEquals(title, "Search - My Store");
	}
	
	@Test(priority=2)
	public void clicktest()
	{
		searchpage.click_product();
	}
	
	@Test(priority=3)
	public void add_to_cart()
	{
		searchpage.addtocart();
	}
	@Test(priority=4)
	public void checkout()
	{
		searchpage.checkout_test();
	}
	
	@AfterClass
	public void teardown()
	{
		driver.quit();
	}
	
}

package com.qa.test;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.base.Base_Test;
import com.qa.pages.Index_Page;
import com.qa.pages.Search_Page;
import com.qa.pages.Summary_Page;

public class Summary_Page_Test extends Base_Test 
{
	Index_Page ip ;
	Search_Page searchpage;
	Summary_Page summarypage;
	
	public Summary_Page_Test()
	{
		super();                 
	}
	@BeforeClass
	public void setup()
	{
		initilization();
		ip=new Index_Page();
		searchpage = ip.enter_element(prop.getProperty("ob"));	
		searchpage.click_product();
		searchpage.addtocart();
		summarypage = searchpage.checkout_test();
	}
	
	@Test(priority=1)
	public void verifysummary_title()
	{
		String summarytitle = summarypage.verifysummarytitle_test();
		Assert.assertEquals(summarytitle, "Order - My Store");
	}
	
	@Test(priority=2)
	public void click_proceedcheckout()
	{
		summarypage.proceed_checkout();
	}
	
	@AfterClass
	public void teardown_summary()
	{
	//	driver.quit();
	}
}

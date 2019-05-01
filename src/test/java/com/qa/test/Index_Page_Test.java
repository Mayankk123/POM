package com.qa.test;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.base.Base_Test;
import com.qa.pages.Index_Page;
import com.qa.pages.Search_Page;

public class Index_Page_Test extends Base_Test 
	{
		Index_Page ip ;
		Search_Page searchpage;
	  public Index_Page_Test() 
		{
			super();		
		}
	  
		@BeforeClass
		public void setup()
		{
			initilization();//first it will go to initilization,then super,then to Index_Page get the constructor properties and then initilization method is executed.
			
			ip = new Index_Page();
			ip.signin();
		}
		
		 @Test(priority=1)
		 public void titletest()
		 {
			String title = ip.validate_indexpage();
		    Assert.assertEquals(title, "My Store");
		 }
		 
		    @Test(priority=2)
		    public void search_test()
		    {
			 searchpage=ip.enter_element(prop.getProperty("ob")); //Searcg_Page searchpage = new Search_page(); 
	    	}
		 
		           /*@Test(priority=3)
		           public void select_product()
		            {
		         	 searchpage.click_product();
		         	 searchpage.scroll();
		            }*/
		           

	     @AfterClass
	     public void teardown()
	     {
	    	 driver.quit();
	     }
	     
	   
	    	 
	}



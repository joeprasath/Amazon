
package com.qa.testscripts;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.qa.pages.AmazonLoginPages;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase4 {
	AmazonLoginPages page;
	WebDriver Driver;
	@Parameters({"Browser","Url"})
  @BeforeClass
  public void Setup(String Browser,String Url)throws IOException
  {
	  
	  if(Browser.equalsIgnoreCase("Chrome"))
	  {
		  WebDriverManager.chromedriver().setup();
		  Driver=new ChromeDriver();
	  }
	  else if(Browser.equalsIgnoreCase("Edge"))
	  {
		  WebDriverManager.edgedriver().setup();
		  Driver=new EdgeDriver();
	  }
	 page =new AmazonLoginPages(Driver);
	  Driver.manage().window().maximize();
	  Driver.get(Url);
	 
	
  }
	@AfterClass
	public void TearDown() throws InterruptedException 
	{
		Driver.close();
		Thread.sleep(5000);
	}

	
	
	
}

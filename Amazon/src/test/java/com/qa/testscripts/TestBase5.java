package com.qa.testscripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.qa.pages.AmazonSigninPages;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase5 {
	
AmazonSigninPages sign;
WebDriver Driver;

@Parameters({"Browser","Url"})
@BeforeClass
public void Setup(String Browser,String Url){
	  if(Browser.equalsIgnoreCase("Chrome"))
	  {
		  WebDriverManager.chromedriver().setup();
		  Driver=new ChromeDriver();
	  }
	  else if(Browser.equalsIgnoreCase("Firefox"))
	  {
		  WebDriverManager.firefoxdriver().setup();
		  Driver=new FirefoxDriver();
	  }
	  else if(Browser.equalsIgnoreCase("Edge"))
	  {
		  WebDriverManager.edgedriver().setup();
		  Driver=new EdgeDriver();
	  }
	  
	sign =new AmazonSigninPages(Driver);
	Driver.manage().window().maximize();
	Driver.get(Url);
}
@AfterClass
public void Teardown() throws InterruptedException{
	Driver.close();
	Thread.sleep(5000);
	
}
}

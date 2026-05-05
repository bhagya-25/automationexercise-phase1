package com.automationexercise.Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC001_LaunchBrowser {
	
		WebDriver driver;
	    
		@BeforeMethod
	    public void browserSetUp() {
	    	driver=new ChromeDriver();
	    	driver.manage().window().maximize();
	    	driver.get("https://automationexercise.com/");
	    	}
	
		@AfterMethod
		public void tearDown() {
			driver.quit();
		}
		
		@Test
		public void verifyURL() {
			String uRL=driver.getCurrentUrl();
			Assert.assertTrue(uRL.contains("automationexercise"));
		}
}

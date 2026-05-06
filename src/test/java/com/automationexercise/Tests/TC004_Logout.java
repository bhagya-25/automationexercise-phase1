package com.automationexercise.Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.chrome.ChromeDriver;


public class TC004_Logout {
	
	WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://automationexercise.com/login");
		driver.findElement(By.cssSelector("[data-qa='login-email']")).sendKeys("testUsera1@gmail.com");
		driver.findElement(By.cssSelector("[data-qa='login-password']")).sendKeys("testUser@123");
		driver.findElement(By.cssSelector("[data-qa='login-button']")).click();
		
		WebElement loggedInText = driver.findElement(By.cssSelector("a:has(i.fa-user)"));
		Assert.assertTrue(loggedInText.getText().contains("Logged in as"));
		
		String currentURL=driver.getCurrentUrl();
		System.out.println("after Login: "+currentURL);
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	

	
	@Test
	public void logout() {
		driver.findElement(By.cssSelector("a[href='/logout']")).click();
	
		String currentURL=driver.getCurrentUrl();
		System.out.println("After logout: "+currentURL);
		Assert.assertTrue(currentURL.contains("login"));
	}

}

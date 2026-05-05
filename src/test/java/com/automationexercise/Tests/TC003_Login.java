package com.automationexercise.Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class TC003_Login {
	WebDriver driver;
	
	@BeforeMethod
	public void setup() {
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://automationexercise.com/login");
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit(); 
	}
	
	
	@Test
	public void login() {
		driver.findElement(By.cssSelector("[data-qa=\'login-email\']")).sendKeys("testUsera1@gmail.com");
		driver.findElement(By.cssSelector("[data-qa=\'login-password\']")).sendKeys("testUser@123");
		driver.findElement(By.cssSelector("[data-qa=\'login-button\']")).click();
		
		WebElement loggedInText = driver.findElement(By.cssSelector("a:has(i.fa-user)"));
		Assert.assertTrue(loggedInText.getText().contains("Logged in as"));
	}

}

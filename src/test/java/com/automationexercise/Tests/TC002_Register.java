package com.automationexercise.Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC002_Register {
WebDriver driver;

@BeforeMethod
public void setup() {
	driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://automationexercise.com/");
}

@AfterMethod
public void tearDown() {
	driver.quit();
}

@Test
public void registerUser() {
	driver.findElement(By.linkText("Signup / Login")).click();

    
  //input[@name="name"]
  //input[@name="email"]
  //button[@data-qa="signup-button"]  
    
//  new user signUp  
  driver.findElement(By.cssSelector("[data-qa='signup-name']")).sendKeys("testUser");
//TODO: Hardcoded email - will be replaced with data-driven approach in Phase 3
  driver.findElement(By.cssSelector("[data-qa='signup-email']")).sendKeys("testUsera1a@gmail.com");
  WebElement signUp=driver.findElement(By.cssSelector("[data-qa='signup-button']"));
  ((JavascriptExecutor)driver).executeScript("arguments[0].click();", signUp);
  
  //account info
  driver.findElement(By.id("name")).sendKeys("testUser");
  //driver.findElement(By.id("email")).sendKeys("testUsera1@gmail.com");
  driver.findElement(By.id("password")).sendKeys("testUser@123");
  
// address information 
  driver.findElement(By.id("first_name")).sendKeys("Test");
  driver.findElement(By.id("last_name")).sendKeys("User");
  driver.findElement(By.xpath("//input[@data-qa='address']")).sendKeys("HSR,Bangalore");
  WebElement country=driver.findElement(By.id("country"));
  Select countryDropdown=new Select(country);
  countryDropdown.selectByVisibleText("India");
  driver.findElement(By.id("state")).sendKeys("Karnataka");
  driver.findElement(By.id("city")).sendKeys("Bangalore");
  driver.findElement(By.id("zipcode")).sendKeys("560035");
  driver.findElement(By.id("mobile_number")).sendKeys("8615671230");
  WebElement createAccount=driver.findElement(By.cssSelector("[data-qa='create-account']"));
  ((JavascriptExecutor)driver).executeScript("arguments[0].click();", createAccount);
  
	String currentURL=driver.getCurrentUrl();
	System.out.println(currentURL);
    Assert.assertTrue(currentURL.contains("account"));	
}


}

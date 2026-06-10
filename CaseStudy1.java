package com.Assignment1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CaseStudy1 {
	WebDriver driver;
	String url = "https://www.login.hiox.com/register?referrer=easycalculation.com";
	
	@BeforeTest
	public void setUp()
	{
		driver = new ChromeDriver();
		driver.navigate().to(url);
		driver.manage().window().maximize();
	}
	
	
	@Test
	public void launchApplication() throws Exception{
	   driver.findElement(By.id("xreg_usr")).sendKeys("Ankita");
       driver.findElement(By.id("xreg_pass")).sendKeys("Ankita@1234");
	   driver.findElement(By.id("xreg_confirm")).sendKeys("Ankita@1234");
	   driver.findElement(By.id("xreg_cnt")).sendKeys("India");
	   driver.findElement(By.id("xreg_mob")).sendKeys("8104066019");
	   Thread.sleep(6000);
		
		String title = driver.getTitle();
		String Pagesource = driver.getPageSource();
		int length = driver.getPageSource().length();
		System.out.println("Tiltle : " + title);
		System.out.println("page Source :" + Pagesource);
		System.out.println("Source Length : " + length);
		
	}
	
	@AfterTest
	public void close()
	{
		driver.quit();
	}

}

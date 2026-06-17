package com.Assignment1;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CaseStudy11
{
	WebDriver driver;
	String url = "https://www.easemytrip.com/";
	
	@BeforeTest
	public void setUp()
	{
		driver = new ChromeDriver();
		 driver.navigate().to(url);
		 driver.manage().window().maximize();
	}
	
	@Test
	public void performOperation() throws Exception
	{
		WebElement element = driver.findElement(By.xpath("//span[normalize-space()='Login or Signup']"));
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//span[normalize-space()='Gift Card']")).click();
		Thread.sleep(5000);
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		File screenshot = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshot, new File("./ScreenShot/easyTrip_"+getCurrentDateTime()+".png"));
	}
	
	public String getCurrentDateTime()
	{
		return LocalDateTime.now().format(DateTimeFormatter.ofPattern("MM_dd_yyyy_HH_mm_ss"));
	}
	
	
	@AfterTest
	public void tearDown()
	{
		if(driver != null)
		{
			driver.quit();
		}
	}
}

package com.Assignment1;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CaseStudy10
{
	WebDriver driver;
	String url = "https://www.easycalculation.com/";
	
	@BeforeTest
	public void setUp() 
	{
		driver = new ChromeDriver();
		driver.navigate().to(url);
		driver.manage().window().maximize();
		
	}
	
	
	@Test
	public void test() throws IOException
	{
		driver.findElement(By.xpath("//a[normalize-space()='Tutorials']")).click();
		driver.findElement(By.xpath("//a[normalize-space()='Area']")).click();
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		File screenshot= ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshot, new File("./ScreenShot./easycalculation_"+getCurrentDateTime()+".png"));
	}
	
	public String getCurrentDateTime()
	{
		return LocalDateTime.now().format(DateTimeFormatter.ofPattern("MM_dd_yyyy_HH_mm_ss"));
	}
	
	
	
	
	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}
	
	
}
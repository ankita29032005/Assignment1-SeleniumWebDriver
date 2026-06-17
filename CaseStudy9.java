package com.Assignment1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;




public class CaseStudy9
{
	WebDriver driver;
	String url = "https://demo.opencart.com/en-gb?route=account/login";
	
	
	
	@Test(dataProvider="opencart")
	public void test(String userName, String password) throws InterruptedException
	{
		driver = new ChromeDriver();
		driver.navigate().to(url);
		driver.manage().window().maximize();
		Thread.sleep(20000);
		driver.findElement(By.id("input-email")).sendKeys(userName);
		driver.findElement(By.id("input-password")).sendKeys(password);
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}
	
	
	@DataProvider(name="opencart")
	public Object[][] passData()
	{
		Object[][] data = new Object[3][2];
		data[0][0] = "6378547586";
		data[0][1] = "rakesh@334";
		
		data[1][0] = "8378547586";
		data[1][1] = "ramesh@532";
		
		data[2][0] = "9378547586";
		data[2][1] = "prateek@321";
		
		return data;

	}
}
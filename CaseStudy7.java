package com.Assignment1;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CaseStudy7
{
	WebDriver driver;
    String url = "https://store.webkul.com";   
    
    @BeforeTest
    public void setUp() 
    {
    	
    	ChromeOptions options = new ChromeOptions();
    	options.addArguments("--headless=new");
    	
        driver = new ChromeDriver(options);
        driver.navigate().to(url);
        driver.manage().window().maximize();
        
        
    }
  
    
    @Test
    public void case7() throws Exception
    {
    	Thread.sleep(20000);
    	String title = driver.getTitle();
    	System.out.println("Title : " + title);
 	
    	
    	
    	TakesScreenshot ts = (TakesScreenshot)driver; 
    	File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./ScreenShot/EasyCalculation_" + getCurrentDateTime() +".png"));
    }
    
    public String getCurrentDateTime() 
   	{
   		DateFormat customFormat = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
   		Date currentdate = new Date();
   		return customFormat.format(currentdate);
   	}
    
    @AfterTest
    public void close() {
        driver.quit();
    }
}
package com.Assignment1;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CaseStudy6 {
	WebDriver driver;
    String url = "https://store.webkul.com";   
    
    @BeforeTest
    public void setUp() 
    {
        driver = new ChromeDriver();
        driver.navigate().to(url);
        driver.manage().window().maximize();
    }
    
    
    @Test
    public void case6() throws InterruptedException, IOException
    {
    	Thread.sleep(20000);
    	String title = driver.getTitle();
    	System.out.println("Title : " + title);
    	List<WebElement> elements = driver.findElements(By.xpath("//a"));
    	for(WebElement ele : elements)
    	{
    		System.out.println(ele.getAttribute("href"));
    	}	
    	
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

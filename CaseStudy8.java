package com.Assignment1;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CaseStudy8 
{
    WebDriver driver;
    String url = "https://demo.opencart.com";

    @Parameters("browserName")
    @BeforeTest
    public void setUp(String browserName) throws Exception 
    {
    	 if (browserName.equalsIgnoreCase("chrome")) {
             driver = new ChromeDriver();
         } else {
             System.out.println("Launching Failed.");
             driver = new ChromeDriver();
         } 
    	 
    	 
    }
    
    @Test
    public void Test() throws Exception
    {
    	
    	driver.get(url);
        driver.manage().window().maximize();
        Thread.sleep(5000);
        System.out.println("Page title: " + driver.getTitle());
        
        
        TakesScreenshot ts = (TakesScreenshot)driver;
        File screenshot = ts.getScreenshotAs(OutputType.FILE);	
        FileUtils.copyFile(screenshot, new File("./ScreenShot/opencart_"+getCurrentDateTime()+".png"));
        
    }
    
    
    public String getCurrentDateTime()
    {
    	return  LocalDateTime.now()
    	        .format(DateTimeFormatter.ofPattern("MM_dd_yyyy_HH_mm_ss"));
    }


    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

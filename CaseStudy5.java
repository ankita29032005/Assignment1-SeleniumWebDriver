package com.Assignment1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CaseStudy5 {
	WebDriver driver;
	String url = "http://automationpractice.com/index.php";
	
	@BeforeTest
	public void setUp()
	{
		driver = new ChromeDriver();
		driver.navigate().to(url);
		driver.manage().window().maximize();
	}
	@Test
	public void AutomationPracticeTest() throws Exception{

        String title = driver.getTitle();
        System.out.println("Page Title: " + title);
        System.out.println("Title Length: " + title.length());
        

        String url = driver.getCurrentUrl();
        System.out.println("Current URL: " + url);
        

        if (url.equals("http://automationpractice.com/index.php")) {
            System.out.println("URL Verification PASSED");
        } else {
            System.out.println("URL Verification FAILED");
        }
        

        String pageSource = driver.getPageSource();
        System.out.println("Page Source Length: " + pageSource.length());

        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println("Total Links: " + links.size());
        
        for(WebElement  link : links) {
			System.out.println(link.getText());
	     }
        Thread.sleep(4000);
    }
	@AfterTest
	public void close()
	{
		driver.quit();
	}


}

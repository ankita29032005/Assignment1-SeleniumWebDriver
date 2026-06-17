package com.Assignment1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CaseStudy13
{
	WebDriver driver;

    @BeforeTest
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void assertionTest() throws Exception {

        driver.get("https://www.easemytrip.com/");
        Thread.sleep(5000);

        String String1 = "MyAccount";
        String String2 = "My Booking";

        Assert.assertEquals(String1, "MyAccount");
        System.out.println("assertEquals passed");

        Assert.assertNotEquals(String1, String2);
        System.out.println("assertNotEquals passed");

        Assert.assertTrue(String1.contains("Account"));
        System.out.println("assertTrue passed");

        Assert.assertFalse(String1.equals(String2));
        System.out.println("assertFalse passed");

        String strNull = null;
        Assert.assertNull(strNull);
        System.out.println("assertNull passed");

        Assert.assertNotNull(String1);
        System.out.println("assertNotNull passed");
    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

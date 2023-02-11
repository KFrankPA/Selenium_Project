package com.cydeo.tests.day05_DynamicWebElements;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class T4_TestNG_selenium_intro {
    WebDriver driver;

    @BeforeMethod
    public void setupMethod() {

        //TC #4: Cydeo Title Verification
        //1.Open Chrome browser
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //2.Go to https://www.cydeo.com
        driver.get("https://www.practice.cydeo.com");
        //3.Verify title:
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void test1_cydeo_title_verificatin() {

        String actual = driver.getTitle();
        String expected = "practice";
        //Expected: Cydeo

        // Assert.assertTrue(actual.equalsIgnoreCase(expected));
        Assert.assertEquals(actual, expected);


    }

}

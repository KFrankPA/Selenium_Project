package com.cydeo.tests.day05_DynamicWebElements;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class T8_SelectingValueFromNonSelectDropdown {

    WebDriver driver;

    @BeforeMethod
    public void setupMethod() {
        //TC #8: Selecting value from non-select dropdown
        //1. Open Chrome browser
        //2. Go to https://practice.cydeo.com/dropdown
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://practice.cydeo.com/dropdown");
    }

    @AfterMethod
    public void tearDown() {
      driver.quit();
    }

    @Test
    public void test1() {

        WebElement button = driver.findElement(By.xpath("//a[@id='dropdownMenuLink']"));
        button.click();
        WebElement fb = driver.findElement(By.partialLinkText("Facebook"));
        fb.click();

        //3. Click to non-select dropdown
        //4. Select Facebook from dropdown
        //5. Verify title is “Facebook - Log In or Sign Up”

    }





}

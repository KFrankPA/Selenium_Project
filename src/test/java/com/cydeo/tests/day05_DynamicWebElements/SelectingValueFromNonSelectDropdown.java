package com.cydeo.tests.day05_DynamicWebElements;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class SelectingValueFromNonSelectDropdown {
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

    @Test
    public void test1(){

        //3. Click to non-select dropdown

        WebElement button = driver.findElement(By.xpath("//a[@id='dropdownMenuLink']"));
        button.click();
        //4. Select Facebook from dropdown
        driver.findElement(By.xpath("//a[.='Facebook']")).click();

        //5. Verify title is “Facebook - Log In or Sign Up”

        String expectedTitle = "Facebook - Log In or Sign Up";
        String actual = driver.getTitle();

        Assert.assertTrue(expectedTitle.equalsIgnoreCase(actual));

    }




}

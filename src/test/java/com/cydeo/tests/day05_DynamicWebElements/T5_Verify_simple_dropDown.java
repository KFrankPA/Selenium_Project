package com.cydeo.tests.day05_DynamicWebElements;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class T5_Verify_simple_dropDown {

    WebDriver driver;

    //TC#5: Verifying “Simple dropdown” and “State selection” dropdown
    //default values
    //1. Open Chrome browser
    //2. Go to https://practice.cydeo.com/dropdown
    @BeforeMethod
    public void setupMethod(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://practice.cydeo.com/dropdown");
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
    @Test
    public void simple_dropdowns_test() {

        //3. Verify “Simple dropdown” default selected value is correct
        //Locating the dropdown as a web element
        WebElement simpleDropdown = driver.findElement(By.xpath("//select[@id='dropdown']"));
        // creating Select class object and passing the dropdown web element into the constructor
        Select select = new Select(simpleDropdown);
        //Expected: “Please select an option”

        String expectedDefaultValue = "Please select an option";

        //Actual:
        String actualDefaultValue = select.getFirstSelectedOption().getText();

        //Do our assertion

        Assert.assertEquals(expectedDefaultValue, actualDefaultValue);
        Assert.assertTrue(expectedDefaultValue.equalsIgnoreCase(actualDefaultValue));


        //4. Verify “State selection” default selected value is correct Expected: “Select a State”

        Select stateDropDown = new Select(driver.findElement(By.xpath("//select[@id='state']")));

        String expected = "Select a State";
        String actual = stateDropDown.getFirstSelectedOption().getText();

        Assert.assertTrue(expected.equalsIgnoreCase(actual));

    }
}

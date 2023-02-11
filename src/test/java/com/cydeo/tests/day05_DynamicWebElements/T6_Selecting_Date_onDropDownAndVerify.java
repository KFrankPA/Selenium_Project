package com.cydeo.tests.day05_DynamicWebElements;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class T6_Selecting_Date_onDropDownAndVerify {

    WebDriver driver;

    @BeforeMethod

    public void setupMethod(){
        //TC #6: Selecting date on dropdown and verifying
        //1. Open Chrome browser
        //2. Go to https://practice.cydeo.com/dropdown

        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://practice.cydeo.com/dropdown");

    }

    @Test
    public void test1(){

        String actual;
        String expected;
        Select select = new Select(driver.findElement(By.xpath("//select[@id='year']")));
        select.selectByVisibleText("1988");

        expected = "1988";
        actual = select.getFirstSelectedOption().getText();
        Assert.assertEquals(actual,expected);

        select = new Select(driver.findElement(By.xpath("//select[@id='month']")));
        select.selectByIndex(6);
        actual = select.getFirstSelectedOption().getText();
        expected = "July";
        Assert.assertTrue(actual.equalsIgnoreCase(expected));



        select = new Select(driver.findElement(By.xpath("//select[@id='day']")));
        select.selectByValue("23");
        actual = select.getFirstSelectedOption().getText();
        expected = "23";
        Assert.assertTrue(actual.equalsIgnoreCase(expected));



        //3. Select “July 23rd, 1988” and verify it is selected.
        //Select year using : visible text
        //Select month using : value attribute
        //Select day using : index number

    }

}

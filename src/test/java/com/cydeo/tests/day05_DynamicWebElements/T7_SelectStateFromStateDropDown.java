package com.cydeo.tests.day05_DynamicWebElements;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class T7_SelectStateFromStateDropDown {

    WebDriver driver;
    //TC #7: Selecting state from State dropdown and verifying result
    //1. Open Chrome browser
    //2. Go to http://practice.cybertekschool.com/dropdown

    @BeforeMethod
    public void setupMethod(){

        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://practice.cybertekschool.com/dropdown");

    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
    @Test
    public void test1() throws InterruptedException {

        Select select = new Select(driver.findElement(By.xpath("//select[@id='state']")));

        select.selectByValue("IL");
        Thread.sleep(2000);
        select.selectByValue("VA");
        Thread.sleep(2000);
        select.selectByValue("CA");
        Thread.sleep(3000);

        String expected = "California";
        String actual = select.getFirstSelectedOption().getText();

        Assert.assertTrue(expected.equalsIgnoreCase(actual));

    }
    //3. Select Illinois
    //4. Select Virginia
    //5. Select California
    //6. Verify final selected option is California.
    //Use all Select options. (visible text, value, index)
}

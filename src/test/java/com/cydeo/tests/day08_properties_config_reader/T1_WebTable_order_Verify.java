package com.cydeo.tests.day08_properties_config_reader;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class T1_WebTable_order_Verify {
    WebDriver driver;

    //1 Create new test and make setups
    @BeforeMethod
    public void setupMethod() {

        //1. Create new test and make setups
        //2. Go to : https://practice.cydeo.com/web-tables

        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://practice.cydeo.com/web-tables");

    }
    @Test

    public void order_verify_name_test(){

        //2. Verify Bob’s name is listed as expected.
        // locating Bob's cell using its name as the text
        WebElement bobsCell = driver.findElement(By.xpath("//table[@class='SampleTable']//td[.='Bob Martin']"));
        //Expected: “Bob Martin”
        //3. Verify Bob Martin’s order date is as expected


    }
}

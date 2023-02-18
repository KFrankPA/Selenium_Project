package com.cydeo.tests.day08_properties_config_reader;

import com.cydeo.utilities.WebDriverFactory;
import com.cydeo.utilities.WebOrderUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
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

    public void test1_order_verify_name_test(){

        //2. Verify Bob’s name is listed as expected.
        // locating Bob's cell using its name as the text
        WebElement bobsCell = driver.findElement(By.xpath("//table[@class='SampleTable']//td[.='Bob Martin']"));
        System.out.println("bobsCell.getText() = " + bobsCell.getText());
        //Expected: “Bob Martin”

        String expectedName = "Bob Martin";
        String actualText = bobsCell.getText();
        //3. Verify Bob Martin’s order date is as expected
       // WebElement bobsOrderDate = driver.findElement(By.xpath("//table[@class='SampleTable']//td[.='Bob Martin']/../td[5]"));
        //another option using siblings
        // or //td[.='Bob Martin']/following-sibling::td[3]
        WebElement bobsOrderDate = driver.findElement(By.xpath("//table[@class='SampleTable']//td[.='Bob Martin']/following-sibling::td[3]"));

        //Expected 12/31/2021
        String expectedDate = "12/31/2021";
        String actualDate = bobsOrderDate.getText();

        Assert.assertEquals(actualDate, expectedDate);
        Assert.assertEquals(actualText, actualText, "Names are not matching");


    }
    @Test
    public void test2_use_order_verify_method(){
       String alexandraGray = WebOrderUtils.returnOrderDate(driver, "Alexandra Gray");
        System.out.println(alexandraGray);
    }

    @Test
    public void test3(){

        System.out.println(WebOrderUtils.returnOrderDate(driver, "Bob Martin") + "BOBIK");
        WebOrderUtils.orderVerify(driver, "Bob Martin", "12/31/2021");
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }


}

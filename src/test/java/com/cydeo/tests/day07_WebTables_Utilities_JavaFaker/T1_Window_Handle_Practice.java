package com.cydeo.tests.day07_WebTables_Utilities_JavaFaker;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

public class T1_Window_Handle_Practice {

    //TC #1: Window Handle practice

    WebDriver driver;

    @BeforeMethod
    public void setupMethod(){

        //1. Create new test and make setups
        //2. Go to : https://www.amazon.com

        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.amazon.com");


    }


@Test
    public void test1(){

    //3. Copy paste the lines from below into your class
    ((JavascriptExecutor) driver).executeScript("window.open('http://google.com','_blank');");
    ((JavascriptExecutor) driver).executeScript("window.open('http://etsy.com','_blank');");
    ((JavascriptExecutor) driver).executeScript("window.open('http://facebook.com','_blank');");

    //4. Create a logic to switch to the tab where Etsy.com is open
    Set<String> handles = driver.getWindowHandles();


    for (String eachHandle : handles) {
        driver.switchTo().window(eachHandle);
        String currentUrl = driver.getCurrentUrl();
       if(currentUrl.contains("etsy")){
           break;

       }

    }
    System.out.println(driver.getTitle());
    Assert.assertTrue(driver.getTitle().contains("Etsy"));

    //5. Assert: Title contains “Etsy”
    //Lines to be pasted:
    //These lines will simply open new tabs using something called JavascriptExecutor
    //and get those pages. We will learn JavascriptExecutor later as well.
}
    @Test
    public void test2(){

        //3. Copy paste the lines from below into your class
        ((JavascriptExecutor) driver).executeScript("window.open('http://google.com','_blank');");
        ((JavascriptExecutor) driver).executeScript("window.open('http://etsy.com','_blank');");
        ((JavascriptExecutor) driver).executeScript("window.open('http://facebook.com','_blank');");

        //4. Create a logic to switch to the tab where Etsy.com is open

        BrowserUtils.switchWindowAndVerify(driver,"etsy", "Etsy");

    }

    @AfterMethod

    public void tearDown(){
        driver.quit();
    }


}

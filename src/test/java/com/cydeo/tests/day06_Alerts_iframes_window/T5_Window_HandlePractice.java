package com.cydeo.tests.day06_Alerts_iframes_window;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class T5_Window_HandlePractice {

    WebDriver driver;

    //TC #5: Window Handle practice
    //1. Create a new class called: T5_WindowsPractice
    //2. Create new test and make set ups
    //3. Go to : https://practice.cydeo.com/windows


    @BeforeMethod
    public void setupMethod(){

        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://practice.cydeo.com/windows");

    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void test1(){
        //4. Assert: Title is “Windows”
        Assert.assertEquals(driver.getTitle(), "Windows");
        //5. Click to: “Click Here” link
        driver.findElement(By.cssSelector("a[href='/windows/new']")).click();
        //6. Switch to new Window.
        // 1- windowHandle: mainHandle
        // 2- windowHandle: 2nd window

        System.out.println("driver.getWindowHandle() = " + driver.getWindowHandle());
        driver.getWindowHandle();

        String mainHandle = driver.getWindowHandle();
        System.out.println(mainHandle + " main handle id");

        for(String each : driver.getWindowHandles()){

           driver.switchTo().window(each);
            System.out.println("Current title while switching a window : " + driver.getTitle() );
        }

        //7. Assert: Title is “New Window” we need to use driver.getWindowHandles() method

       Assert.assertTrue(driver.getTitle().equalsIgnoreCase("new window"));

        // we can main handle to switch
       // driver.switchTo().window("F2CF4D04F7B128388E9DC2EFE67F61B7");

        driver.switchTo().window(mainHandle);
        System.out.println(driver.getTitle());




    }

}

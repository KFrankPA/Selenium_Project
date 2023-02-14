package com.cydeo.tests.day06_Alerts_iframes_window;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.time.Duration;

public class T1_T2_T3_AlertPractice {

    WebDriver driver;

    //TC #1: Information alert practice
    //1. Open browser
    //2. Go to website: http://practice.cydeo.com/javascript_alerts

    @BeforeMethod
    public void setupMethod(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://practice.cydeo.com/javascript_alerts");

    }

    @AfterMethod
    public void teardownMethod(){
       // driver.close();
    }

    @Test
    public void information_Alert_T1() throws InterruptedException {

        //3. Click to “Click for JS Alert” button
        WebElement button1 = driver.findElement(By.xpath("//button[.='Click for JS Alert']"));
        button1.click();
        Thread.sleep(1500);

        //4. Click to OK button from the alert
       // Alert alert = driver.switchTo().alert();
        //alert.accept();

        driver.switchTo().alert().accept();

        //5. Verify “You successfully clicked an alert” text is displayed.

        WebElement clickedMessage = driver.findElement(By.id("result"));

        Assert.assertTrue(clickedMessage.isDisplayed());
    }

    @Test

    public void information_alert_T2() throws InterruptedException {

        //TC #2: Confirmation alert practice
        WebElement button2 = driver.findElement(By.xpath("//button[.='Click for JS Confirm']"));
        //3. Click to “Click for JS Confirm” button
        Thread.sleep(1500);
        button2.click();
        //4. Click to OK button from the alert

        Alert alert = driver.switchTo().alert();
        alert.accept();
        //5. Verify “You clicked: Ok” text is displayed.
       Assert.assertTrue(driver.findElement(By.xpath("//p[.='You clicked: Ok']")).isDisplayed());
    }

    @Test
    public void information_alert_T3() throws InterruptedException {
        //TC #3: Information alert practice

        //3. Click to “Click for JS Prompt” button

        WebElement button3 = driver.findElement(By.xpath("//button[.='Click for JS Prompt']"));
        button3.click();

        //4. Send “hello” text to alert
        Thread.sleep(2000);
              Alert alert = driver.switchTo().alert();
        //Thread.sleep(2000);
       alert.sendKeys("hello");

        //5. Click to OK button from the alert
         Thread.sleep(2000);
        alert.accept();
        //6. Verify “You entered: hello” text is displayed.
    }


}

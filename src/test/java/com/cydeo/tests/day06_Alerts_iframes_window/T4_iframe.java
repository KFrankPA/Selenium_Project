package com.cydeo.tests.day06_Alerts_iframes_window;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class T4_iframe {

    WebDriver driver;

    @BeforeMethod
    public void setupMethod() {
        //TC #4: Iframe practice
        //1. Create a new class called: T4_Iframes
        //2. Create new test and make set ups
        //3. Go to: https://practice.cydeo.com/iframe

        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://practice.cydeo.com/iframe");

    }

    @Test
    public void test1() {

        // we have to switch to iframe to be able to locate a web elements in there
        //option #1 switch "id" attribute value
        // driver.switchTo().frame("mce_0_ifr"); // by id
        // driver.switchTo().frame(0); //by index number
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']"))); // using a web element locator

//
        WebElement paragraphText = driver.findElement(By.xpath("//p[.='Your content goes here.']"));
        //4. Assert: “Your content goes here.” Text is displayed.
        Assert.assertTrue(paragraphText.isDisplayed());

        //5. Assert: “An iFrame containing the TinyMCE WYSIWYG Editor”
        driver.switchTo().parentFrame();
        // driver.switchTo().defaultContent();
        Assert.assertTrue(driver.findElement(By.xpath("//h3[.='An iFrame containing the TinyMCE WYSIWYG Editor']")).isDisplayed());

    }
}

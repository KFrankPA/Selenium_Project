package com.cydeo.tests.day05_DynamicWebElements;

import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;


public class Stale_Element_Reference {
    public static void main(String[] args) throws InterruptedException {

        //DO NOT USE ANY DEVELOPER TOOLS TO GET ANY LOCATORS.
        //TC #1: StaleElementReferenceException handling
        //1. Open Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //2. Go to https://practice.cydeo.com/add_remove_elements/
        driver.get("https://practice.cydeo.com/add_remove_elements/");

        //3. Click to “Add Element” button
        WebElement button = driver.findElement(By.xpath("//button[.= 'Add Element']"));
        button.click();

        //4. Verify “Delete” button is displayed after clicking.

        WebElement deleteButton = driver.findElement(By.xpath("//button[.= 'Delete']"));
        System.out.println("deleteButton.isDisplayed() expecting true = " + deleteButton.isDisplayed());

        //5. Click to “Delete” button.
        Thread.sleep(2000);
        deleteButton.click();
        //6. Verify “Delete” button is NOT displayed after clicking.

        try {
            System.out.println("deleteButton.isDisplayed(), expecting false = " + deleteButton.isDisplayed());
        } catch (StaleElementReferenceException e) {
            System.out.println("-->StaleElementReferenceException happened due to element being deleted from the page.");
            System.out.println("Which concludes our test case -PASSING!-");
            System.out.println("deleteButton.isDisplayed()= false ");
            //USE XPATH LOCATOR FOR ALL WEBELEMENT LOCATORS

        }
    }
}

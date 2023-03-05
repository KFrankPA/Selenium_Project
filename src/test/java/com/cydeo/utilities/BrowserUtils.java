package com.cydeo.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.Set;

public class BrowserUtils {

    // This class will be storing only the utility methods that can be used across the project

    public static void sleep(int seconds){
        seconds *= 1000;
        try {
            Thread.sleep(seconds);
        }catch (InterruptedException e){

        }
    }

    public static void switchWindowAndVerify(WebDriver driver, String expectedURL, String expectedTitle){

        Set<String> handles = driver.getWindowHandles();


        for (String eachHandle : handles) {
            driver.switchTo().window(eachHandle);
            String currentUrl = driver.getCurrentUrl();
            if(currentUrl.contains(expectedURL)){
                break;

            }

        }
        System.out.println(driver.getTitle());
        Assert.assertTrue(driver.getTitle().contains(expectedTitle));

    }

    public static void verifyTitleContains(WebDriver driver, String expectedTitle){

        Assert.assertTrue(driver.getTitle().contains(expectedTitle));

    }
    public static void verifyTitle(WebDriver driver, String expectedTitle){

        Assert.assertEquals(driver.getTitle(),(expectedTitle));

    }

    public static void waitForInvisibilityOf(WebElement target){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));

        wait.until(ExpectedConditions.invisibilityOf(target));
    }
   /* This method accepts String title,
    and waits for that Title to contain given String value.
     */
    public static void waitForTitleContains(String title){
        //Create the object of 'WebDriverWait' class, and set up the constructor args
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));

        //use the 'wait' object with the proper syntax to create explicit wait conditions.
        wait.until(ExpectedConditions.titleContains(title));
    }

}

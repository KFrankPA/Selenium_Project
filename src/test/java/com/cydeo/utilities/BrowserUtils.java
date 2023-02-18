package com.cydeo.utilities;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

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
}

package com.cydeo.tests.day02_locator_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HWP3_Gmail_Title_Verification {
    public static void main(String[] args) {

        //TC #3: Back and forth navigation
        //1- Open a chrome browser

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();


        //2- Go to: https://google.com

        driver.get("https://google.com");

        //3- Click to Gmail from top right.

        WebElement gmail = driver.findElement(By.partialLinkText("Gmail"));
        gmail.click();
        //4- Verify title contains:
        //Expected: Gmail

        String expectedTitle = "Gmail";
        String actualTitle = driver.getTitle();

        if (actualTitle.contains(expectedTitle)) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }

        //5- Go back to Google by using the .back();

        driver.navigate().back();

        //6- Verify title equals:
        //Expected: Google

        expectedTitle = "Google";
        actualTitle = driver.getTitle();

        if (actualTitle.equals(expectedTitle)) {
            System.out.println("Title Pass");
        } else {
            System.out.println("Title Fail");
        }
        driver.close();
    }
}

package com.cydeo.tests.day02_locator_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class T1_CydeoVerifications {

    public static void main(String[] args) {

        // TC #1: Cydeo practice tool verifications
        //1. Open Chrome browser
        //2. Go to https://practice.cydeo.com
        //3. Verify URL contains
        //Expected: cydeo
        //4. Verify title:
        //Expected: Practice

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        //2. Go to https://practice.cydeo.com
        // OR = driver.navigate().to("https://practice.cydeo.com");
        driver.get("https://practice.cydeo.com");

        //3. Verify URL contains
        String expectedURL = "Yydeo";
        String actualURL = driver.getCurrentUrl();
        if(actualURL.toLowerCase().contains("cydeo".toLowerCase())){
            System.out.println("URL verification PASSED!!!");
        }else{
            System.out.println("URL verification FAILED!!!");
        }
        //4. Verify title:

        String expectedTitle = "Practice";
        String actualTitle = driver.getTitle(); // ---> returns "Practice"

        if(actualTitle.toLowerCase().contains(expectedTitle.toLowerCase())) {
            System.out.println("Title verification is PASSED!!!");
        }else{
            System.out.println("Title verification is Failed!!!");
        }



    }
}

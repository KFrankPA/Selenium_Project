package com.cydeo.tests.day01_selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicNavigations {
    public static void main(String[] args) throws InterruptedException {


        // setup browser driver
        WebDriverManager.chromedriver().setup();

        // Create instance of Chrome browser
        WebDriver driver = new ChromeDriver();

        // this line maximizes the currently opened browser
          driver.manage().window().maximize();
       // driver.manage().window().fullscreen(); // works with Mac only

        // Go to tesla.com
        driver.get("https://www.tesla.com");

        // use. getCurrentUrl method to print out current URL
        System.out.println("driver.getCurrentUrl() = " + driver.getCurrentUrl());

        // get title of the page
      //  System.out.println("driver.getTitle() = " + driver.getTitle());
        String currentTitle = driver.getTitle();
        System.out.println("currentTitle = " + currentTitle);

        // use navigate back() to go back
        driver.navigate().back();

        // Stop execution for 3 seconds
        Thread.sleep(3000);

        // user navigate forward() to go forward
        driver.navigate().forward();

        // Stop execution for 3 seconds
        Thread.sleep(3000);

        // User refreshes the page using navigate.refresh();
        driver.navigate().refresh();

        // Stop execution for 3 seconds
        Thread.sleep(3000);

        //Navigate to google.com using navigate().to();
        driver.navigate().to("https://www.google.com");

        // use. getCurrentUrl method to print out current URL
        System.out.println("driver.getCurrentUrl() = " + driver.getCurrentUrl());

        // get title of the page
       // System.out.println("driver.getTitle() = " + driver.getTitle());
        String currentTitle2 = driver.getTitle();
        System.out.println("currentTitle2 = " + currentTitle2);

        // closes only the currently focused window/tab
        driver.close();

        // closes all the opened browsers
        driver.quit();




    }
}

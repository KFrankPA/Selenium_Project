package com.cydeo.tests.day04_checkBox_radioButton;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class TC4_StaleElementReferenceException {
    public static void main(String[] args) {


        //TC #4: StaleElementReferenceException Task
        //1- Open a chrome browser

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //2- Go to: https://practice.cydeo.com/abtest
        driver.get("https://practice.cydeo.com/abtest");

        //3- Locate “CYDEO” link, verify it is displayed.
        WebElement cydeoLink = driver.findElement(By.xpath("//a[@href = 'https://cydeo.com/']"));
        System.out.println("CYDEO link is displayed " + cydeoLink.isDisplayed());

        //4- Refresh the page.
        driver.navigate().refresh();
        //5- Verify it is displayed, again.
        System.out.println("CYDEO link is displayed " + cydeoLink.isDisplayed());

    }
}

package com.cydeo.tests.day03_cssSelector_xpath;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TC1_NextBaseCRM_Locator_getText {
    public static void main(String[] args) {

        //TC #1: NextBaseCRM, locators and getText() practice
        //1- Open a chrome browser
//        WebDriverManager.chromedriver().setup();
//        WebDriver driver = new ChromeDriver();

        WebDriver driver = WebDriverFactory.getDriver("firefox");
        driver.manage().window().maximize();

        //2- Go to: https://login1.nextbasecrm.com/
        driver.get("https://login1.nextbasecrm.com");

        //3- Enter incorrect username: “incorrect”

        WebElement loginBox = driver.findElement(By.className("login-inp"));
        loginBox.sendKeys("incorrect");

        //4- Enter incorrect password: “incorrect”
        WebElement passBox = driver.findElement(By.name("USER_PASSWORD"));
        passBox.sendKeys("incorrect");

        //5- Click to login button.
        WebElement logBtn = driver.findElement(By.className("login-btn"));
        logBtn.click();
        //6- Verify error message text is as expected:
        //Expected: Incorrect login or password

        String expectedErrorMsg = "Incorrect login or password";
        String actualErrorMsg = driver.findElement(By.className("errortext")).getText();

        if(actualErrorMsg.equals(expectedErrorMsg)){
            System.out.println("Pass");
        }else {
            System.out.println("Fail");
        }

        //PS: Inspect and decide which locator you should be using to locate web
        //elements.


    }
}

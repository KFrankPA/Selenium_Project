package com.cydeo.tests.day03_cssSelector_xpath;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TC2_NextBaseCRM_locators {
    public static void main(String[] args) {

        //TC #2: NextBaseCRM, locators, getText(), getAttribute() practice
        //1- Open a chrome browser

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        //2- Go to: https://login1.nextbasecrm.com/

        driver.get("https://login1.nextbasecrm.com/");

        //3- Verify “remember me” label text is as expected:
        //Expected: Remember me on this computer
        String expectedTxt = "Remember me on this computer";
        String actualTxt = driver.findElement(By.className("login-item-checkbox-label")).getText();

        if(actualTxt.equalsIgnoreCase(expectedTxt)){
            System.out.println("remember me = txt pass");
        }else{
            System.out.println("remember me = txt didnt pass");
        }

        //4- Verify “forgot password” link text is as expected:
        //Expected: Forgot your password?
        expectedTxt = "Forgot your password?";

        if(driver.findElement(By.className("login-link-forgot-pass")).getText().equalsIgnoreCase(expectedTxt)){
            System.out.println("forgot pass Pass");
        }else{
            System.out.println("forgot pass = fail");
        }
        //System.out.println(driver.findElement(By.className("login-link-forgot-pass")).getText());

        //5- Verify “forgot password” href attribute’s value contains expected:
        //Expected: forgot_password=yes
        WebElement forgotPassLink = driver.findElement(By.className("login-link-forgot-pass"));

        expectedTxt = "forgot_password=yes";
        actualTxt =  forgotPassLink.getAttribute("href");

        if(actualTxt.contains(expectedTxt)){
            System.out.println("Href pass");
        }else{
            System.out.println("href fail");
        }

        //
        //PS: Inspect and decide which locator you should be using to locate web
        //elements.





    }
}

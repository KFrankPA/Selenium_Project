package com.cydeo.tests.day07_WebTables_Utilities_JavaFaker;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.CRM_Utilities;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class T4_LoginTask {

    WebDriver driver;

    //1 Create new test and make setups
    @BeforeMethod
    public void setupMethod() {

        //1. Create new test and make setups
        //2. Go to : https://www.amazon.com

        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://login1.nextbasecrm.com/");


    }

    @Test
    public void test1_crm_login() {
        //3. Enter valid username
        WebElement userLogin = driver.findElement(By.xpath("//input[@name='USER_LOGIN']"));
        userLogin.sendKeys("helpdesk1@cydeo.com");
        //4. Enter valid password
        WebElement userPassword = driver.findElement(By.xpath("//input[@name='USER_PASSWORD']"));
        userPassword.sendKeys("UserUser");

        //5. Click to `Log In` button
        WebElement loginButton = driver.findElement(By.xpath("//input[@class='login-btn']"));
        loginButton.click();

        BrowserUtils.sleep(5);

        //Expected: Portal
        String expectedTitle = "Portal";

        //6. Verify title is as expected:
        BrowserUtils.verifyTitle(driver,expectedTitle);
        //
        //USERNAME PASSWORD
        //helpdesk1@cydeo.com UserUser
        //helpdesk2@cydeo.com UserUser
    }
    @Test
    public void test2(){
        CRM_Utilities.login_crm(driver, "helpdesk1@cydeo.com"," UserUser" );
    }

}

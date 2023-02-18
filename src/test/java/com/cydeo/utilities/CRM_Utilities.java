package com.cydeo.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CRM_Utilities{

    /*
    This class will store the method related to CRM project
    Username : helpdesk1@cydeo.com
    Password : UserUser
     */

   public static void login_crm(WebDriver driver){
       //3. Enter valid username
       WebElement userLogin = driver.findElement(By.xpath("//input[@name='USER_LOGIN']"));
       userLogin.sendKeys("helpdesk1@cydeo.com");
       //4. Enter valid password
       WebElement userPassword = driver.findElement(By.xpath("//input[@name='USER_PASSWORD']"));
       userPassword.sendKeys("UserUser");

       //5. Click to `Log In` button
       WebElement loginButton = driver.findElement(By.xpath("//input[@class='login-btn']"));
       loginButton.click();

   }


    public static void login_crm(WebDriver driver, String username, String password){
        //3. Enter valid username
        WebElement userLogin = driver.findElement(By.xpath("//input[@name='USER_LOGIN']"));
        userLogin.sendKeys(username);
        //4. Enter valid password
        WebElement userPassword = driver.findElement(By.xpath("//input[@name='USER_PASSWORD']"));
        userPassword.sendKeys(password);

        //5. Click to `Log In` button
        WebElement loginButton = driver.findElement(By.xpath("//input[@class='login-btn']"));
        loginButton.click();

    }

}

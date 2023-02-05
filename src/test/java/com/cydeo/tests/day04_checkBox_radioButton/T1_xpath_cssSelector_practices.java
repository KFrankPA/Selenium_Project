package com.cydeo.tests.day04_checkBox_radioButton;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T1_xpath_cssSelector_practices {
    public static void main(String[] args) {

        //TC #1: XPATH and cssSelector Practices
        //1. Open Chrome browser

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        //2. Go to https://practice.cydeo.com/forgot_password
        driver.get("https://practice.cydeo.com/forgot_password");

        //3. Locate all the WebElements on the page using XPATH and/or CSS
        //locator only (total of 6)
        //a. “Home” link
        //Locate "Home" link using cssSelector, syntax #1 class attribute value
        WebElement homeLink1 = driver.findElement(By.cssSelector("a[class='nav-link']"));
        WebElement homeLink2 = driver.findElement(By.cssSelector("a.nav-link"));
        WebElement homeLink3 = driver.findElement(By.cssSelector("a[href]"));


        //b. “Forgot password” header
        //Locate header, using xpath, using text of h2

        WebElement header1 = driver.findElement(By.xpath("//h2[. = 'Forgot Password']"));

        //Locate header, using cssSelector, locate parent element and move down to h2
        WebElement header2 = driver.findElement(By.cssSelector("div[class= 'example']>h2"));
        WebElement header3 = driver.findElement(By.cssSelector("div.example>h2"));


        //c. “E-mail” text
        //locate the "email" label using xpath
        WebElement emailLabel1 = driver.findElement(By.xpath("//label[@for= 'email']"));
        WebElement emailLabel2 = driver.findElement(By.xpath(" //label[text()= 'E-mail']"));
        WebElement emailLabel3 = driver.findElement(By.xpath(" //label[contains(text(), 'E-mail')]"));

        //d. E-mail input box
        //locate the "email" label using xpath
        WebElement emailInput1 = driver.findElement(By.xpath("//input[@name='email']"));
        //locate the "email" label using xpath contains method
        WebElement emailInput2 = driver.findElement(By.xpath("//input[contains(@pattern, '0-9')]"));

        //e. “Retrieve password” button
        WebElement retrievePasswordButton_1 = driver.findElement( By.xpath("//button[@id= 'form_submit']"));

        //f. “Powered by Cydeo text
        WebElement poweredByCydeo = driver.findElement(By.xpath("//div[@style= 'text-align: center;']"));
        //4. Verify all web elements are displayed.
        System.out.println("homeLink1.isDisplayed() = " + homeLink1.isDisplayed());
        System.out.println("header1 = " + header1.isDisplayed());
        System.out.println("emailLabel1 = " + emailLabel1.isDisplayed());
        System.out.println("emailInput1 = " + emailInput1.isDisplayed());
        System.out.println("poweredByCydeo = " + poweredByCydeo.isDisplayed());


        //First solve the task with using cssSelector only. Try to create 2 different
        //cssSelector if possible
        //Then solve the task using XPATH only. Try to create 2
    }
}

package com.cydeo.tests.day10_upload_actions_jsexexecutor;

import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.yaml.snakeyaml.nodes.CollectionNode;

public class T1_Registration_Form_Confirmation {
    //TC#1: Registration form confirmation
    @Test
    public static void test1() {

        //1. Open browser
        //2. Go to website: https://practice.cydeo.com/registration_form
        Driver.getDriver().get(ConfigurationReader.getProperty("registration.form.url"));

        Faker faker = new Faker();
        //3. Enter first name
        WebElement firstName = Driver.getDriver().findElement(By.xpath("//input[@name='firstname']"));
        firstName.sendKeys(faker.name().firstName());

        //4. Enter last name
        WebElement lastName = Driver.getDriver().findElement(By.xpath("//input[@name='lastname']"));
        lastName.sendKeys(faker.name().lastName());

        //5. Enter username
        WebElement userName = Driver.getDriver().findElement(By.xpath("//input[@name='username']"));
        userName.sendKeys("CydeoStudent");

        //6. Enter email address
        WebElement email = Driver.getDriver().findElement(By.xpath("//input[@name='email']"));
        email.sendKeys(faker.internet().emailAddress());

        //7. Enter password
        WebElement password = Driver.getDriver().findElement(By.xpath("//input[@name='password']"));
        password.sendKeys(faker.internet().password());

        //8. Enter phone number
        WebElement phone = Driver.getDriver().findElement(By.xpath("//input[@name='phone']"));
        phone.sendKeys(faker.numerify("717-###-####"));

        //9. Select a gender from radio buttons
        WebElement genderButton = Driver.getDriver().findElement(By.xpath("//input[@value='male']"));
        genderButton.click();

        //10.Enter date of birth
        WebElement birthday = Driver.getDriver().findElement(By.xpath("//input[@name='birthday']"));
        birthday.sendKeys("05/07/1998");

        //11.Select Department/Office
        Select select = new Select(Driver.getDriver().findElement(By.name("department")));
        select.selectByValue("DE");


        //12.Select Job Title
      Select jobTitleDropdown = new Select( Driver.getDriver().findElement(By.name("job_title")));
      jobTitleDropdown.selectByVisibleText("SDET");

        //13.Select programming language from checkboxes
        WebElement javaCheckBox = Driver.getDriver().findElement(By.xpath("//input[@value='java']"));
        javaCheckBox.click();
        WebElement javaScriptCheckBox = Driver.getDriver().findElement(By.xpath("//input[@value='javascript']"));
        javaScriptCheckBox.click();

        //14.Click to sign up button
        Driver.getDriver().findElement(By.xpath("//button[@type='submit']")).click();

        //15.Verify success message “You’ve successfully completed registration.” is displayed.

        Assert.assertTrue(Driver.getDriver().findElement(By.xpath("//div/p")).isDisplayed());

        //driver.quit();
        //Driver.getDriver().quit(); --> we don't use this method anymore. Because we want to assign the value back to null
        // So if we have another test, our code can continue executing.
        Driver.closeDriver();





    }
}

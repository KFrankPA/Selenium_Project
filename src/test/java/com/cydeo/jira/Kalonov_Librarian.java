package com.cydeo.jira;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
public class Kalonov_Librarian {
    //As a librarian, I should be able to edit the books' information.
    //
    //1 Verify the librarian can edit any book info from the books page.
    //2 There should be a pop up window displayed when user clicks the "Edit Book* button
    //3 "Edit Book Information" should be displayed on top of the pop up window.
    //4 "The book has been updated" confirmation message should be displayed.
    WebDriver driver;

    @BeforeMethod
    public void setupMethod() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @Test

    public void AC1_Edit_Button_IsDisplayed() {
        driver.get(ConfigurationReader.getProperty("website"));
        BrowserUtils.sleep(1);

        WebElement loginBox = driver.findElement(By.xpath("//input[@id='inputEmail']"));
        loginBox.sendKeys(ConfigurationReader.getProperty("username"));

        BrowserUtils.sleep(1);

        WebElement passwordBox = driver.findElement(By.xpath("//input[@id='inputPassword']"));
        passwordBox.sendKeys(ConfigurationReader.getProperty("password"));

        BrowserUtils.sleep(1);

        driver.findElement(By.xpath("//button[@type='submit']")).click();

        driver.findElement(By.xpath("//a[@href='#books']//span[1]")).click();

        Assert.assertTrue(driver.findElement(By.xpath("//a[contains(@onclick, 'Books.edit_book')]")).isDisplayed());


        driver.findElement(By.xpath("//a[contains(@onclick, 'Books.edit_book')]")).click();

        BrowserUtils.sleep(2);
        driver.findElement(By.xpath("//input[@name='name']")).clear();

        driver.findElement(By.xpath("//input[@name='name']")).sendKeys("Hello Team Nova");


        Assert.assertTrue(driver.findElement(By.xpath("//button[@type='submit']")).isDisplayed());

        driver.findElement(By.xpath("//button[@type='submit']")).click();

        ((JavascriptExecutor) driver).executeScript("window-open('https://google.com')");

    }

    @Test
    public void test2() {
        driver.get("https://library2.cydeo.com/#books");

    }
}



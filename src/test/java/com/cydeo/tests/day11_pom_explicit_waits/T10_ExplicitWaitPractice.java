package com.cydeo.tests.day11_pom_explicit_waits;

import com.cydeo.pages.DynamicLoad7Page;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class T10_ExplicitWaitPractice {

    @Test
    public void t10_wait_until_title_changes(){
        //TC#10 : Dynamically Loaded Page Elements 7
        //1. Go to https://practice.cydeo.com/dynamic_loading/7
        Driver.getDriver().get("https://practice.cydeo.com/dynamic_loading/7");

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(5));
        DynamicLoad7Page dynamicLoad7Page = new DynamicLoad7Page();

        //2. Wait until title is “Dynamic title”
        wait.until(ExpectedConditions.titleContains("Dynamic title"));
        //3. Assert: Message “Done” is displayed.
       // WebElement doneMsg = Driver.getDriver().findElement(By.xpath("//strong[.='Done!']"));
        //Assert.assertTrue(doneMsg.isDisplayed());
        Assert.assertTrue(dynamicLoad7Page.doneMessage.isDisplayed());
        //4. Assert: Image is displayed.
       // Assert.assertTrue(Driver.getDriver().findElement(By.tagName("img")).isDisplayed());
        Assert.assertTrue(dynamicLoad7Page.spongeBobImage.isDisplayed());
        //Note: Follow POM
    }
}

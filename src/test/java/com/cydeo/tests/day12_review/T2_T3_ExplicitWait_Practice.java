package com.cydeo.tests.day12_review;

import com.cydeo.pages.DynamicControlsPage;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class T2_T3_ExplicitWait_Practice {

    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();
    }

    @Test
    public void remove_checkbox() {
        //TC #2: Explicit wait practice
        //1- Open a chrome browser
        //2- Go to: https://practice.cydeo.com/dynamic_controls
        Driver.getDriver().get("https://practice.cydeo.com/dynamic_controls");
        DynamicControlsPage dynamicControlsPage = new DynamicControlsPage();
        //3- Click to “Remove” button
        dynamicControlsPage.removeButton.click();

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(7));
        //4- Wait until “loading bar disappears”
        wait.until(ExpectedConditions.invisibilityOf(dynamicControlsPage.loadingBar));
        //5- Verify:
        //a. Checkbox is not displayed

        try {
            Assert.assertTrue(!dynamicControlsPage.checkbox.isDisplayed());
            // Assert.assertFalse(dynamicControlsPage.checkbox.isDisplayed());
        }
        catch (NoSuchElementException e){
            e.printStackTrace();
            System.out.println("NoSuchElementException is thrown, it means that the Checkbox is not on the page");
            Assert.assertTrue(true);
        }
        //b. “It’s gone!” message is displayed.
        Assert.assertTrue(dynamicControlsPage.goneMessage.isDisplayed());
    }
}
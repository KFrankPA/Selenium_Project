package com.cydeo.tests.day10_upload_actions_jsexexecutor;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

public class T6_ScrollUsing_JavascriptExecutor {
    //TC #6: Scroll using JavascriptExecutor

    @Test
    public void infinite_scroll_test_JSExecutor(){

        //1- Open a chrome browser
        //2- Go to: https://practice.cydeo.com/infinite_scroll
        Driver.getDriver().get("https://practice.cydeo.com/infinite_scroll");

        //((JavascriptExecutor) Driver.getDriver()).executeScript("window.scrollBy(0,-550)");
        // OR
        JavascriptExecutor js= (JavascriptExecutor) Driver.getDriver();
        BrowserUtils.sleep(2);
        // window.scrollBy(x,y)
        for (int i = 0; i < 10; i++) {
            BrowserUtils.sleep(1);
            js.executeScript("window.scrollBy(0,750)");
        }
        //3- Use below JavaScript method and scroll
        //a. 750 pixels down 10 times.
        //b. 750 pixels up 10 times
        for (int i = 0; i < 10; i++) {
            BrowserUtils.sleep(1);
            js.executeScript("window.scrollBy(0,-250)");
        }

        //JavaScript method to use : window.scrollBy(0,0)


    }
}

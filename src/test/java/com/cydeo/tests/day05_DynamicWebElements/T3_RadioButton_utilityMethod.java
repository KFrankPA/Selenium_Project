package com.cydeo.tests.day05_DynamicWebElements;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.List;

public class T3_RadioButton_utilityMethod {
    public static void main(String[] args) {


            //DO NOT USE ANY DEVELOPER TOOLS TO GET ANY LOCATORS.
            //TC #2: Radiobutton handling
            //1. Open Chrome browser

            WebDriver driver = WebDriverFactory.getDriver("chrome");
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            //2. Go to https://practice.cydeo.com/radio_buttons
            driver.get("https://practice.cydeo.com/radio_buttons");

            //click and verify radio Button is selected
        clickAndVerifyRadioButton(driver, "sport", "hockey");
        clickAndVerifyRadioButton(driver, "sport", "football");
        clickAndVerifyRadioButton(driver, "color", "red");




        }
        public static void clickAndVerifyRadioButton(WebDriver driver, String nameAttribute, String expectedID){

            //List<WebElement> sportsRadioButtons = driver.findElements(By.xpath("//input[@name='"+nameAttribute+"']"));
            List<WebElement> radioButtons = driver.findElements(By.name(nameAttribute));


            //Locate all-of-the "sports" radio buttons, and store them in a List<WebElement>
            for (WebElement each : radioButtons) {
                String actualID = each.getAttribute("id");
                System.out.println("actualID = " + actualID );

                if(actualID.equalsIgnoreCase(expectedID)){
                    each.click();
                    System.out.println(actualID + " is selected: " + each.isSelected());
                    break;
                }
            }
        }
    }
        //USE XPATH LOCATOR FOR ALL WEBELEMENT LOCATORS
        //Create a utility method to handle above logic.
        //Method name: clickAndVerifyRadioButton
        //Return type: void or boolean
        //Method args:
        //1. WebDriver
        //2. Name attribute as String (for providing which group of radio buttons)
        //3. Id attribute as String (for providing which radio button to be clicked)
        //Method should loop through the given group of radio buttons. When it finds the
        //matching option, it should click and verify option is Selected.
        //Print out verification: true



package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class W3Page {

    //#1- Initialize the driver and 'object' of current class
    public W3Page() {
        PageFactory.initElements(Driver.getDriver(), this);
    }


        @FindBy (id="demo")
                public WebElement paragraph;



    }


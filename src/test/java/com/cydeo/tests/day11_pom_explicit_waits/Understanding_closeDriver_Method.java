package com.cydeo.tests.day11_pom_explicit_waits;

import com.cydeo.utilities.Driver;
import org.testng.annotations.Test;

public class Understanding_closeDriver_Method {

    @Test
    public void test1(){
        Driver.getDriver().get("https://google.com");
       // Driver.getDriver().close();
        Driver.closeDriver();

    }

    @Test
    public void test2(){
        Driver.getDriver().get("https://google.com");
        // Driver.getDriver().close();
        Driver.closeDriver();

    }

    @Test
    public void test3(){
        Driver.getDriver().get("https://google.com");
        // Driver.getDriver().close();
        Driver.closeDriver();

    }

}

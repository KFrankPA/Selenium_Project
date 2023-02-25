package com.cydeo.tests.day09_review_JavaFaker_DriverUtil_HP;

public class Singleton {

    //# 1 - Create a private constructor

    private Singleton(){}

    //# 2 - Private static String
    private static String word; //by default is null

    //# 3 - Utility method to return the 'private String' we just created

    public static String getWord(){
        if(word == null){
            System.out.println("First Time call. Word object is null.");
            System.out.println("Assigning value to it now.");
            word = "something";
        }else {
            System.out.println("Word " + word + " already has a value.");
        }

        return word;

    }
}

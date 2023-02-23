package com.cydeo.jira;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;

public class Test1 {
    @Test
    public void test1(){

        Faker faker = new Faker();

        String str = faker.numerify("######");
        System.out.println(str);

        System.out.printf(faker.chuckNorris().fact().replaceAll("Chuck Norris", "Kalonov"));

    }
}

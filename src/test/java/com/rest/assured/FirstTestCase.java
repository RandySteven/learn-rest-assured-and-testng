package com.rest.assured;

import org.testng.annotations.Test;

public class FirstTestCase {

    @Test(priority = 0)
    void setup(){
        System.out.println("Setup");
    }

    @Test(priority = 1)
    void login(){
        for(int i = 0 ; i < 5 ;i++){
            System.out.println("login");
        }
    }


    @Test(priority = 2)
    void teardown(){
        System.out.println("teardown");
    }
}

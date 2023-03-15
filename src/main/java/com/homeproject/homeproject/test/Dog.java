package com.homeproject.homeproject.test;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

public class Dog implements Animal{
    public void Dog(){}
    public void sound() {
        System.out.println("Woof!");
    }
}

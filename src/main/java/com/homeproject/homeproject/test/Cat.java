package com.homeproject.homeproject.test;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

public class Cat implements Animal{
    public void Cat(){}
    public void sound() {
        System.out.println("Meow!");
    }
}

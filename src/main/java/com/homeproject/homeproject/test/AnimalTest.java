package com.homeproject.homeproject.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import static com.homeproject.homeproject.test.AnimalEnum.*;

public class AnimalTest {
    public static void main(String[] args) {
        AnimalProviderFactory.getAnimal(CAT).sound();
        AnimalProviderFactory.getAnimal(DOG).sound();
    }
}

package com.homeproject.homeproject.test;


import static com.homeproject.homeproject.test.AnimalEnum.CAT;
import static com.homeproject.homeproject.test.AnimalEnum.DOG;

public class AnimalTest {
    public static void main(String[] args) {
        AnimalProviderFactory.getAnimal(CAT).sound();
        AnimalProviderFactory.getAnimal(DOG).sound();
    }
}

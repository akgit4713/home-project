package com.homeproject.homeproject.test;

import java.util.HashMap;
import java.util.Map;

import static com.homeproject.homeproject.test.AnimalEnum.CAT;
import static com.homeproject.homeproject.test.AnimalEnum.DOG;

public class AnimalProviderFactory {
    public static Map<Enum, Animal> map = new HashMap<>();

    public static Animal getAnimal(Enum animalEnum) {
        map.put(CAT, new Cat());
        map.put(DOG, new Dog());
        return map.get(animalEnum);
    }
}

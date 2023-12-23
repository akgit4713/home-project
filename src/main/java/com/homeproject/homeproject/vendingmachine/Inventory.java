package com.homeproject.homeproject.vendingmachine;

import java.util.Map;

interface Inventory<T> {
    Map<T, Integer> getAll();

    void updateInventory(T t, Integer count);

    boolean validate(Map<T, Integer> map);

}

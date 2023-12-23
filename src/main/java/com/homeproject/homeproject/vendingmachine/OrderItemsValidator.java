package com.homeproject.homeproject.vendingmachine;

import java.util.Map;

class OrderItemsValidator implements Validator<Item> {

    @Override
    public boolean validate(Map<Item, Integer> items) {

        return false;
    }
}

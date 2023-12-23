package com.homeproject.homeproject.vendingmachine;

import java.util.Map;

class ItemInventory implements Inventory<Item> {
    Map<Item, Integer> items;
    Validator<Item> orderValidator;

    public ItemInventory(Map<Item, Integer> items) {
        this.items = items;
        this.orderValidator = new OrderItemsValidator();
    }

    @Override
    public Map<Item, Integer> getAll() {
        return this.items;
    }

    @Override
    public void updateInventory(Item item, Integer countToAdd) {
        //Set inventory
    }

    @Override
    public boolean validate(Map<Item, Integer> map) {
        return orderValidator.validate(map);
    }
}

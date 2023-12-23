package com.homeproject.homeproject.vendingmachine;


import java.util.Map;

public class VendingMachine {
    private CoinInventory coinInventory;
    private ItemInventory itemInventory;

    public Map<Item, Integer> getAllItemsWithAvailableCount() {
        return itemInventory.getAll();
    }

    public boolean validateOrderItems(Map<Item, Integer> itemCountMap) {
        return itemInventory.validate(itemCountMap);
    }

    public boolean validateOrderCoins(Map<Coin, Integer> itemCountMap) {
        return coinInventory.validate(itemCountMap);
    }
}



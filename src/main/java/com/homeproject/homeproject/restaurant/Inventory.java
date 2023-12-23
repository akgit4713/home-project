package com.homeproject.homeproject.restaurant;

import java.util.List;

public interface Inventory<T> {
    List<T> getInventoryItems();
    void addInventoryItems(T inventoryType);
}

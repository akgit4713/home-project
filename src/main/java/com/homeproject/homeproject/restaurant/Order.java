package com.homeproject.homeproject.restaurant;

import java.util.List;
import java.util.Map;

public class Order {
    private String orderId;
    private Table table;
    private Double price;
    private Map<MenuItem, Integer> menuItemsMap;
}

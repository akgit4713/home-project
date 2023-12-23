package com.homeproject.homeproject.CarRental;

import java.util.List;

public interface Inventory<T> {
    void add(List<T> items);
    List<T> get();
    boolean remove(T item);
    T getItem(String id);
}

package com.homeproject.homeproject.restaurant;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {


    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
    }


}


/**
 *
 *  Waiter
 *  -id
 *  -name
 *  -List<Orders>
 *  -isOccupied
 *
 *
 *
 * Table
 * -id
 * -isOccupied
 * -List<Customers>
 * -Menu
 *
 * Customer
 * -id
 * -name
 *
 *
 * Menu
 * -List<MenuItem>
 *
 *
 * Order
 * -id
 * -Table
 * -List<MenuItems>
 *
 *
 * Reservation
 * -id
 * -Table
 * -List<Customers>
 * -startTime
 * -endTime
 *
 *
 *
 *
 *
 *
 *
 *
 */
package com.homeproject.homeproject.CarRental;

import lombok.*;


public class Bike extends Vehicle{
    public Bike(String vehicleId, String color, String name, boolean isBooked) {
        super(vehicleId, color, name, isBooked);
    }
}

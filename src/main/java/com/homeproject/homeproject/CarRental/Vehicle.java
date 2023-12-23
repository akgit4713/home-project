package com.homeproject.homeproject.CarRental;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
public class Vehicle {
    public String vehicleId;
    public String color;
    public String name;
    public boolean isBooked;
    public Vehicle(String vehicleId, String color, String name, boolean isBooked) {
        this.vehicleId = vehicleId;
        this.color = color;
        this.name = name;
        this.isBooked = isBooked;
    }

}

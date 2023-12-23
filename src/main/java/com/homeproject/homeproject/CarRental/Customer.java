package com.homeproject.homeproject.CarRental;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class Customer extends User {

    private List<RentalBooking> bookings = new ArrayList<>();
    private final Inventory<Vehicle> vehicleInventory;
    public Customer(String id, String name) {
        super(id, name);
        this.vehicleInventory = VehicleInventory.getInstance();
    }

    public RentalBooking createBooking(Vehicle vehicle, Date bookingDate, Date dueDate) {
        RentalBooking rentalBooking = new RentalBooking(UUID.randomUUID().toString(), this, bookingDate, dueDate, vehicle);
        bookings.add(rentalBooking);
        vehicleInventory.remove(vehicle);
        vehicle.setBooked(true);
        return rentalBooking;
    }

}

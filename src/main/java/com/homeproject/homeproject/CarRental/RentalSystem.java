package com.homeproject.homeproject.CarRental;

import java.util.Calendar;
import java.util.List;

public class RentalSystem {
    public static void main(String[] args) {
        Inventory<Vehicle> vehicleInventory = VehicleInventory.getInstance();
        vehicleInventory.add(List.of(new Car("id1","WHITE","TOYOTA",false), new Car("id2", "BLUE", "NISSAN",false)));
        vehicleInventory.add(List.of(new Bike("id3", "BLACK", "ENFIELD", false), new Bike("id4", "BROWN", "HIMALAYAN", false)));
        Customer customer = new Customer("c-id-1", "Anurag");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(Calendar.getInstance().getTime());
        calendar.add(Calendar.DATE, 3);
        RentalBooking booking = customer.createBooking(vehicleInventory.getItem("id1"), Calendar.getInstance().getTime(), calendar.getTime());
        System.out.println(booking);
        booking.addExtraService(new DriverService());
        booking.addExtraService(new WiFiService());
        booking.addEquipment( new NavigationEquipment());
        System.out.println(booking);
        System.out.println(vehicleInventory.get());
    }
}

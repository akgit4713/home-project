package com.homeproject.homeproject.CarRental;

import java.util.Calendar;

public class VehicleLog {
    private RentalBooking rentalBooking;

    public static void log(RentalBooking rentalBooking){
        System.out.println(Calendar.getInstance().getTime() +" : "+ rentalBooking);
    }
}

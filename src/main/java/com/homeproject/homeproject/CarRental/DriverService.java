package com.homeproject.homeproject.CarRental;

public class DriverService implements IService<RentalBooking>{
    @Override
    public void addService(RentalBooking booking) {
        VehicleLog.log(booking);

    }
}

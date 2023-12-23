package com.homeproject.homeproject.CarRental;

public class NavigationEquipment implements IEquipment<RentalBooking>{
    @Override
    public void addEquipment(RentalBooking booking) {
        VehicleLog.log(booking);

    }
}

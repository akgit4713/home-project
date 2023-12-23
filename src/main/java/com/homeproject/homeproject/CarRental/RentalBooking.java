package com.homeproject.homeproject.CarRental;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RentalBooking {
    private final String bookingId;
    private final User user;
    private final Date bookingDate;
    private final Date dueDate;
    private final Vehicle vehicle;
    private final List<IEquipment<RentalBooking>> equipmentList = new ArrayList<>();
    private final List<IService<RentalBooking>> serviceList = new ArrayList<>();
    public RentalBooking(String bookingId, User user, Date bookingDate, Date dueDate, Vehicle vehicle) {
        this.bookingId = bookingId;
        this.user = user;
        this.bookingDate = bookingDate;
        this.dueDate = dueDate;
        this.vehicle = vehicle;
    }

    @Override
    public String toString() {
        return "RentalBooking{" +
                "bookingId='" + bookingId + '\'' +
                ", user=" + user +
                ", bookingDate=" + bookingDate +
                ", dueDate=" + dueDate +
                ", vehicle=" + vehicle +
                ", equipmentList=" + equipmentList +
                ", serviceList=" + serviceList +
                '}';
    }

    public void addExtraService(IService<RentalBooking> service) {
        serviceList.add(service);
        service.addService(this);
        VehicleLog.log(this);
    }

    public void addEquipment(IEquipment<RentalBooking> equipment) {
        equipmentList.add(equipment);
        equipment.addEquipment(this);
        VehicleLog.log(this);

    }

}

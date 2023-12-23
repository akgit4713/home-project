package com.homeproject.homeproject.CarRental;

import java.util.ArrayList;
import java.util.List;

public class VehicleInventory implements Inventory<Vehicle>{
    private final List<Vehicle> vehicleList;
    private static VehicleInventory vehicleInventory;

    private VehicleInventory(){
        vehicleList = new ArrayList<>();
    }

    public static VehicleInventory getInstance(){
        if(vehicleInventory == null){
            vehicleInventory = new VehicleInventory();
        }
        return vehicleInventory;
    }
    @Override
    public void add(List<Vehicle> items) {
        vehicleList.addAll(items);
    }

    @Override
    public List<Vehicle> get() {
        return vehicleList;
    }

    @Override
    public boolean remove(Vehicle item) {
        return vehicleList.remove(item);
    }

    @Override
    public Vehicle getItem(String id) {
        for(Vehicle vehicle : vehicleList){
            if(vehicle.getVehicleId().equals(id))
                return  vehicle;
        }
        return null;
    }
}

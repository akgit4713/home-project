package com.homeproject.homeproject.restaurant;

import java.util.ArrayList;
import java.util.List;

public class EmployeeInventory implements Inventory<Employee>{
    public List<Employee> employeeList = new ArrayList<>();
    @Override
    public List<Employee> getInventoryItems() {
        return employeeList;
    }

    @Override
    public void addInventoryItems(Employee employee) {
        employeeList.add(employee);
    }
}

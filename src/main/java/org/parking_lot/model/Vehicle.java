package org.parking_lot.model;

import org.parking_lot.enums.VehicleType;

abstract public class Vehicle {
    private VehicleType type;
    private String number;

    public Vehicle(String number, VehicleType type) {
        this.number = number;
        this.type = type;
    }

    public String getNumber() {
        return number;
    }

    public VehicleType getType(){
        return type;
    }
}

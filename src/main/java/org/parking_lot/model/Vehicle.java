package org.parking_lot.model;

import org.parking_lot.enums.VehicleType;

abstract public class Vehicle {
    VehicleType type;
    String number;

    public Vehicle(String number, VehicleType type) {
        this.number = number;
        this.type = type;
    }
}

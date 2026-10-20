package org.parking_lot.model;

import org.parking_lot.enums.VehicleType;

public class Bike extends Vehicle {
    public Bike(String number) {
        super(number, VehicleType.BIKE);
    }
}

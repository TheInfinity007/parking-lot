package org.parking_lot.model;

import org.parking_lot.enums.VehicleType;

public class Truck extends Vehicle{
    public Truck(String number) {
        super(number, VehicleType.TRUCK);
    }
}

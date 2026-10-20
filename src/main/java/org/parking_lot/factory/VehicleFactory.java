package org.parking_lot.factory;

import org.parking_lot.enums.VehicleType;
import org.parking_lot.model.Bike;
import org.parking_lot.model.Car;
import org.parking_lot.model.Vehicle;

public class VehicleFactory {
    Vehicle create(String number, VehicleType type) {

        if (type == null) {
            throw new IllegalArgumentException("Vehicle type cannot be null");
        }

        switch (type) {
            case BIKE:
                return new Bike(number);
            case CAR:
                return new Car(number);
            default:
                throw new IllegalArgumentException("Unsupported vehicle type: " + type);
        }
    }
}

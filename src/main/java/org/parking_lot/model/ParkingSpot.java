package org.parking_lot.model;

import org.parking_lot.enums.VehicleType;

import java.util.concurrent.atomic.AtomicBoolean;

public class ParkingSpot {
    String id;
    VehicleType allowedType;
    AtomicBoolean occupied;

    boolean tryOccupy(){
        return false;
    }

    void vacant(){
    }

    boolean isOccupied(){
        return false;
    }





}

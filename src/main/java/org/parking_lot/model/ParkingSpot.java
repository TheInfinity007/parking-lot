package org.parking_lot.model;

import org.parking_lot.enums.VehicleType;

import java.util.concurrent.atomic.AtomicBoolean;

public class ParkingSpot {
    private String id;
    private VehicleType allowedType;
    private AtomicBoolean occupied;

    public ParkingSpot(String id, VehicleType vehicleType) {
        this.id = id;
        this.allowedType = vehicleType;
        this.occupied = new AtomicBoolean(false);
    }

    public String getId() {
        return id;
    }

    boolean tryOccupy(){
        return false;
    }

    void vacant(){
    }

    boolean isOccupied(){
        return false;
    }





}

package org.parking_lot.model;

import org.parking_lot.enums.VehicleType;

import java.util.concurrent.atomic.AtomicBoolean;

public class ParkingSpot {
    private final String id;
    private final VehicleType allowedType;
    private final AtomicBoolean occupied;

    public ParkingSpot(String id, VehicleType vehicleType) {
        this.id = id;
        this.allowedType = vehicleType;
        this.occupied = new AtomicBoolean(false);
    }

    public String getId() {
        return id;
    }

    public VehicleType getAllowedType() {
        return allowedType;
    }


    public boolean tryOccupy() {
        return occupied.compareAndSet(false, true);
    }

    public void vacant() {
        occupied.set(false);
    }

    public boolean isOccupied() {
        return occupied.get();
    }


}

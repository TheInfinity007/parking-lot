package org.parking_lot.model;

import org.parking_lot.enums.VehicleType;

import java.util.Map;

public class ParkingFloor {
    private String id;

    private Map<String, ParkingSpot> spots;

    public ParkingFloor(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    void findAvailableSpots(VehicleType vehicleType){

    }

    public void addSpot(ParkingSpot parkingSpot) {
        spots.put(parkingSpot.getId(), parkingSpot);
    }
}

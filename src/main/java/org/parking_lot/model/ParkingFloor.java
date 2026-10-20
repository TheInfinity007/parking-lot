package org.parking_lot.model;

import org.parking_lot.enums.VehicleType;

import java.util.Map;

public class ParkingFloor {
    String id;

    Map<String, ParkingSpot> spots;

    public ParkingFloor(String id) {
        this.id = id;
    }

    void findAvailableSpots(VehicleType vehicleType){

    }

    public void addSpot(ParkingSpot parkingSpot) {
        spots.put(parkingSpot.id, parkingSpot);
    }
}

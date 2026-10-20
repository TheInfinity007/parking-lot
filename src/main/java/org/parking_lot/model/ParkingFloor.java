package org.parking_lot.model;

import org.parking_lot.enums.VehicleType;

import java.util.HashMap;
import java.util.Map;

public class ParkingFloor {
    private String id;

    private Map<String, ParkingSpot> spots;

    public ParkingFloor(String id) {
        this.id = id;
        this.spots = new HashMap<>();
    }

    public String getId() {
        return id;
    }

    public Map<String, ParkingSpot> getSpots() {
        return spots;
    }

    public void addSpot(ParkingSpot spot) {
        spots.put(spot.getId(), spot);
    }

    public ParkingSpot findAvailableSpots(VehicleType vehicleType){
        for(ParkingSpot spot: spots.values()){
            if(spot.getAllowedType() == vehicleType && spot.tryOccupy()){
                return spot;
            }
        }

        return null;
    }


}

package org.parking_lot;

import org.parking_lot.enums.PricingStrategyType;
import org.parking_lot.enums.VehicleType;
import org.parking_lot.factory.PricingStrategyFactory;
import org.parking_lot.model.EntryGate;
import org.parking_lot.model.ExitGate;
import org.parking_lot.model.ParkingFloor;
import org.parking_lot.model.ParkingSpot;
import org.parking_lot.service.ParkingLot;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {
        ParkingLot lot = ParkingLot.getInstance();
        EntryGate entryGate = new EntryGate("EG1");
        ExitGate exitGate = new ExitGate("XG1");

        lot.setPricingStrategy(PricingStrategyFactory.get(PricingStrategyType.EVENT_BASED));

        ParkingFloor floor1 = new ParkingFloor("Floor1");
        floor1.addSpot(new ParkingSpot("F1S1", VehicleType.BIKE));
        floor1.addSpot(new ParkingSpot("F1S2", VehicleType.CAR));
        floor1.addSpot(new ParkingSpot("F1S3", VehicleType.TRUCK));
        floor1.addSpot(new ParkingSpot("F1S4", VehicleType.CAR));

        lot.addFloor(floor1);

        System.out.println("-----------------------------------------");
    }
}

package org.parking_lot;

import org.parking_lot.enums.PaymentMode;
import org.parking_lot.enums.PricingStrategyType;
import org.parking_lot.enums.VehicleType;
import org.parking_lot.factory.PricingStrategyFactory;
import org.parking_lot.factory.VehicleFactory;
import org.parking_lot.model.*;
import org.parking_lot.service.ParkingLot;
import org.parking_lot.utils.DateTimeParser;

import java.time.LocalDateTime;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {
        ParkingLot lot = ParkingLot.getInstance();
        EntryGate entryGate = new EntryGate("EG1");
        ExitGate exitGate = new ExitGate("XG1");

        lot.setPricingStrategy(PricingStrategyFactory.get(PricingStrategyType.TIME_BASED));

        ParkingFloor floor1 = new ParkingFloor("Floor1");
        floor1.addSpot(new ParkingSpot("F1S1", VehicleType.BIKE));
        floor1.addSpot(new ParkingSpot("F1S2", VehicleType.CAR));
        floor1.addSpot(new ParkingSpot("F1S3", VehicleType.TRUCK));
        floor1.addSpot(new ParkingSpot("F1S4", VehicleType.CAR));

        lot.addFloor(floor1);

        System.out.println("-----------------------------------------");

        Vehicle car = VehicleFactory.create("KA01AB1234", VehicleType.CAR);
        LocalDateTime entryTime = DateTimeParser.parse("21 May 7:03 AM 2025");

        Ticket ticket = entryGate.parkVehicle(car, entryTime);
        System.out.println("-----------------------------------------");

        lot.printStatus();

        System.out.println("-----------------------------------------");

        LocalDateTime exitTime = DateTimeParser.parse("21 May 1:15 PM 2025");
        exitGate.unparkVehicle(ticket.getTicketId(), exitTime, PaymentMode.CARD);

        System.out.println("-----------------------------------------");

        lot.printStatus();

/*
        Vehicle bike1 = VehicleFactory.create("KA01AB1234", VehicleType.BIKE);
        Vehicle bike2 = VehicleFactory.create("KA01AB1234", VehicleType.BIKE);
        LocalDateTime entryTimeBike = DateTimeParser.parse("21 May 7:03 AM 2025");

        Thread t1 = new Thread(() -> entryGate.parkVehicle(bike1, entryTimeBike));
        Thread t2 = new Thread(() -> entryGate.parkVehicle(bike2, entryTimeBike));

        t1.start();
        t2.start();

 */
    }
}

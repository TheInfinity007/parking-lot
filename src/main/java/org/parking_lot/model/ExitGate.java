package org.parking_lot.model;

import org.parking_lot.enums.GateType;
import org.parking_lot.enums.PaymentMode;
import org.parking_lot.service.ParkingLot;

import java.time.LocalDateTime;

public class ExitGate extends Gate {

    public ExitGate(String id) {
        super(id);
    }

    public void unparkVehicle(String ticketId, LocalDateTime exitTime, PaymentMode paymentMode) {
        ParkingLot.getInstance().unparkVehicle(ticketId, exitTime, paymentMode);
    }

    @Override
    public GateType getType() {
        return GateType.EXIT;
    }
}

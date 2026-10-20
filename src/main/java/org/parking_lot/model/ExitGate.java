package org.parking_lot.model;

import org.parking_lot.enums.GateType;
import org.parking_lot.service.PaymentStrategy;

import java.time.LocalDateTime;

public class ExitGate extends Gate{

    public ExitGate(String gateId) {
        super(GateType.Exit, gateId);
    }

    public void unparkVehicle(String ticketId, LocalDateTime exitTime, PaymentStrategy paymentMode){

    }
}

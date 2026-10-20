package org.parking_lot.model;

import org.parking_lot.enums.GateType;
import org.parking_lot.enums.PaymentMode;

import java.time.LocalDateTime;

public class ExitGate extends Gate{

    public ExitGate(String gateId) {
        super(GateType.Exit, gateId);
    }

    public void unparkVehicle(String ticketId, LocalDateTime exitTime, PaymentMode paymentMode){
        System.out.println("Paid Rs. 120.0 for ticket " + ticketId + " via " + paymentMode.toString());
        System.out.println("Vehicle exited. Fee charged: Rs. 120.0");
    }
}

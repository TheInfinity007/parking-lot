package org.parking_lot;

import org.parking_lot.model.EntryGate;
import org.parking_lot.model.ExitGate;
import org.parking_lot.service.ParkingLot;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {
        ParkingLot lot = ParkingLot.getInstance();
        EntryGate entryGate = new EntryGate("EG1");
        ExitGate exitGate = new ExitGate("XG1");
    }
}

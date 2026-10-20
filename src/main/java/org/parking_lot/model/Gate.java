package org.parking_lot.model;

import org.parking_lot.enums.GateType;

abstract class Gate {
    String id;
    GateType gateType;

    public Gate(GateType gateType) {
        this.gateType = gateType;
    }

    public GateType getType() {
        return this.gateType;
    }
}

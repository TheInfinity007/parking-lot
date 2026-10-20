package org.parking_lot.model;

import org.parking_lot.enums.GateType;

abstract class Gate {
    String id;
    GateType gateType;

    public Gate(GateType gateType, String gateId) {
        this.gateType = gateType;
        this.id = gateId;
    }

    public GateType getType() {
        return this.gateType;
    }
}

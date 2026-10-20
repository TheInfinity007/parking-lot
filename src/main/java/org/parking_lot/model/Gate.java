package org.parking_lot.model;

import org.parking_lot.enums.GateType;

public abstract class Gate {
    private final String id;

    public Gate(String gateId) {
        this.id = gateId;
    }

    public String getId() {
        return id;
    }

    public abstract GateType getType();
}

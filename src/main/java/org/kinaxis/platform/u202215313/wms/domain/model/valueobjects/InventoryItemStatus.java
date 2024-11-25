package org.kinaxis.platform.u202215313.wms.domain.model.valueobjects;

public enum InventoryItemStatus {
    AVAILABLE(0),
    SUPPLY_NEEDED(1),
    AUDITING(2),
    DISABLED(3);

    private final int value;

    InventoryItemStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
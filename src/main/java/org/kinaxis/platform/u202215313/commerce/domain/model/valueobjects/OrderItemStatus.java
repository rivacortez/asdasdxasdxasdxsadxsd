package org.kinaxis.platform.u202215313.commerce.domain.model.valueobjects;

public enum OrderItemStatus {
    READY_FOR_DISPATCH(0),
    IN_PROCESS(1),
    DISPATCHING(2),
    COMPLETED(3);

    private final int value;

    OrderItemStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
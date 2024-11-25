package org.kinaxis.platform.u202215313.commerce.domain.exceptions;

public class InventoryItemNotFoundException extends RuntimeException    {
    public InventoryItemNotFoundException(String message) {
        super(message);
    }
}

package org.kinaxis.platform.u202215313.commerce.domain.exceptions;

public class DuplicateOrderItemException extends RuntimeException {
    public DuplicateOrderItemException(String message) {
        super(message);
    }
}

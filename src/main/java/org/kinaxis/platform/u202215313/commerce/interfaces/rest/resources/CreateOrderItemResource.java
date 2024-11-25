package org.kinaxis.platform.u202215313.commerce.interfaces.rest.resources;


public record CreateOrderItemResource(
        Long orderId,
        String kinaxisSku,
        Double requestedQuantity
) {
}
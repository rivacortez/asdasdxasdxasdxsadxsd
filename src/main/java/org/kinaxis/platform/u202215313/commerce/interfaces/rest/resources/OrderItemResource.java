package org.kinaxis.platform.u202215313.commerce.interfaces.rest.resources;

import java.util.Date;

public record OrderItemResource(
        Long id,
        Long orderId,
        String kinaxisSku,
        Double requestedQuantity,
        String status,
        Date orderedAt
) {
}
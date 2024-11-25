package org.kinaxis.platform.u202215313.commerce.domain.model.commands;

import java.util.UUID;

public record CreateOrderItemCommand(
        Long orderId,
        UUID kinaxisSku,
        Double requestedQuantity
) {
}
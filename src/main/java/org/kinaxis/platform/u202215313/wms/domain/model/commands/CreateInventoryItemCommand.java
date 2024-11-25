package org.kinaxis.platform.u202215313.wms.domain.model.commands;

import java.util.UUID;

public record CreateInventoryItemCommand(
        UUID kinaxisSku,
        Double minimumQuantity,
        Double availableQuantity
) {
}
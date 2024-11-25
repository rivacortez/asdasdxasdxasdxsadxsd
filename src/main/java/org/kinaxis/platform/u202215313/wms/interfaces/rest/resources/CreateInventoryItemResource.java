package org.kinaxis.platform.u202215313.wms.interfaces.rest.resources;

public record CreateInventoryItemResource(
        String kinaxisSku,
        Double minimumQuantity,
        Double availableQuantity
) {
}
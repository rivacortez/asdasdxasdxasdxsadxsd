package org.kinaxis.platform.u202215313.wms.interfaces.rest.resources;

public record InventoryItemResource(
        Long id,
        String kinaxisSku,
        String status,
        Double minimumQuantity,
        Double availableQuantity,
        Double reservedQuantity,
        Double pendingSupplyQuantity
) {
}
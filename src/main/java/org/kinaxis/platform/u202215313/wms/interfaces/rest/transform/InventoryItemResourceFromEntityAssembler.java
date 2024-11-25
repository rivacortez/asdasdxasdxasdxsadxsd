package org.kinaxis.platform.u202215313.wms.interfaces.rest.transform;

import org.kinaxis.platform.u202215313.wms.domain.model.aggregates.InventoryItem;
import org.kinaxis.platform.u202215313.wms.interfaces.rest.resources.InventoryItemResource;

public class InventoryItemResourceFromEntityAssembler {

    public InventoryItemResource toResource(InventoryItem entity) {
        return new InventoryItemResource(
                entity.getId(),
                entity.getKinaxisSku().toString(),
                entity.getStatus().name(),
                entity.getMinimumQuantity(),
                entity.getAvailableQuantity(),
                entity.getReservedQuantity(),
                entity.getPendingSupplyQuantity()
        );
    }
}
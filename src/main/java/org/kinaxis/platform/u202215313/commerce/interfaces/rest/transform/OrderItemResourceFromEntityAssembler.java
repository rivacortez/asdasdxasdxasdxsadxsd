package org.kinaxis.platform.u202215313.commerce.interfaces.rest.transform;

import org.kinaxis.platform.u202215313.commerce.domain.model.aggregates.OrderItem;
import org.kinaxis.platform.u202215313.commerce.interfaces.rest.resources.OrderItemResource;
import org.kinaxis.platform.u202215313.wms.domain.model.aggregates.InventoryItem;
import org.kinaxis.platform.u202215313.wms.interfaces.rest.resources.InventoryItemResource;

public class OrderItemResourceFromEntityAssembler {

    public static OrderItemResource toResource(OrderItem entity) {
        return new OrderItemResource(
                entity.getId(),
                entity.getOrderId(),
                entity.getKinaxisSku().toString(),
                entity.getRequestedQuantity(),
                entity.getStatus().name(),
                entity.getOrderedAt()
        );
    }
}
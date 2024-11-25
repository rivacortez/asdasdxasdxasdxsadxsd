package org.kinaxis.platform.u202215313.commerce.interfaces.rest.transform;


import org.kinaxis.platform.u202215313.commerce.domain.model.commands.CreateOrderItemCommand;
import org.kinaxis.platform.u202215313.commerce.interfaces.rest.resources.CreateOrderItemResource;

import java.util.UUID;

public class CreateOrderItemCommandFromResourceAssembler {

    public static CreateOrderItemCommand toCommand(CreateOrderItemResource resource) {
        return new CreateOrderItemCommand(
                resource.orderId(),
                UUID.fromString(resource.kinaxisSku()),
                resource.requestedQuantity()
        );
    }
}
package org.kinaxis.platform.u202215313.wms.interfaces.rest.transform;

import org.kinaxis.platform.u202215313.wms.domain.model.commands.CreateInventoryItemCommand;
import org.kinaxis.platform.u202215313.wms.interfaces.rest.resources.CreateInventoryItemResource;

import java.util.UUID;

public class CreateInventoryItemCommandFromResourceAssembler {

    public static CreateInventoryItemCommand toCommand(CreateInventoryItemResource resource) {
        return new CreateInventoryItemCommand(
                UUID.fromString(resource.kinaxisSku()),
                resource.minimumQuantity(),
                resource.availableQuantity()
        );
    }
}
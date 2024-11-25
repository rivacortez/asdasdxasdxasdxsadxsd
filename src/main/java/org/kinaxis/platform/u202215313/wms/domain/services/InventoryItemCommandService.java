package org.kinaxis.platform.u202215313.wms.domain.services;

import org.kinaxis.platform.u202215313.wms.domain.model.commands.CreateInventoryItemCommand;
import org.kinaxis.platform.u202215313.wms.domain.model.aggregates.InventoryItem;

public interface InventoryItemCommandService {
    InventoryItem createInventoryItem(CreateInventoryItemCommand command);
}
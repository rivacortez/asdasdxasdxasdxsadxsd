package org.kinaxis.platform.u202215313.wms.application.internal.commandservices;


import org.kinaxis.platform.u202215313.wms.domain.model.aggregates.InventoryItem;
import org.kinaxis.platform.u202215313.wms.domain.model.commands.CreateInventoryItemCommand;
import org.kinaxis.platform.u202215313.wms.domain.services.InventoryItemCommandService;
import org.kinaxis.platform.u202215313.wms.infrastruture.persistence.jpa.repositories.InventoryItemRepository;
import org.kinaxis.platform.u202215313.wms.domain.model.valueobjects.InventoryItemStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InventoryItemCommandServiceImpl implements InventoryItemCommandService {

    @Autowired
    private InventoryItemRepository repository;

    @Override
    public InventoryItem createInventoryItem(CreateInventoryItemCommand command) {
        if (repository.existsByKinaxisSku(command.kinaxisSku())) {
            throw new IllegalArgumentException("Inventory item with this SKU already exists");
        }
        InventoryItem item = new InventoryItem();
        item.setKinaxisSku(command.kinaxisSku());
        item.setMinimumQuantity(command.minimumQuantity());
        item.setAvailableQuantity(command.availableQuantity());
        item.setStatus(InventoryItemStatus.AVAILABLE);
        return repository.save(item);
    }
}
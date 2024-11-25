package org.kinaxis.platform.u202215313.commerce.application.acl;


import org.kinaxis.platform.u202215313.commerce.interfaces.acl.InventoryItemContextFacade;
import org.kinaxis.platform.u202215313.wms.domain.model.aggregates.InventoryItem;
import org.kinaxis.platform.u202215313.wms.infrastruture.persistence.jpa.repositories.InventoryItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class InventoryItemContextFacadeImpl implements InventoryItemContextFacade {

    @Autowired
    private InventoryItemRepository inventoryItemRepository;

    @Override
    public boolean existsByKinaxisSku(UUID kinaxisSku) {
        return inventoryItemRepository.existsByKinaxisSku(kinaxisSku);
    }

    @Override
    public void updateQuantities(UUID kinaxisSku, double availableQuantity, double reservedQuantity, double pendingSupplyQuantity) {
        InventoryItem item = inventoryItemRepository.findByKinaxisSku(kinaxisSku)
                .orElseThrow(() -> new IllegalArgumentException("Inventory item not found"));
        item.setAvailableQuantity(availableQuantity);
        item.setReservedQuantity(reservedQuantity);
        item.setPendingSupplyQuantity(pendingSupplyQuantity);
        inventoryItemRepository.save(item);
    }
}
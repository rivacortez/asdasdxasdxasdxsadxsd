package org.kinaxis.platform.u202215313.wms.application.internal.outboundservices.acl;
import org.kinaxis.platform.u202215313.wms.domain.model.aggregates.InventoryItem;
import org.kinaxis.platform.u202215313.wms.infrastruture.persistence.jpa.repositories.InventoryItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.UUID;

@Service
public class InventoryItemService {

    @Autowired
    private InventoryItemRepository repository;

    public InventoryItem createInventoryItem(InventoryItem item) {
        if (repository.existsByKinaxisSku(item.getKinaxisSku())) {
            throw new IllegalArgumentException("Inventory item with this SKU already exists");
        }
        return repository.save(item);
    }
}
package org.kinaxis.platform.u202215313.commerce.interfaces.acl;

import java.util.UUID;

public interface InventoryItemContextFacade {
    boolean existsByKinaxisSku(UUID kinaxisSku);
    void updateQuantities(UUID kinaxisSku, double availableQuantity, double reservedQuantity, double pendingSupplyQuantity);
}
package org.kinaxis.platform.u202215313.wms.infrastruture.persistence.jpa.repositories;

import org.kinaxis.platform.u202215313.wms.domain.model.aggregates.InventoryItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface InventoryItemRepository extends JpaRepository<InventoryItem, Long> {
    boolean existsByKinaxisSku(UUID kinaxisSku);
    Optional<InventoryItem> findByKinaxisSku(UUID kinaxisSku);
}
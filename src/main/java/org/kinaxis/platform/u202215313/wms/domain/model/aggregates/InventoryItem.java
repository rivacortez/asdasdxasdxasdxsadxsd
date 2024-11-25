package org.kinaxis.platform.u202215313.wms.domain.model.aggregates;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.kinaxis.platform.u202215313.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import org.kinaxis.platform.u202215313.wms.domain.model.valueobjects.InventoryItemStatus;

import java.util.UUID;

@Entity
@Table(name = "inventory_items")
public class InventoryItem extends AuditableAbstractAggregateRoot<InventoryItem> {

    @Getter
    @Setter
    @Column(nullable = false, unique = true)
    private UUID kinaxisSku;

    @Getter
    @Setter
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private InventoryItemStatus status = InventoryItemStatus.AVAILABLE;

    @Getter
    @Setter
    @Column(nullable = false)
    private Double minimumQuantity;

    @Getter
    @Setter
    @Column(nullable = false)
    private Double availableQuantity;

    @Getter
    @Setter
    @Column
    private Double reservedQuantity = 0.0;

    @Getter
    @Setter
    @Column
    private Double pendingSupplyQuantity = 0.0;

    @PrePersist
    @PreUpdate
    private void validateQuantities() {
        if (minimumQuantity <= 5) {
            throw new IllegalArgumentException("Minimum quantity must be greater than 5");
        }
        if (availableQuantity < 2 * minimumQuantity) {
            throw new IllegalArgumentException("Available quantity must be at least twice the minimum quantity");
        }
    }
}
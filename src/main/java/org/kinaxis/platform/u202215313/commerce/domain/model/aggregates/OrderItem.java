package org.kinaxis.platform.u202215313.commerce.domain.model.aggregates;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.kinaxis.platform.u202215313.commerce.domain.model.valueobjects.OrderItemStatus;
import org.kinaxis.platform.u202215313.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "order_items", uniqueConstraints = @UniqueConstraint(columnNames = {"orderId", "kinaxisSku"}))
public class OrderItem extends AuditableAbstractAggregateRoot<OrderItem> {

    @Getter
    @Setter
    @Column(nullable = false)
    private Long orderId;

    @Getter
    @Setter
    @Column(nullable = false)
    private UUID kinaxisSku;

    @Getter
    @Setter
    @Column(nullable = false)
    private Double requestedQuantity;

    @Getter
    @Setter
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private OrderItemStatus status = OrderItemStatus.READY_FOR_DISPATCH;

    @Getter
    @Setter
    @Column(nullable = false)
    private Date orderedAt;

    @PrePersist
    @PreUpdate
    private void validateOrder() {
        if (orderId <= 0) {
            throw new IllegalArgumentException("Order ID must be greater than 0");
        }
        if (requestedQuantity <= 0) {
            throw new IllegalArgumentException("Requested quantity must be greater than 0");
        }
        if (orderedAt.after(new Date())) {
            throw new IllegalArgumentException("Ordered date cannot be in the future");
        }
    }
}
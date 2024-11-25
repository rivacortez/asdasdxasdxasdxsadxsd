package org.kinaxis.platform.u202215313.commerce.infrastruture.persistence.jpa.repositories;


import org.kinaxis.platform.u202215313.commerce.domain.model.aggregates.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
    List<OrderItem> findByOrderId(Long orderId);
    List<OrderItem> findByKinaxisSku(UUID kinaxisSku);
}
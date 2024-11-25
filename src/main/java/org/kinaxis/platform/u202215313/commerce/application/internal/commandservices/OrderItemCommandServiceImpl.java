package org.kinaxis.platform.u202215313.commerce.application.internal.commandservices;


import org.kinaxis.platform.u202215313.commerce.domain.model.aggregates.OrderItem;
import org.kinaxis.platform.u202215313.commerce.domain.model.commands.CreateOrderItemCommand;
import org.kinaxis.platform.u202215313.commerce.domain.services.OrderItemCommandService;
import org.kinaxis.platform.u202215313.commerce.infrastruture.persistence.jpa.repositories.OrderItemRepository;
import org.kinaxis.platform.u202215313.commerce.domain.model.valueobjects.OrderItemStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class OrderItemCommandServiceImpl implements OrderItemCommandService {

    @Autowired
    private OrderItemRepository repository;

    @Override
    public OrderItem createOrderItem(CreateOrderItemCommand command) {
        OrderItem item = new OrderItem();
        item.setOrderId(command.orderId());
        item.setKinaxisSku(command.kinaxisSku());
        item.setRequestedQuantity(command.requestedQuantity());
        item.setStatus(OrderItemStatus.READY_FOR_DISPATCH);
        item.setOrderedAt(new Date());
        return repository.save(item);
    }
}
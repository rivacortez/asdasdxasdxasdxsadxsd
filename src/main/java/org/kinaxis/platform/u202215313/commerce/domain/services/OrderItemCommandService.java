package org.kinaxis.platform.u202215313.commerce.domain.services;

import org.kinaxis.platform.u202215313.commerce.domain.model.aggregates.OrderItem;
import org.kinaxis.platform.u202215313.commerce.domain.model.commands.CreateOrderItemCommand;

public interface OrderItemCommandService {
    OrderItem createOrderItem(CreateOrderItemCommand command);
}
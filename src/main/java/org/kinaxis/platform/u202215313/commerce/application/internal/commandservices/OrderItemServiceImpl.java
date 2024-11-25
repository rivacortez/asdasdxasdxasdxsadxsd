package org.kinaxis.platform.u202215313.commerce.application.internal.commandservices;


import org.kinaxis.platform.u202215313.commerce.domain.model.aggregates.OrderItem;
import org.kinaxis.platform.u202215313.commerce.domain.model.commands.CreateOrderItemCommand;
import org.kinaxis.platform.u202215313.commerce.domain.services.OrderItemCommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class OrderItemServiceImpl implements OrderItemCommandService {

    private final OrderItemCommandService orderItemCommandService;

    @Autowired
    public OrderItemServiceImpl(@Qualifier("orderItemCommandServiceImpl") OrderItemCommandService orderItemCommandService) {
        this.orderItemCommandService = orderItemCommandService;
    }

    @Override
    public OrderItem createOrderItem(CreateOrderItemCommand command) {
        return orderItemCommandService.createOrderItem(command);
    }
}
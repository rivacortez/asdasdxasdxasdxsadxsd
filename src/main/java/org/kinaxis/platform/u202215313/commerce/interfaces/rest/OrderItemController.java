package org.kinaxis.platform.u202215313.commerce.interfaces.rest;




import org.kinaxis.platform.u202215313.commerce.domain.model.aggregates.OrderItem;
import org.kinaxis.platform.u202215313.commerce.domain.services.OrderItemCommandService;
import org.kinaxis.platform.u202215313.commerce.interfaces.rest.resources.CreateOrderItemResource;
import org.kinaxis.platform.u202215313.commerce.interfaces.rest.resources.OrderItemResource;
import org.kinaxis.platform.u202215313.commerce.interfaces.rest.transform.CreateOrderItemCommandFromResourceAssembler;
import org.kinaxis.platform.u202215313.commerce.interfaces.rest.transform.OrderItemResourceFromEntityAssembler;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "api/v1/orders/{orderId}/items", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Order Items", description = "Endpoints for managing order items")
public class OrderItemController {

    private final OrderItemCommandService orderItemCommandService;

    public OrderItemController(@Qualifier("orderItemCommandServiceImpl") OrderItemCommandService orderItemCommandService) {
        this.orderItemCommandService = orderItemCommandService;
    }

    @PostMapping
    @Operation(summary = "Create a new order item", description = "Create a new order item with the provided data")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Order item created"),
            @ApiResponse(responseCode = "400", description = "Invalid data provided")
    })
    public ResponseEntity<OrderItemResource> createOrderItem(@PathVariable Long orderId, @RequestBody CreateOrderItemResource resource) {
        var command = CreateOrderItemCommandFromResourceAssembler.toCommand(resource);
        var orderItem = orderItemCommandService.createOrderItem(command);
        var orderItemResource = OrderItemResourceFromEntityAssembler.toResource(orderItem);
        return new ResponseEntity<>(orderItemResource, HttpStatus.CREATED);
    }


}
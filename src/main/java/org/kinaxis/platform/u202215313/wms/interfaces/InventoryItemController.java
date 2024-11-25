package org.kinaxis.platform.u202215313.wms.interfaces;



import org.kinaxis.platform.u202215313.wms.domain.model.aggregates.InventoryItem;
import org.kinaxis.platform.u202215313.wms.domain.services.InventoryItemCommandService;
import org.kinaxis.platform.u202215313.wms.interfaces.rest.resources.CreateInventoryItemResource;
import org.kinaxis.platform.u202215313.wms.interfaces.rest.resources.InventoryItemResource;
import org.kinaxis.platform.u202215313.wms.interfaces.rest.transform.CreateInventoryItemCommandFromResourceAssembler;
import org.kinaxis.platform.u202215313.wms.interfaces.rest.transform.InventoryItemResourceFromEntityAssembler;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping(value = "api/v1/inventory-items", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Inventory Items", description = "Endpoints for managing inventory items")
public class InventoryItemController {

    private final InventoryItemCommandService inventoryItemCommandService;

    public InventoryItemController(InventoryItemCommandService inventoryItemCommandService) {
        this.inventoryItemCommandService = inventoryItemCommandService;
    }

    @PostMapping
    @Operation(summary = "Create a new inventory item", description = "Create a new inventory item with the provided data")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Inventory item created"),
            @ApiResponse(responseCode = "400", description = "Invalid data provided")
    })
    public ResponseEntity<InventoryItemResource> createInventoryItem(@RequestBody CreateInventoryItemResource resource) {
        var command = CreateInventoryItemCommandFromResourceAssembler.toCommand(resource);
        var inventoryItem = inventoryItemCommandService.createInventoryItem(command);
        var assembler = new InventoryItemResourceFromEntityAssembler();
        var inventoryItemResource = assembler.toResource(inventoryItem);
        return new ResponseEntity<>(inventoryItemResource, HttpStatus.CREATED);
    }
}
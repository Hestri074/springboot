package com.app.inventory.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.inventory.model.Item;
import com.app.inventory.service.InventoryService;

import java.util.List;

@RestController
// url default
@RequestMapping("/api/internal")
public class InternalController {
    // service
    private final InventoryService service;

    // constructor
    public InternalController(InventoryService service) {
        this.service = service;
    }

    // get data inventory
    @GetMapping
    public List<Item> getInventory() {
        return service.getAllItems();
    }
}

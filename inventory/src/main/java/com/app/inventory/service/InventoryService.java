package com.app.inventory.service;

import org.springframework.stereotype.Service;

import com.app.inventory.model.Item;
import com.app.inventory.repository.InventoryRepository;

import java.util.List;

@Service
public class InventoryService {
    // Di
    private InventoryRepository repo;

    // constructor
    public InventoryService(InventoryRepository repo) {
        this.repo = repo;
    }

    // method getItem
    public List<Item> getAllItems() {
        return repo.ambilSemua();
    }

    // simpan
    public Item addItem(Item item) {
        return repo.simpan(item);
    }
}
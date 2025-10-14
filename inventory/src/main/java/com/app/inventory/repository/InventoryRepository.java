package com.app.inventory.repository;

import java.util.*;
import com.app.inventory.model.Item;
import org.springframework.stereotype.Repository;

@Repository
public class InventoryRepository {
    // data
    private final Map<Long, Item> items = new HashMap<>();
    // counter
    private Long counter = 1L;

    // method akses ke database
    public List<Item> ambilSemua() {
        return new ArrayList<>(items.values());
    }

    // simpan data
    public Item simpan(Item item) {
        item.setId(counter++);
        items.put(item.getId(), item);
        return item;
    }

    // getItemById
    public Optional<Item> getById(Long id) {
        return Optional.ofNullable(items.get(id));
    }
}

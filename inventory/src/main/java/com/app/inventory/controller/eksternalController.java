package com.app.inventory.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/bean")
public class eksternalController {
    // gunakan bean
    private final String pesan;

    public eksternalController(String pesan) {
        this.pesan = pesan;
    }

    @GetMapping
    public String getPesan() {
        return pesan;
    }
}

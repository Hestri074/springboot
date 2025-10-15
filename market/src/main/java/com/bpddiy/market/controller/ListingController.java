package com.bpddiy.market.controller;

import com.bpddiy.market.dto.ListingRequest;
import com.bpddiy.market.model.Listing;
import com.bpddiy.market.service.ListingService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@AllArgsConstructor
@RequestMapping("/api/listing")
public class ListingController {
    // service listing
    private final ListingService service;

    // post data
    @PostMapping
    public String tambahData(@RequestBody ListingRequest request) {
        return service.tambah(request);
    }

    // get data
    @GetMapping
    public ResponseEntity<?> tampilListing() {
        return ResponseEntity.ok(service.tampilListing());
    }

}

package com.bpddiy.market.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.bpddiy.market.dto.ListingRequest;
import com.bpddiy.market.dto.ListingResponse;
import com.bpddiy.market.model.Listing;
import com.bpddiy.market.repository.ListingRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ListingService {

    private final ListingRepository repo;

    // fungsi tambah data
    @Transactional
    public String tambah(ListingRequest request) {
        Listing baru = new Listing();
        baru.setJudul(request.judul());
        baru.setDeskripsi(request.deskripsi());
        baru.setHarga(request.harga());
        baru.setKategori(request.kategori());
        baru.setUsername(request.username());
        baru.setNohp(request.nohp());

        // simpan
        repo.save(baru);

        return "Berhasil input data";
    }

    // ambil data listing
    // @Transactional
    // public List<Listing> tampilListing() {
    // return repo.findAll();
    // }

    @Transactional
    public ListingResponse tampilListing() {
        Optional<Listing> listing = repo.findAll().stream().findFirst();
        return listing.map(val -> new ListingResponse(
                val.getJudul(),
                val.getDeskripsi(),
                val.getHarga())).orElse(null);
    }
}

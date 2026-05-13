package com.dws.recruitment_test.modules.bands.controller;

import com.dws.recruitment_test.modules.bands.dto.Album;
import com.dws.recruitment_test.modules.bands.dto.Band;
import com.dws.recruitment_test.modules.bands.service.BandsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/bands")
public class BandsController {

    private final BandsService bandsService;

    @RequestMapping
    public ResponseEntity<List<Band>> getBands() {
        return ResponseEntity.ok(bandsService.getBands());
    }

    @RequestMapping("/albums")
    public ResponseEntity<List<Album>> getAlbums() {
        return ResponseEntity.ok(bandsService.getAlbums());
    }

    @RequestMapping("/tracks")
    public ResponseEntity<List<Album>> getTracks() {
        return ResponseEntity.ok(bandsService.getTracks());
    }

}
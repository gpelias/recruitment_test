package com.dws.recruitment_test.modules.bands.service;

import com.dws.recruitment_test.modules.bands.integration.BandsIntegration;
import com.dws.recruitment_test.modules.bands.dto.Album;
import com.dws.recruitment_test.modules.bands.dto.Band;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BandsService {

    private final BandsIntegration bandsIntegration;

    public List<Band> getBands() {
        List<Band> bands = bandsIntegration.getBands();

        return bands;
    }

    public List<Album> getAlbums() {
        List<Album> albums = bandsIntegration.getAlbums();

        return albums;
    }

    public List<Album> getTracks() {
        List<Album> tracks = bandsIntegration.getTracks();

        return tracks;
    }

}
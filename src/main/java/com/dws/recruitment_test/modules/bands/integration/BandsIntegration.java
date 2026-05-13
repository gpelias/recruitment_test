package com.dws.recruitment_test.modules.bands.integration;

import com.dws.recruitment_test.modules.bands.dto.Album;
import com.dws.recruitment_test.modules.bands.dto.Band;
import com.dws.recruitment_test.modules.bands.dto.Track;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "Bands", contextId = "bands")
public interface BandsIntegration {

    @GetMapping("/albums")
    List<Album> getAlbums();

    @GetMapping("/bands")
    List<Band> getBands();

    @GetMapping("/tracks")
    List<Track> getTracks();

}

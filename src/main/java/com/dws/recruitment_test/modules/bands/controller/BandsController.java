package com.dws.recruitment_test.modules.bands.controller;

import com.dws.recruitment_test.modules.bands.dto.Album;
import com.dws.recruitment_test.modules.bands.dto.Band;
import com.dws.recruitment_test.modules.bands.dto.Track;
import com.dws.recruitment_test.modules.bands.service.AlbumService;
import com.dws.recruitment_test.modules.bands.service.BandsService;
import com.dws.recruitment_test.modules.bands.service.TrackService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import static io.swagger.v3.oas.annotations.enums.ParameterIn.QUERY;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class BandsController {

    private final AlbumService albumService;

    private final BandsService bandsService;

    private final TrackService trackService;

    // Album
    @Operation(summary = "Search for bands using dynamic filters and sorting.")
    @Parameters(value = {
            @Parameter(name = "name", description = "Filter by band name (partial)", in = QUERY),
            @Parameter(name = "genre", description = "Filter by musical genre", in = QUERY),
            @Parameter(
                    name = "sort", description = "Field for sorting",
                    in = QUERY,
                    schema = @Schema(allowableValues = {"name", "numPlays", "genre"})
            ),
            @Parameter(
                    name = "order", description = "Direction of the ordering",
                    in = QUERY,
                    schema = @Schema(allowableValues = {"asc", "desc"}))
    })
    @GetMapping("/albums")
    public ResponseEntity<List<Album>> getAlbums(@RequestParam Map<String, String> params) {
        return ResponseEntity.ok(albumService.getAlbums(params));
    }

    @Operation(summary = "Get album details by ID.")
    @GetMapping("/albums/{id}")
    public ResponseEntity<Album> getAlbumById(@PathVariable UUID id) {
        return ResponseEntity.ok(albumService.getAlbumById(id));
    }

    // Band
    @Operation(summary = "Search for bands using dynamic filters and sorting.")
    @Parameters(value = {
            @Parameter(name = "name", description = "Filter by band name (partial)", in = QUERY),
            @Parameter(name = "genre", description = "Filter by musical genre", in = QUERY),
            @Parameter(
                    name = "sort", description = "Field for sorting",
                    in = QUERY,
                    schema = @Schema(allowableValues = {"name", "numPlays", "genre"})
            ),
            @Parameter(
                    name = "order", description = "Direction of the ordering",
                    in = QUERY,
                    schema = @Schema(allowableValues = {"asc", "desc"}))
    })
    @GetMapping("/bands")
    public ResponseEntity<List<Band>> getBands(@RequestParam Map<String, String> params) {
        return ResponseEntity.ok(bandsService.getBands(params));
    }

    @Operation(summary = "Get band details by ID.")
    @GetMapping("/bands/{id}")
    public ResponseEntity<Band> getBandById(@PathVariable UUID id) {
        return ResponseEntity.ok(bandsService.getBandById(id));
    }

    // Track
    @Operation(summary = "Search for tracks using dynamic filters and sorting.")
    @Parameters(value = {
            @Parameter(name = "name", description = "Filter by track name (partial)", in = QUERY),
            @Parameter(name = "duration", description = "Filter by track duration", in = QUERY),
            @Parameter(
                    name = "sort", description = "Field for sorting",
                    in = QUERY,
                    schema = @Schema(allowableValues = {"name", "duration"})
            ),
            @Parameter(
                    name = "order", description = "Direction of the ordering",
                    in = QUERY,
                    schema = @Schema(allowableValues = {"asc", "desc"}))
    })
    @GetMapping("/tracks")
    public ResponseEntity<List<Track>> getTracks(@RequestParam Map<String, String> params) {
        return ResponseEntity.ok(trackService.getTracks(params));
    }

    @GetMapping("/tracks/{id}")
    public ResponseEntity<Track> getTrackById(@PathVariable UUID id) {
        return ResponseEntity.ok(trackService.getTrackById(id));
    }

}
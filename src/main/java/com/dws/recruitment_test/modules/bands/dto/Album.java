package com.dws.recruitment_test.modules.bands.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public record Album(
        @Schema(description = "Unique identifier", example = "3fa85f64-5717-4562-b3fc-2c963f66afa6")
        UUID id,

        @Schema(description = "Album title", example = "OK Computer")
        String name,

        @Schema(description = "Release date of the album", example = "1997-05-21")
        LocalDate releaseDate,

        @Schema(description = "URL of the album cover image", example = "https://example.com/cover.jpg")
        String image,

        @Schema(description = "Basic information of the owner band")
        Band band,

        @Schema(description = "List of tracks included in the album")
        List<Track> tracks
) {
}

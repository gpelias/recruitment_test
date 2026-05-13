package com.dws.recruitment_test.modules.bands.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.UUID;

public record Track(
        @Schema(description = "Unique identifier", example = "3fa85f64-5717-4562-b3fc-2c963f66afa6")
        UUID id,

        @Schema(description = "Track title", example = "Paranoid Android")
        String name,

        @Schema(description = "Duration of the track", example = "223")
        String duration,

        @Schema(description = "ID of the album this track belongs to", example = "3fa85f64-5717-4562-b3fc-2c963f66afa6")
        UUID album
) {
}

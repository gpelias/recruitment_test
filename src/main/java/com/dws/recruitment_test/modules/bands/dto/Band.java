package com.dws.recruitment_test.modules.bands.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;
import java.util.UUID;

public record Band(
        @Schema(description = "Unique identifier", example = "3fa85f64-5717-4562-b3fc-2c963f66afa6")
        UUID id,

        @Schema(description = "Name of the band", example = "Radiohead")
        String name,

        @Schema(description = "URL of the band's image", example = "https://example.com/image.jpg")
        String image,

        @Schema(description = "Musical genre", example = "Alternative Rock")
        String genre,

        @Schema(description = "Biography")
        String biography,

        @Schema(description = "Total number of plays", example = "284212")
        Long numPlays,

        @Schema(description = "List of album IDs associated with the band")
        List<String> albums
) {
}

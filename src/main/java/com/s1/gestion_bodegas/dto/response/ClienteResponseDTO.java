package com.s1.gestion_bodegas.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;

public record ClienteResponseDTO(
        @Schema(description = "se obtiene el ID del cliente")
        Long id
) {
}

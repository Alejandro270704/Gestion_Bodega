package com.s1.gestion_bodegas.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;

import java.math.BigDecimal;

public record PersonaResponseDTO(
        @Schema(description = "se obtiene el ID de la persona")
        Long id,
        @Schema(description = "se obtiene el nombre de la persona")
        String nombre,
        @Schema(description = "se obtiene la identificacion de la persona")
        String identificacion
) {
}

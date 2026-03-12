package com.s1.gestion_bodegas.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;

import java.math.BigDecimal;

public record ProductoResponseDTO(
        @Schema(description = "se obtiene el ID del producto")
        Long id,
        @Schema(description = "se obtiene el nombre del producto")
        String nombre,
        @Schema(description = "se obtiene el stock del producto")
        Integer stock,
        @Schema(description = "se obtiene el categoria del producto")
        String categoria,
        @Schema(description = "se obtiene el precio del producto")
        BigDecimal precio

) {
}

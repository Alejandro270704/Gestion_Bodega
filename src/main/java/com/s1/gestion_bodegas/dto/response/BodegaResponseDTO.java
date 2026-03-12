package com.s1.gestion_bodegas.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;

import java.math.BigDecimal;

public record BodegaResponseDTO(
        @Schema(description = "se obtiene el ID de la bodega")
        Long id,
        @Schema(description = "se obtiene el nombre del bodega")
        String nombre,
        @Schema(description = "se obtiene la ubicacion de la bodega")
        String ubicacion,
        @Schema(description = "se obtiene la capacidad de la bodega")
        Integer capacidad,
        @Schema(description = "se obtiene el id_empleado de la bodega")
        EmpleadoResponseDTO id_empleado
) {
}

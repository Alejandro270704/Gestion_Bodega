package com.s1.gestion_bodegas.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;

public record MovimientoResponseDTO(
        @Schema(description = "se obtiene el ID de la movimiento")
        Long id,
        @Schema(description = "se obtiene el fecha del movimiento")
        String fecha,
        @Schema(description = "se obtiene el TipoMovimiento del movimiento")
        String TipoMovimiento,
        @Schema(description = "se obtiene el id_empleado del movimiento")
        EmpleadoResponseDTO id_empleado,
        @Schema(description = "se obtiene el id_bodega_origen del movimiento")
        BodegaResponseDTO id_bodega_origen,
        @Schema(description = "se obtiene el id_bodega_origen del movimiento")
        BodegaResponseDTO id_bodega_destino
) {
}

package com.s1.gestion_bodegas.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;

public record DetalleMovimientoResponseDTO(
        @Schema(description = "se obtiene el ID del detalle_movimiento")
        Long id,
        @Schema(description = "se obtiene el id_movimiento del detalle_movimiento")
        MovimientoResponseDTO id_movimiento,
        @Schema(description = "se obtiene el id_producto del detalle_movimiento")
        ProductoResponseDTO id_producto,
        @Schema(description = "se obtiene el cantidad del detalle_movimiento")
        Integer cantidad
) {
}

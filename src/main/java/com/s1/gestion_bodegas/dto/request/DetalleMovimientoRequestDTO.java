package com.s1.gestion_bodegas.dto.request;

import com.s1.gestion_bodegas.dto.response.MovimientoResponseDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.sql.Timestamp;

public record DetalleMovimientoRequestDTO(
        @Schema(description = "se ingresa la id_movimiento ")
        Long id_movimiento,
        @Schema(description = "se ingresa id_producto del movimiento")
        @NotNull(message = "El id_producto no puede estar vacio.")
        Long id_producto,
        @Schema(description = "se ingresa la cantidad ")
        @NotBlank(message = "La cantidad no puede estar vacio.")
        Integer cantidad

) {
}

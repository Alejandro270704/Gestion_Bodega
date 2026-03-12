package com.s1.gestion_bodegas.dto.request;

import com.s1.gestion_bodegas.model.Movimiento;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

import java.sql.Timestamp;

public record MovimientoRequestDTO(
        @Schema(description = "se ingresa la fecha del movimiento")
        Timestamp fecha,
        @Schema(description = "se ingresa TipoMovimiento de movimiento")
        @NotBlank(message = "El TipoMovimiento no puede estar vacio.")
        Movimiento.TipoMovimiento tipoMovimiento,
        @Schema(description = "se ingresa id_empleado ")
        @NotBlank(message = "El id_empleado no puede estar vacio.")
        Long id_empleado,
        @Schema(description = "se ingresa id_bodega_origen ")
        @NotBlank(message = "El id_bodega_origen no puede estar vacio.")
        Long id_bodega_origen,
        @Schema(description = "se ingresa id_bodega_destino")
        @NotBlank(message = "El id_bodega_destino no puede estar vacio.")
        Long id_bodega_destino
) {
}

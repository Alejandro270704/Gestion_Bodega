package com.s1.gestion_bodegas.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.sql.Timestamp;

public record AuditoriaRequestDTO(
        @Schema(description = "se ingresa la fecha de la auditoria")
        Timestamp fecha,
        @Schema(description = "se ingresa id_empleado ")
        @NotNull(message = "El id_empleado no puede estar vacio.")
        Long id_empleado,
        @Schema(description = "se ingresa la tabla_afectada ")
        @NotBlank(message = "La tabla_afectada no puede estar vacio.")
        String tabla_afectada,
        @Schema(description = "se ingresa la tabla_antigua ")
        @NotBlank(message = "La tabla_antigua no puede estar vacio.")
        String tabla_antigua,
        @Schema(description = "se ingresa la tabla_nueva ")
        @NotBlank(message = "La tabla_nueva no puede estar vacio.")
        String tabla_nueva

) {
}

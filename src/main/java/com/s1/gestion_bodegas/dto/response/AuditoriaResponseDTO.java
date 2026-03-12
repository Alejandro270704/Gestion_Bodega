package com.s1.gestion_bodegas.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;

public record AuditoriaResponseDTO(
        @Schema(description = "se obtiene el ID de la auditoria")
        Long id,
        @Schema(description = "se obtiene la fecha de la auditoria")
        String fecha,
        @Schema(description = "se obtiene el id_empleado de la auditoria")
        EmpleadoResponseDTO id_empleado,
        @Schema(description = "se obtiene la tabla_afectada de la auditoria")
        String tabla_afectada,
        @Schema(description = "se obtiene la tabla_antigua de la auditoria")
        String tabla_antigua,
        @Schema(description = "se obtiene la tabla_nueva de la auditoria")
        String tabla_nueva
) {
}

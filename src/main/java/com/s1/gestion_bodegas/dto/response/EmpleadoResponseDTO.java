package com.s1.gestion_bodegas.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;

public record EmpleadoResponseDTO(
        @Schema(description = "se obtiene la persona")
        PersonaResponseDTO id,
        @Schema(description = "se obtiene el ID del empleado")
        String rol
) {
}

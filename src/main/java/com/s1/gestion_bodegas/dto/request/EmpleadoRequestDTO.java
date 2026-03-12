package com.s1.gestion_bodegas.dto.request;

import com.s1.gestion_bodegas.model.Empleado;
import jakarta.validation.constraints.NotNull;

public record EmpleadoRequestDTO(
        @NotNull(message = "El id de la persona es obligatorio")
        Long id,
        @NotNull(message = "El id de la persona es obligatorio")
        Empleado.Rol rol
) {
}

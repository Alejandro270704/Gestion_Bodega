package com.s1.gestion_bodegas.dto.request;

import jakarta.validation.constraints.NotNull;

public record ClienteResquestDTO(
        @NotNull(message = "El id de la persona es obligatorio")
        Long id
) {
}

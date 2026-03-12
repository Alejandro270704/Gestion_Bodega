package com.s1.gestion_bodegas.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

public record PersonaRequestDTO(
        @Schema(description = "se ingresa el nombre de la persona")
        @Size(min = 2, max = 250, message = "Error, el rango del nombre debe estar entre 2 y 250 caracteres")
        @NotBlank(message = "El nombre no puede estar vacio.")
        String nombre,
        @Schema(description = "se ingresa el identificacion de la persona")
        @NotBlank(message = "La identificacion no puede estar vacio.")
        String identificacion
) {
}

package com.s1.gestion_bodegas.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

public record ProductoRequestDTO(

        @Schema(description = "se ingresa el nombre del producto")
        @Size(min = 2, max = 250, message = "Error, el rango del nombre debe estar entre 2 y 250 caracteres")
        @NotBlank(message = "El nombre no puede estar vacio.")
        String nombre,
        @Schema(description = "se ingresa el stock del producto")
        @NotBlank(message = "El stock no puede estar vacio.")
        @Positive(message = "Error, el stock debe ser positivo")
        Integer stock,
        @Schema(description = "se ingresa la categoria del producto")
        @NotBlank(message = "La categoria no puede estar vacio.")
        String categoria,
        @Schema(description = "se ingresa el precio del producto")
        @NotBlank(message = "El precio no puede estar vacio.")
        @Positive(message = "Error, el precio debe ser positivo")
        BigDecimal precio

) {
}

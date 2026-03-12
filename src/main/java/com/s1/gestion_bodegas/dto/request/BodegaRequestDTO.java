package com.s1.gestion_bodegas.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;


public record BodegaRequestDTO(
        @Schema(description = "se ingresa el nombre del bodega")
        @Size(min = 2, max = 250, message = "Error, el rango del nombre debe estar entre 2 y 250 caracteres")
        @NotBlank(message = "El nombre no puede estar vacio.")
        String nombre,
        @Schema(description = "se ingresa la categoria del bodega")
        @NotBlank(message = "La ubicacion no puede estar vacio.")
        String ubicacion,
        @Schema(description = "se ingresa el capacidad de la bodega")
        @NotNull(message = "El capacidad no puede estar vacio.")
        @Positive(message = "Error, el capacidad debe ser positivo")
        Integer capacidad,
        @Schema(description = "se ingresa id_empleado de la bodega")
        @NotNull(message = "El id_empleado no puede estar vacio.")
        Long id_empleado
) {
}

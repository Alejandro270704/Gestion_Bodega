package com.s1.gestion_bodegas.service;

import com.s1.gestion_bodegas.dto.request.EmpleadoRequestDTO;
import com.s1.gestion_bodegas.dto.response.EmpleadoResponseDTO;

import java.util.List;

public interface EmpleadoService {
    EmpleadoResponseDTO guardarProducto(EmpleadoRequestDTO dto);

    EmpleadoResponseDTO actualizarProducto(EmpleadoRequestDTO dto, Long id);
    void eliminarProducto(Long id);
    List<EmpleadoResponseDTO> buscarTodos();
}

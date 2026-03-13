package com.s1.gestion_bodegas.service;

import com.s1.gestion_bodegas.dto.request.EmpleadoRequestDTO;
import com.s1.gestion_bodegas.dto.response.EmpleadoResponseDTO;

import java.util.List;

public interface EmpleadoService {
    EmpleadoResponseDTO guardarEmpleado(EmpleadoRequestDTO dto);

    EmpleadoResponseDTO actualizarEmpleado(EmpleadoRequestDTO dto, Long id);
    void eliminarEmpleado(Long id);
    List<EmpleadoResponseDTO> buscarTodos();
}

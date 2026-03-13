package com.s1.gestion_bodegas.service;

import com.s1.gestion_bodegas.dto.request.MovimientoRequestDTO;
import com.s1.gestion_bodegas.dto.response.MovimientoResponseDTO;

import java.util.List;

public interface MovimientoService {
    MovimientoResponseDTO guardarProducto(MovimientoRequestDTO dto);

    MovimientoResponseDTO actualizarProducto(MovimientoRequestDTO dto, Long id);
    void eliminarProducto(Long id);
    List<MovimientoResponseDTO> buscarTodos();
    List<MovimientoResponseDTO> buscarentrefecha (String fechaInicio, String fechaFin);
}

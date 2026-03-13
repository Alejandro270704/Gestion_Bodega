package com.s1.gestion_bodegas.service;

import com.s1.gestion_bodegas.dto.request.MovimientoRequestDTO;
import com.s1.gestion_bodegas.dto.response.MovimientoResponseDTO;

import java.util.List;

public interface MovimientoService {
    MovimientoResponseDTO guardarMovimiento(MovimientoRequestDTO dto);

    MovimientoResponseDTO actualizarMovimiento(MovimientoRequestDTO dto, Long id);
    void eliminarMovimiento(Long id);
    List<MovimientoResponseDTO> buscarTodos();
    List<MovimientoResponseDTO> buscarentrefecha (String fechaInicio, String fechaFin);
}

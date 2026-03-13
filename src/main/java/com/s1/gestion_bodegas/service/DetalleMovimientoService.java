package com.s1.gestion_bodegas.service;

import com.s1.gestion_bodegas.dto.request.DetalleMovimientoRequestDTO;
import com.s1.gestion_bodegas.dto.response.DetalleMovimientoResponseDTO;

import java.util.List;

public interface DetalleMovimientoService {
    DetalleMovimientoResponseDTO guardarDetalleMovimiento(DetalleMovimientoRequestDTO dto);

    DetalleMovimientoResponseDTO actualizarDetalleMovimiento(DetalleMovimientoRequestDTO dto, Long id);
    void eliminarDetalleMovimiento(Long id);
    List<DetalleMovimientoResponseDTO> buscarTodos();
    List<DetalleMovimientoResponseDTO> buscarcantidadmenor (Integer cantidad);
}

package com.s1.gestion_bodegas.service;

import com.s1.gestion_bodegas.dto.request.AuditoriaRequestDTO;
import com.s1.gestion_bodegas.dto.request.BodegaRequestDTO;
import com.s1.gestion_bodegas.dto.response.AuditoriaResponseDTO;
import com.s1.gestion_bodegas.dto.response.BodegaResponseDTO;

import java.util.List;

public interface BodegaService {
    BodegaResponseDTO guardarProducto(BodegaRequestDTO dto);

    BodegaResponseDTO actualizarProducto(BodegaRequestDTO dto, Long id);
    void eliminarProducto(Long id);
    List<BodegaResponseDTO> buscarTodos();
    List<BodegaResponseDTO> buscarcapacidadBajo (Integer capacidad);
}

package com.s1.gestion_bodegas.service;

import com.s1.gestion_bodegas.dto.request.BodegaRequestDTO;
import com.s1.gestion_bodegas.dto.response.BodegaResponseDTO;

import java.util.List;

public interface BodegaService {
    BodegaResponseDTO guardarBodega(BodegaRequestDTO dto);

    BodegaResponseDTO actualizarBodega(BodegaRequestDTO dto, Long id);
    void eliminarBodega(Long id);
    List<BodegaResponseDTO> buscarTodos();
    List<BodegaResponseDTO> buscarcapacidadBajo (Integer capacidad);
}

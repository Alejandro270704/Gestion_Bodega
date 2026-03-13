package com.s1.gestion_bodegas.service;

import com.s1.gestion_bodegas.dto.request.AuditoriaRequestDTO;
import com.s1.gestion_bodegas.dto.response.AuditoriaResponseDTO;

import java.util.List;

public interface AuditoriaService {
    AuditoriaResponseDTO guardarAuditoria(AuditoriaRequestDTO dto);

    AuditoriaResponseDTO actualizarAuditoria(AuditoriaRequestDTO dto, Long id);
    void eliminarAuditoria(Long id);
    List<AuditoriaResponseDTO> buscarTodos();
    List<AuditoriaResponseDTO> buscarentrefecha (String fechaInicio, String fechaFin);
}

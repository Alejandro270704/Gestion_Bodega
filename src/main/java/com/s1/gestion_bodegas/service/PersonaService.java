package com.s1.gestion_bodegas.service;

import com.s1.gestion_bodegas.dto.request.PersonaRequestDTO;
import com.s1.gestion_bodegas.dto.response.PersonaResponseDTO;

import java.util.List;

public interface PersonaService {
    PersonaResponseDTO guardarProducto(PersonaRequestDTO dto);

    PersonaResponseDTO actualizarProducto(PersonaRequestDTO dto, Long id);
    void eliminarProducto(Long id);
    List<PersonaResponseDTO> buscarTodos();
    List<PersonaResponseDTO> buscarProductosnombre (String nombre);
}

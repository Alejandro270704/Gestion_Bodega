package com.s1.gestion_bodegas.service;

import com.s1.gestion_bodegas.dto.request.PersonaRequestDTO;
import com.s1.gestion_bodegas.dto.response.PersonaResponseDTO;

import java.util.List;

public interface PersonaService {
    PersonaResponseDTO guardarPersona(PersonaRequestDTO dto);

    PersonaResponseDTO actualizarPersona(PersonaRequestDTO dto, Long id);
    void eliminarPersona(Long id);
    List<PersonaResponseDTO> buscarTodos();
    List<PersonaResponseDTO> buscarPersonanombre (String nombre);
}

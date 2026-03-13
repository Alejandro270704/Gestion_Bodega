package com.s1.gestion_bodegas.service.impl;

import com.s1.gestion_bodegas.dto.request.PersonaRequestDTO;
import com.s1.gestion_bodegas.dto.response.PersonaResponseDTO;
import com.s1.gestion_bodegas.mapper.PersonaMapper;
import com.s1.gestion_bodegas.model.Persona;
import com.s1.gestion_bodegas.repository.PersonaRepository;
import com.s1.gestion_bodegas.service.PersonaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonaServiceImpl implements PersonaService {
    private final PersonaMapper PersonaMapper;
    private final PersonaRepository PersonaRepository;
    @Override
    public PersonaResponseDTO guardarProducto(PersonaRequestDTO dto) {
        Persona p=PersonaMapper.DTOAEntidad(dto);
        Persona p_insertada=PersonaRepository.save(p);
        return PersonaMapper.entidadADTO(p_insertada);
    }

    @Override
    public PersonaResponseDTO actualizarProducto(PersonaRequestDTO dto, Long id) {
        Persona p=PersonaRepository.findById(id).orElseThrow(()->new RuntimeException("No existe dicha persona"));
        PersonaMapper.actualizarEntidadDesdeDTO(p,dto);
        Persona p_actualizada=PersonaRepository.save(p);
        return PersonaMapper.entidadADTO(p_actualizada);
    }

    @Override
    public void eliminarProducto(Long id) {
        Persona p=PersonaRepository.findById(id).orElseThrow(()->new RuntimeException("No existe dicha persona"));
        PersonaRepository.delete(p);
    }

    @Override
    public List<PersonaResponseDTO> buscarTodos() {
        List<Persona> productos= PersonaRepository.findAll();
        return productos.stream().map(PersonaMapper::entidadADTO).toList();
    }

    @Override
    public List<PersonaResponseDTO> buscarProductosnombre(String nombre) {
        List<Persona> personas= PersonaRepository.findByNombreContaining(nombre);
        return personas.stream().map(PersonaMapper::entidadADTO).toList();
    }
}

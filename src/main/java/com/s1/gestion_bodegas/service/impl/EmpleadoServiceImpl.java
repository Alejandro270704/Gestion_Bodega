package com.s1.gestion_bodegas.service.impl;

import com.s1.gestion_bodegas.dto.request.EmpleadoRequestDTO;
import com.s1.gestion_bodegas.dto.response.EmpleadoResponseDTO;
import com.s1.gestion_bodegas.dto.response.PersonaResponseDTO;
import com.s1.gestion_bodegas.mapper.EmpleadoMapper;
import com.s1.gestion_bodegas.mapper.PersonaMapper;
import com.s1.gestion_bodegas.model.Empleado;
import com.s1.gestion_bodegas.model.Persona;
import com.s1.gestion_bodegas.repository.EmpleadoRepository;
import com.s1.gestion_bodegas.repository.PersonaRepository;
import com.s1.gestion_bodegas.service.EmpleadoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class EmpleadoServiceImpl implements EmpleadoService {
    private final EmpleadoMapper EmpleadoMapper;
    private final EmpleadoRepository EmpleadoRepository;
    private final PersonaMapper PersonaMapper;
    private final PersonaRepository PersonaRepository;

    @Override
    public EmpleadoResponseDTO guardarEmpleado(EmpleadoRequestDTO dto) {
        Persona p= PersonaRepository.findById(dto.id()).orElseThrow(()->new RuntimeException("No existe dicha persona"));
        Empleado e= EmpleadoMapper.DTOAEntidad(dto);
        Empleado e_insertada= EmpleadoRepository.save(e);
        PersonaResponseDTO dtoPersona = PersonaMapper.entidadADTO(p);
        return EmpleadoMapper.entidadADTO(dtoPersona,e_insertada);
    }

    @Override
    public EmpleadoResponseDTO actualizarEmpleado(EmpleadoRequestDTO dto, Long id) {
        Empleado e= EmpleadoRepository.findById(id).orElseThrow(()->new RuntimeException("Error, no existe dicha empleado a actualizar"));
        Persona p= PersonaRepository.findById(dto.id()).orElseThrow(()->new RuntimeException("Error, no existe dicha persona a actualizar"));
        EmpleadoMapper.actualizarEntidadDesdeDTO(e,dto);
        Empleado e_insertada=EmpleadoRepository.save(e);
        PersonaResponseDTO dtoPersona= PersonaMapper.entidadADTO(p);
        return EmpleadoMapper.entidadADTO(dtoPersona,e_insertada);
    }

    @Override
    public void eliminarEmpleado(Long id) {
        Empleado e=EmpleadoRepository.findById(id).orElseThrow(()->new RuntimeException("No existe dicho empleado"));
        EmpleadoRepository.delete(e);
    }

    @Override
    public List<EmpleadoResponseDTO> buscarTodos() {
        return EmpleadoRepository.findAll().stream().map(EM ->EmpleadoMapper.entidadADTO(PersonaMapper.entidadADTO(EM.getPersona()),EM)).toList();
    }
}

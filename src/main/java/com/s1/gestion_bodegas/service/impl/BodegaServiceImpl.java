package com.s1.gestion_bodegas.service.impl;

import com.s1.gestion_bodegas.dto.request.BodegaRequestDTO;
import com.s1.gestion_bodegas.dto.response.BodegaResponseDTO;
import com.s1.gestion_bodegas.dto.response.EmpleadoResponseDTO;
import com.s1.gestion_bodegas.dto.response.PersonaResponseDTO;
import com.s1.gestion_bodegas.mapper.BodegaMapper;
import com.s1.gestion_bodegas.mapper.EmpleadoMapper;
import com.s1.gestion_bodegas.mapper.PersonaMapper;
import com.s1.gestion_bodegas.model.Auditoria;
import com.s1.gestion_bodegas.model.Bodega;
import com.s1.gestion_bodegas.model.Empleado;
import com.s1.gestion_bodegas.model.Persona;
import com.s1.gestion_bodegas.repository.BodegaRepository;
import com.s1.gestion_bodegas.repository.EmpleadoRepository;
import com.s1.gestion_bodegas.repository.PersonaRepository;
import com.s1.gestion_bodegas.service.BodegaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class BodegaServiceImpl implements BodegaService {
    private final BodegaMapper BodegaMapper;
    private final BodegaRepository BodegaRepository;
    private final EmpleadoRepository EmpleadoRepository;
    private final EmpleadoMapper EmpleadoMapper;
    private final  PersonaRepository PersonaRepository;
    private final PersonaMapper PersonaMapper;
    @Override
    public BodegaResponseDTO guardarBodega(BodegaRequestDTO dto) {

        Empleado e= EmpleadoRepository.findById(dto.id_empleado()).orElseThrow(()->new RuntimeException("No existe dicho empleado"));
        Bodega b= BodegaMapper.DTOAEntidad(dto,e);
        Persona p=PersonaRepository.findById(dto.id_empleado()).orElseThrow(()->new RuntimeException("No existe dicho empleado"));
        Bodega b_insertada= BodegaRepository.save(b);
        PersonaResponseDTO dtoPersona = PersonaMapper.entidadADTO(p);
        EmpleadoResponseDTO dtoEmpleado=EmpleadoMapper.entidadADTO(dtoPersona,e);
        return BodegaMapper.entidadADTO(b_insertada,dtoEmpleado);
    }

    @Override
    public BodegaResponseDTO actualizarBodega(BodegaRequestDTO dto, Long id) {
        Bodega b = BodegaRepository.findById(id).orElseThrow(() -> new RuntimeException("No existe la bodega"));
        Empleado e = EmpleadoRepository.findById(dto.id_empleado()).orElseThrow(() -> new RuntimeException("No existe el empleado"));
        Persona p=PersonaRepository.findById(dto.id_empleado()).orElseThrow(()->new RuntimeException("No existe dicho empleado"));
        BodegaMapper.actualizarEntidadDesdeDTO(b,dto,e);
        Bodega b_actualizada = BodegaRepository.save(b);
        PersonaResponseDTO dtoPersona = PersonaMapper.entidadADTO(p);
        EmpleadoResponseDTO dtoEmpleado = EmpleadoMapper.entidadADTO(dtoPersona, e);
        return BodegaMapper.entidadADTO(b_actualizada, dtoEmpleado);
    }

    @Override
    public void eliminarBodega(Long id) {
        Bodega b = BodegaRepository.findById(id).orElseThrow(() -> new RuntimeException("No existe la bodega"));
        BodegaRepository.delete(b);
    }

    @Override
    public List<BodegaResponseDTO> buscarTodos() {
        return BodegaRepository.findAll() .stream() .map(b -> { PersonaResponseDTO personaDTO = PersonaMapper.entidadADTO(b.getEmpleado().getPersona()); EmpleadoResponseDTO empleadoDTO = EmpleadoMapper.entidadADTO(personaDTO, b.getEmpleado()); return BodegaMapper.entidadADTO(b, empleadoDTO); }) .toList();
    }

    @Override
    public List<BodegaResponseDTO> buscarcapacidadBajo(Integer capacidad) {
        return BodegaRepository.findByCapacidadLessThan(capacidad) .stream() .map(b -> BodegaMapper.entidadADTO( b, EmpleadoMapper.entidadADTO( PersonaMapper.entidadADTO(b.getEmpleado().getPersona()), b.getEmpleado() ) )) .toList();
    }
}

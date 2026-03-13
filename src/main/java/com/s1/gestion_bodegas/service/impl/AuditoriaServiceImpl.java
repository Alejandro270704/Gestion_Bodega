package com.s1.gestion_bodegas.service.impl;

import com.s1.gestion_bodegas.dto.request.AuditoriaRequestDTO;
import com.s1.gestion_bodegas.dto.response.AuditoriaResponseDTO;
import com.s1.gestion_bodegas.dto.response.EmpleadoResponseDTO;
import com.s1.gestion_bodegas.dto.response.PersonaResponseDTO;
import com.s1.gestion_bodegas.mapper.AuditoriaMapper;
import com.s1.gestion_bodegas.mapper.EmpleadoMapper;
import com.s1.gestion_bodegas.mapper.PersonaMapper;
import com.s1.gestion_bodegas.model.Auditoria;
import com.s1.gestion_bodegas.model.Empleado;
import com.s1.gestion_bodegas.model.Persona;
import com.s1.gestion_bodegas.repository.AuditoriaRepository;
import com.s1.gestion_bodegas.repository.EmpleadoRepository;
import com.s1.gestion_bodegas.repository.PersonaRepository;
import com.s1.gestion_bodegas.service.AuditoriaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AuditoriaServiceImpl implements AuditoriaService {
    private final AuditoriaMapper AuditoriaMapper;
    private final AuditoriaRepository AuditoriaRepository;
    private final EmpleadoRepository EmpleadoRepository;
    private final EmpleadoMapper EmpleadoMapper;
    private final PersonaRepository PersonaRepository;
    private final PersonaMapper PersonaMapper;
    @Override
    public AuditoriaResponseDTO guardarAuditoria(AuditoriaRequestDTO dto) {
        Empleado e= EmpleadoRepository.findById(dto.id_empleado()).orElseThrow(()->new RuntimeException("No existe dicho empleado"));
        Persona p=PersonaRepository.findById(dto.id_empleado()).orElseThrow(()->new RuntimeException("No existe dicho empleado"));
        Auditoria A= AuditoriaMapper.DTOAEntidad(dto,e);
        Auditoria A_insertada= AuditoriaRepository.save(A);
        PersonaResponseDTO dtoPersona=PersonaMapper.entidadADTO(p);
        EmpleadoResponseDTO dtoEmpleado=EmpleadoMapper.entidadADTO(dtoPersona,e);
        return AuditoriaMapper.entidadADTO(A_insertada,dtoEmpleado);
    }

    @Override
    public AuditoriaResponseDTO actualizarAuditoria(AuditoriaRequestDTO dto, Long id) {
        Auditoria A= AuditoriaRepository.findById(id).orElseThrow(()->new RuntimeException("Error, no existe dicha auditoria a actualizar"));
        Persona p=PersonaRepository.findById(dto.id_empleado()).orElseThrow(()->new RuntimeException("No existe dicho empleado"));
        Empleado e = EmpleadoRepository.findById(dto.id_empleado()).orElseThrow(()->new RuntimeException("Error, no existe dicha persona a actualizar"));
        AuditoriaMapper.actualizarEntidadDesdeDTO(A,dto,e);
        Auditoria dv_insertada=AuditoriaRepository.save(A);
        PersonaResponseDTO dtoPersona = PersonaMapper.entidadADTO(p);
        EmpleadoResponseDTO dtoEmpleado = EmpleadoMapper.entidadADTO(dtoPersona, e);

        return AuditoriaMapper.entidadADTO(dv_insertada,dtoEmpleado);
    }

    @Override
    public void eliminarAuditoria(Long id) {
        Auditoria dv= AuditoriaRepository.findById(id).orElseThrow(()->new RuntimeException("Error, no existe dicha persona a actualizar"));
        AuditoriaRepository.delete(dv);
    }

    @Override
    public List<AuditoriaResponseDTO> buscarTodos() {
        return AuditoriaRepository.findAll().stream() .map(a -> AuditoriaMapper.entidadADTO( a, EmpleadoMapper.entidadADTO( PersonaMapper.entidadADTO(a.getEmpleado().getPersona()), a.getEmpleado()))).toList();
    }

    @Override
    public List<AuditoriaResponseDTO> buscarentrefecha(String fechaInicio, String fechaFin) {

        return AuditoriaRepository
                .findByFechaBetween(
                        Timestamp.valueOf(LocalDateTime.parse(fechaInicio)),
                        Timestamp.valueOf(LocalDateTime.parse(fechaFin))
                )
                .stream()
                .map(a -> AuditoriaMapper.entidadADTO(
                        a,
                        EmpleadoMapper.entidadADTO(
                                PersonaMapper.entidadADTO(a.getEmpleado().getPersona()),
                                a.getEmpleado()
                        )
                ))
                .toList();
    }
}

package com.s1.gestion_bodegas.service.impl;

import com.s1.gestion_bodegas.dto.request.MovimientoRequestDTO;
import com.s1.gestion_bodegas.dto.response.BodegaResponseDTO;
import com.s1.gestion_bodegas.dto.response.EmpleadoResponseDTO;
import com.s1.gestion_bodegas.dto.response.MovimientoResponseDTO;
import com.s1.gestion_bodegas.dto.response.PersonaResponseDTO;
import com.s1.gestion_bodegas.mapper.BodegaMapper;
import com.s1.gestion_bodegas.mapper.EmpleadoMapper;
import com.s1.gestion_bodegas.mapper.MovimientoMapper;
import com.s1.gestion_bodegas.mapper.PersonaMapper;
import com.s1.gestion_bodegas.model.Bodega;
import com.s1.gestion_bodegas.model.Empleado;
import com.s1.gestion_bodegas.model.Movimiento;
import com.s1.gestion_bodegas.model.Persona;
import com.s1.gestion_bodegas.repository.BodegaRepository;
import com.s1.gestion_bodegas.repository.EmpleadoRepository;
import com.s1.gestion_bodegas.repository.MovimientoRepository;
import com.s1.gestion_bodegas.repository.PersonaRepository;
import com.s1.gestion_bodegas.service.MovimientoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
@Service
@RequiredArgsConstructor
public class MovimientoServiceImpl implements MovimientoService {
    private final MovimientoRepository movimientoRepository;
    private final MovimientoMapper movimientoMapper;
    private final EmpleadoRepository empleadoRepository;
    private final BodegaRepository bodegaRepository;
    private final PersonaMapper personaMapper;
    private final PersonaRepository PersonaRepository;
    private final EmpleadoMapper empleadoMapper;
    private final BodegaMapper bodegaMapper;
    @Override
    public MovimientoResponseDTO guardarMovimiento(MovimientoRequestDTO dto) {
        Empleado e = empleadoRepository.findById(dto.id_empleado()).orElseThrow(() -> new RuntimeException("No existe el empleado"));
        Bodega b = bodegaRepository.findById(dto.id_bodega_origen()).orElseThrow(() -> new RuntimeException("No existe la bodega"));
        Persona p = PersonaRepository.findById(dto.id_empleado()).orElseThrow(() -> new RuntimeException("No existe el empleado"));
        Movimiento m = movimientoMapper.DTOAEntidad(dto, e, b);
        Movimiento m_insertada = movimientoRepository.save(m);
        PersonaResponseDTO dtoPersona = personaMapper.entidadADTO(p);
        EmpleadoResponseDTO dtoEmpleado = empleadoMapper.entidadADTO(dtoPersona, e);
        BodegaResponseDTO dtoBodega = bodegaMapper.entidadADTO(b, dtoEmpleado);
        return movimientoMapper.entidadADTO(m_insertada, dtoEmpleado, dtoBodega);
    }

    @Override
    public MovimientoResponseDTO actualizarMovimiento(MovimientoRequestDTO dto, Long id) {
        Movimiento m = movimientoRepository.findById(id).orElseThrow(() -> new RuntimeException("No existe el movimiento"));
        Empleado e = empleadoRepository.findById(dto.id_empleado()).orElseThrow(() -> new RuntimeException("No existe el empleado"));
        Bodega b = bodegaRepository.findById(dto.id_bodega_origen()).orElseThrow(() -> new RuntimeException("No existe la bodega"));
        Persona p = PersonaRepository.findById(dto.id_empleado()).orElseThrow(() -> new RuntimeException("No existe la persona"));
        movimientoMapper.actualizarEntidadDesdeDTO(m,dto,e,b);
        Movimiento m_actualizado = movimientoRepository.save(m);
        PersonaResponseDTO dtoPersona = personaMapper.entidadADTO(p);
        EmpleadoResponseDTO dtoEmpleado = empleadoMapper.entidadADTO(dtoPersona, e);
        BodegaResponseDTO dtoBodega = bodegaMapper.entidadADTO(b, dtoEmpleado);
        return movimientoMapper.entidadADTO(m_actualizado, dtoEmpleado, dtoBodega);
    }

    @Override
    public void eliminarMovimiento(Long id) {
        Movimiento m = movimientoRepository.findById(id).orElseThrow(() -> new RuntimeException("No existe el movimiento"));
        movimientoRepository.delete(m);
    }

    @Override
    public List<MovimientoResponseDTO> buscarTodos() {
        return movimientoRepository.findAll() .stream() .map(m -> movimientoMapper.entidadADTO( m, empleadoMapper.entidadADTO( personaMapper.entidadADTO(m.getEmpleado().getPersona()), m.getEmpleado() ), bodegaMapper.entidadADTO( m.getBodegaOrigen(), empleadoMapper.entidadADTO( personaMapper.entidadADTO(m.getBodegaOrigen().getEmpleado().getPersona()), m.getBodegaOrigen().getEmpleado())))) .toList();
    }

    @Override
    public List<MovimientoResponseDTO> buscarentrefecha(String fechaInicio, String fechaFin) {
        return movimientoRepository.findByFechaBetween(
                        LocalDateTime.parse(fechaInicio),
                        LocalDateTime.parse(fechaFin))
                .stream().map(m -> movimientoMapper.entidadADTO(m, empleadoMapper.entidadADTO(personaMapper.entidadADTO(m.getEmpleado().getPersona()), m.getEmpleado()), bodegaMapper.entidadADTO(m.getBodegaOrigen(), empleadoMapper.entidadADTO(personaMapper.entidadADTO(m.getBodegaOrigen().getEmpleado().getPersona()), m.getBodegaOrigen().getEmpleado())))).toList();
    }
}

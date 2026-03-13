package com.s1.gestion_bodegas.service.impl;

import com.s1.gestion_bodegas.dto.request.DetalleMovimientoRequestDTO;
import com.s1.gestion_bodegas.dto.response.*;
import com.s1.gestion_bodegas.mapper.*;
import com.s1.gestion_bodegas.model.Detalle_movimiento;
import com.s1.gestion_bodegas.model.Movimiento;
import com.s1.gestion_bodegas.model.Producto;
import com.s1.gestion_bodegas.repository.*;
import com.s1.gestion_bodegas.service.DetalleMovimientoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class DetalleMovimientoServiceImpl implements DetalleMovimientoService {
    private final ProductoRepository ProductoRepository;
    private final ProductoMapper ProductoMapper;
    private final MovimientoMapper MovimientoMapper;
    private final MovimientoRepository MovimientoRepository;
    private final DetalleMovimientoMapper DetalleMovimientoMapper;
    private final DetalleMovimientoRepository DetalleMovimientoRepository;
    private final EmpleadoRepository EmpleadoRepository;
    private final EmpleadoMapper EmpleadoMapper;
    private final BodegaMapper BodegaMapper;
    private final BodegaRepository BodegaRepository;
    private final PersonaMapper PersonaMapper;
    @Override
    public DetalleMovimientoResponseDTO guardarDetalleMovimiento(DetalleMovimientoRequestDTO dto) {
        Producto p= ProductoRepository.findById(dto.id_producto()).orElseThrow(()->new RuntimeException("No existe dicho producto"));
        Movimiento m= MovimientoRepository.findById(dto.id_movimiento()).orElseThrow(()->new RuntimeException("No existe dicho movimiento"));
        Detalle_movimiento dm= DetalleMovimientoMapper.DTOAEntidad(dto,m,p);
        DetalleMovimientoRepository.save(dm);
        PersonaResponseDTO dtoPersona = PersonaMapper.entidadADTO(m.getEmpleado().getPersona());
        ProductoResponseDTO dtoProducto=ProductoMapper.entidadADTO(p);
        EmpleadoResponseDTO dtoEmpleado = EmpleadoMapper.entidadADTO(dtoPersona,m.getEmpleado());
        BodegaResponseDTO dtoBodega = BodegaMapper.entidadADTO(m.getBodegaOrigen(),dtoEmpleado);
        MovimientoResponseDTO dtoMovimiento=MovimientoMapper.entidadADTO(m,dtoEmpleado,dtoBodega);
        return DetalleMovimientoMapper.entidadADTO(dm,dtoMovimiento,dtoProducto);
    }
    @Override
    public DetalleMovimientoResponseDTO actualizarDetalleMovimiento(DetalleMovimientoRequestDTO dto, Long id) {
        Detalle_movimiento dm = DetalleMovimientoRepository.findById(id).orElseThrow(() -> new RuntimeException("No existe dicho detalle movimiento"));
        Producto p = ProductoRepository.findById(dto.id_producto()).orElseThrow(() -> new RuntimeException("No existe dicho producto"));
        Movimiento m = MovimientoRepository.findById(dto.id_movimiento()).orElseThrow(() -> new RuntimeException("No existe dicho movimiento"));
        DetalleMovimientoMapper.actualizarEntidadDesdeDTO(dm, dto, m, p);
        Detalle_movimiento dm_actualizado = DetalleMovimientoRepository.save(dm);
        PersonaResponseDTO dtoPersona = PersonaMapper.entidadADTO(m.getEmpleado().getPersona());
        ProductoResponseDTO dtoProducto = ProductoMapper.entidadADTO(p);
        EmpleadoResponseDTO dtoEmpleado = EmpleadoMapper.entidadADTO(dtoPersona, m.getEmpleado());
        BodegaResponseDTO dtoBodega = BodegaMapper.entidadADTO(m.getBodegaOrigen(), dtoEmpleado);
        MovimientoResponseDTO dtoMovimiento = MovimientoMapper.entidadADTO(m, dtoEmpleado, dtoBodega);
        return DetalleMovimientoMapper.entidadADTO(dm_actualizado, dtoMovimiento, dtoProducto);
    }

    @Override
    public void eliminarDetalleMovimiento(Long id) {
        Detalle_movimiento dm = DetalleMovimientoRepository.findById(id).orElseThrow(() -> new RuntimeException("No existe dicho detalle movimiento"));
        DetalleMovimientoRepository.delete(dm);
    }

    @Override
    public List<DetalleMovimientoResponseDTO> buscarTodos() {
        return DetalleMovimientoRepository.findAll().stream().map(dm -> DetalleMovimientoMapper.entidadADTO( dm, MovimientoMapper.entidadADTO( dm.getMovimiento(), EmpleadoMapper.entidadADTO( PersonaMapper.entidadADTO(dm.getMovimiento().getEmpleado().getPersona()), dm.getMovimiento().getEmpleado() ), BodegaMapper.entidadADTO( dm.getMovimiento().getBodegaOrigen(), EmpleadoMapper.entidadADTO( PersonaMapper.entidadADTO(dm.getMovimiento().getEmpleado().getPersona()), dm.getMovimiento().getEmpleado() ) ) ), ProductoMapper.entidadADTO(dm.getProducto()) ) ).toList();
    }

    @Override
    public List<DetalleMovimientoResponseDTO> buscarcantidadmenor(Integer cantidad) {
        return DetalleMovimientoRepository.findByCantidadLessThan(cantidad).stream().map(dm -> DetalleMovimientoMapper.entidadADTO( dm, MovimientoMapper.entidadADTO( dm.getMovimiento(), EmpleadoMapper.entidadADTO( PersonaMapper.entidadADTO(dm.getMovimiento().getEmpleado().getPersona()), dm.getMovimiento().getEmpleado() ), BodegaMapper.entidadADTO( dm.getMovimiento().getBodegaOrigen(), EmpleadoMapper.entidadADTO( PersonaMapper.entidadADTO(dm.getMovimiento().getEmpleado().getPersona()), dm.getMovimiento().getEmpleado() ) ) ), ProductoMapper.entidadADTO(dm.getProducto()) ) ).toList();
    }
}

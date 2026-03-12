package com.s1.gestion_bodegas.mapper;


import com.s1.gestion_bodegas.dto.request.MovimientoRequestDTO;
import com.s1.gestion_bodegas.dto.response.BodegaResponseDTO;
import com.s1.gestion_bodegas.dto.response.EmpleadoResponseDTO;
import com.s1.gestion_bodegas.dto.response.MovimientoResponseDTO;
import com.s1.gestion_bodegas.model.Bodega;
import com.s1.gestion_bodegas.model.Empleado;
import com.s1.gestion_bodegas.model.Movimiento;
import org.springframework.stereotype.Component;

@Component
public class MovimientoMapper {
    public MovimientoResponseDTO entidadADTO(Movimiento movimiento, EmpleadoResponseDTO empleadodto,BodegaResponseDTO bodegadto) {
        if (movimiento == null  || empleadodto==null) return null;
        return new MovimientoResponseDTO(
                movimiento.getId(),
                movimiento.getFecha().toString(),
                movimiento.getTipomovimiento().name(),
                empleadodto,
                bodegadto,
                bodegadto


        );
    }

    public Movimiento DTOAEntidad(MovimientoRequestDTO dto , Empleado empleado,Bodega bodega) {
        if (dto == null|| empleado== null||bodega== null) return null;
        Movimiento m= new Movimiento() ;
        m.setFecha(dto.fecha());
        m.setTipomovimiento(dto.tipoMovimiento());
        m.setEmpleado(empleado);
        m.setBodegaOrigen(bodega);
        m.setBodegaDestino(bodega);
        return m;
    }

    public void actualizarEntidadDesdeDTO(Movimiento movimiento ,MovimientoRequestDTO dto ,Empleado empleado,Bodega bodega) {
        if (movimiento == null || dto==null ) return;
        movimiento.setFecha(dto.fecha());
        movimiento.setTipomovimiento(dto.tipoMovimiento());
        movimiento.setEmpleado(empleado);
        movimiento.setBodegaOrigen(bodega);
        movimiento.setBodegaDestino(bodega);
    }
}

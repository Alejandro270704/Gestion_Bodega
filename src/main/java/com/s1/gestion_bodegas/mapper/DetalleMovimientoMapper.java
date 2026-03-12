package com.s1.gestion_bodegas.mapper;

import com.s1.gestion_bodegas.dto.request.DetalleMovimientoRequestDTO;
import com.s1.gestion_bodegas.dto.response.*;
import com.s1.gestion_bodegas.model.*;
import org.springframework.stereotype.Component;

@Component
public class DetalleMovimientoMapper {
    public DetalleMovimientoResponseDTO entidadADTO(Detalle_movimiento detalleMovimiento, MovimientoResponseDTO movimientodto, ProductoResponseDTO productodto) {
        if (detalleMovimiento == null  || movimientodto==null|| productodto==null) return null;
        return new DetalleMovimientoResponseDTO(
                detalleMovimiento.getId(),
                movimientodto,
                productodto,
                detalleMovimiento.getCantidad()
        );
    }

    public Detalle_movimiento DTOAEntidad(DetalleMovimientoRequestDTO dto , Movimiento movimiento, Producto producto) {
        if (dto == null|| movimiento== null||producto== null) return null;
        Detalle_movimiento m= new Detalle_movimiento() ;
        m.setMovimiento(movimiento);
        m.setProducto(producto);
        m.setCantidad(dto.cantidad());
        return m;
    }

    public void actualizarEntidadDesdeDTO(Detalle_movimiento detalleMovimiento ,DetalleMovimientoRequestDTO dto ,Movimiento movimiento, Producto producto) {
        if (detalleMovimiento == null || movimiento== null||producto== null) return;
        detalleMovimiento.setMovimiento(movimiento);
        detalleMovimiento.setProducto(producto);
        detalleMovimiento.setCantidad(dto.cantidad());
    }
}
